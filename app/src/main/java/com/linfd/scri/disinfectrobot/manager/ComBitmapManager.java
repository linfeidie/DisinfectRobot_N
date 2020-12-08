package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.util.Log;


import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.R;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.eventbus.EventPoint;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 文件描述：.
 * <p>
 * 作者：Created by 林飞堞 on 2019/10/14  合成图片管理类
 * <p>
 * 版本号：Socket_learning
 */
public class ComBitmapManager {

    public static final String TAG = ComBitmapManager.class.getSimpleName();
    private static volatile ComBitmapManager ourInstance;
    private Bitmap mapBackground;
    private Bitmap mapLocation;
    private Bitmap mapComposite;
    private Bitmap chargingPost;//充电桩
    private CompositeMapListener listener;
    private List<Rect> points = new ArrayList<>(); //定点的点
    private Rect resetPoint ;//重定位的点
    private Matrix matrix = null;
    private Paint paint;//画描点的笔
    //private Canvas cv;
    public Path path;
    private Rect curRect;//记录当前多位置


    public static ComBitmapManager getInstance() {
        if (ourInstance == null) {
            synchronized (ComBitmapManager.class) {
                if (ourInstance == null) {
                    ourInstance = new ComBitmapManager();
                }
            }
        }
        return ourInstance;
    }

    private ComBitmapManager() {
        matrix = new Matrix();
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2f);
        paint.setAntiAlias(true);
        paint.setPathEffect(new CornerPathEffect(5));
        PathEffect effects = new DashPathEffect(new float[] { 1, 2, 4, 8}, 1);
        paint.setPathEffect(effects);
        EventBus.getDefault().register(this);

    }

/*
* 描点成线
* */
    public void addTouchPoint(Rect rect) {
        if (rect != null) {
            points.add(rect);
        }
    }
    /*
     *
     *设置重定位的点
     * */
    public void setResetPoint(Rect resetPoint) {
        this.resetPoint = resetPoint;
    }
/*
*  清除重定位点
*
* */
    public void clearResetPoint(){
        resetPoint = null;
    }

    /*
    *全部清除描点  但要保留第一个初始点
    * */
    public void clearPoints(){
        points = points.subList(0,1);
       // points.clear();
    }
    /*
     *全部清除描点  一个点也不留
     * */
    public void clearPoints2(){
         points.clear();
    }
/*
* 撤回最近一条
* */
    public void removePoints(){
        //只能撤到第二个 保留第一个
        if (points.size() == 1){
            return;
        }
        points.remove(points.size()-1);
    }

    /*
    *
    * 不等于空说明有定位点
    * */
    public boolean isHasResetPoint(){

        return resetPoint != null;
    }

    //开始合成  高频调用
    public void startComposite(Rect rect, float angle, CompositeMapListener listener) {
        obtainBitmap();
        mapComposite = toConformBitmap(rotateBitmap(mapBackground, 90), mapLocation, rect, angle);
        if (listener != null && mapComposite != null) {
            listener.compositeMapCallBack(mapComposite);
        }
    }

    /*
     * 获取背景图片和箭头
     * */
    File file;
    private void obtainBitmap() {
       // BGSelectorManager.getInstance().toggle();
        file = BGSelectorManager.getInstance().getBGFile();
        /*
        * hashcode 没有初始化 或者 hashcode不一样
        * */
        if(mapBackground == null || mapLocation == null || Contanst.MAP_HASHCODE == -1 || Contanst.MAP_HASHCODE != file.hashCode()) {
            Contanst.MAP_HASHCODE = file.hashCode();
            mapBackground = BitmapFactory.decodeFile(file.getAbsolutePath());
            mapLocation = BitmapFactory.decodeResource(BaseApplication.getApplication().getResources(), R.mipmap.jiantou); // 间接调用
            chargingPost = BitmapFactory.decodeResource(BaseApplication.getApplication().getResources(), R.mipmap.ic_harging_post);
            Log.e(TAG,"更换背景了");
        }

    }

    /*
     * 背景图和定位图结合
     * */
    //记录第一个描点
    boolean isRecord = false;//新的描点方法不需要了，如果需要设为真就好了
    private Bitmap toConformBitmap(Bitmap background, Bitmap foreground, Rect rect, float angle) {
        if (background == null) {
            return null;
        }
        curRect = rect;
        int bgWidth = background.getWidth();
        int bgHeight = background.getHeight();
        int fgWidth = foreground.getWidth();
        int fgHeight = foreground.getHeight();
        //create the new blank bitmap 创建一个新的和SRC长度宽度一样的位图
        Bitmap newbmp = Bitmap.createBitmap(bgWidth, bgHeight, Bitmap.Config.ARGB_8888);
        Canvas cv = new Canvas(newbmp);
        //draw bg into
        cv.drawBitmap(background, 0, 0, null);//在 0，0坐标开始画入bg
        //draw fg into
        cv.drawBitmap(adjustPhotoRotation(foreground, angle), rect.left - fgWidth / 2, rect.top - fgHeight / 2, null);//在 0，0坐标开始画入fg ，可以从任意位置画入
        //画充电桩位置
        if(BaseApplication.chargerect != null) {
            paint.setColor(Color.BLUE);
            //  cv.drawPoint(BaseApplication.chargerect.left, BaseApplication.chargerect.top, paint);
            cv.drawBitmap(Tools.drawableToBitmap(BaseApplication.getApplication().getResources().getDrawable(R.drawable.ic_harging_post)),BaseApplication.chargerect.left-8, BaseApplication.chargerect.top-8,null);
            // paint.setColor(Color.GREEN);
        }
        if (isRecord){
            /*
            * 第一次自动描点  要深度拷贝  坑得一逼  搞一天
            * */
            ComBitmapManager.getInstance().addTouchPoint((Rect) Tools.copy(rect));
            isRecord = false;
        }
        /*
        * 路径不是什么情况下都要画的  比如用户在描点的时候就不用画
        *
        * */
        if (BaseApplication.isdrawPaht){
            cv = DrawPathManager.getInstance().drawPath(cv);
        }

        //save all clip
//        cv.save(Canvas.ALL_SAVE_FLAG);//保存
//        //store
//        cv.restore();//存储adjustPhotoRotation(foreground,angle),

        if (points.size() > 1) {//描点的

//设置Path
            path = new Path();
            path.moveTo(points.get(0).left, points.get(0).top);//来到第一个位置
            for (int i = 1; i < points.size(); i++) {
                path.lineTo(points.get(i).left, points.get(i).top);
            }

            cv.drawPath(path, paint);
//            Float[] ff= points.toArray(new Float[points.size()]);
//            cv.drawLines(ff,paint);
        }
        if(resetPoint != null) {//是否有重定位点
            //paint.setColor(Color.BLUE);
            //cv.drawPoint(resetPoint.left, resetPoint.top, paint);
            cv.drawBitmap(Tools.drawableToBitmap(BaseApplication.getApplication().getResources().getDrawable(R.drawable.ic_flag_red)),resetPoint.left-5, resetPoint.top-48,null);
           // paint.setColor(Color.GREEN);
        }
        return newbmp;
    }

    /*
     * 对背景图旋转
     * */

    private Bitmap rotateBitmap(Bitmap origin, float alpha) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(alpha);
        matrix.postScale(1, -1);
        // 围绕原地进行旋转
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (newBM.equals(origin)) {
            return newBM;
        }
        //newBM.recycle();zj
        if (origin != null && !origin.isRecycled())//zj
        {
            origin=null;
        }
        //origin.recycle();
        return newBM;
    }

    public interface CompositeMapListener {
        void compositeMapCallBack(Bitmap mapComposite);
    }
/*
*
* 调整角度
* */
    private Bitmap adjustPhotoRotation(Bitmap bm, final float orientationDegree) {


        matrix.setRotate(-orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);

        try {
            Bitmap bm1 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);

            return bm1;

        } catch (OutOfMemoryError ex) {
        }
        return null;
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onReceiveMsg(EventPoint eventPoint) {
        if (curRect != null){
            ComBitmapManager.getInstance().addTouchPoint((Rect) Tools.copy(curRect));
        }


    }


}
