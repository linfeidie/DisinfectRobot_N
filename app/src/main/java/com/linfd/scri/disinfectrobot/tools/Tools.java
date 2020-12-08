package com.linfd.scri.disinfectrobot.tools;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * 文件描述：.
 * <p> 一些常用工具类
 * 作者：Created by 林飞堞 on 2019/10/23
 * <p>
 * 版本号：donghaoProect
 */
public class Tools {
    private static Toast mToast;
    public static final boolean isDebug = true;

    public static void showToast(String message) {

        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getApplication(), message,
                    Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        if (isDebug) {
            mToast.show();
        }

    }

    public static void runOnUiThread(Runnable runnable) {
        // 在主线程运行
        if (android.os.Process.myTid() == BaseApplication.getMainTid()) {
            runnable.run();
        } else {
            //获取handler
            BaseApplication.getHandler().post(runnable);
        }
    }

    //集合里过滤掉所有负整数
    public static <T> List<Integer> positive_number(List<Integer> list) {
        List<Integer> rList = new ArrayList<>();
        if (list != null && list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > 0) {
                    rList.add(list.get(i));
                }
            }
        }
        ((ArrayList<T>) rList).trimToSize();//释放申请的多余的空间
        return rList;
    }

    /**
     * Drawable转换成一个Bitmap
     *
     * @param drawable drawable对象
     * @return
     */
    public static final Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /*
     * 去掉科学计数法的E
     * */
    public static String goaheadE(double src) {
        NumberFormat nf = NumberFormat.getInstance();
        //设置保留多少位小数
        nf.setMaximumFractionDigits(0);
        // 取消科学计数法
        nf.setGroupingUsed(false);
        return nf.format(src);
    }

    /*
     * 纳米转毫米  仅针对业务(例子：1585552060.5534401 转 1585552060553)
     * */
    public static double nami2mil(double map_update) {
        String updateStr = String.format("%.3f", map_update);

        return Double.parseDouble(updateStr.replace(".", ""));
    }

    /**
     * 19      * 时间戳转换成字符串
     * 20
     */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }

    /**
     * 从sd卡获取图片资源
     * @return
     */
    public static List<String> getImagePathFromSD() {
        // 图片列表
        List<String> imagePathList = new ArrayList<String>();
        // 得到sd卡内image文件夹的路径   File.separator(/)
        String filePath = Contanst.CACHE_DIR;
        // 得到该路径文件夹下所有的文件
        File fileAll = new File(filePath);
        File[] files = fileAll.listFiles();
        // 将所有的文件存入ArrayList中,并过滤所有图片格式的文件
        if (files == null || files.length == 0){
            return null;
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (checkIsImageFile(file.getPath())) {
                imagePathList.add(file.getPath());
            }
        }
       //换顺序  由近往远
        Collections.reverse(imagePathList);
        // 返回得到的图片列表
        return imagePathList;
    }
    /*
    * 删掉过旧的图片
    * */
    public static List<String> usefulFiles(){
        List<String> pathList = getImagePathFromSD();
        if (pathList == null){
            return null;
        }
        List<String> newpath = new ArrayList<>();
        File f;
        String fName;//不带后缀的文件名
        for (int i = 0; i < pathList.size(); i++) {
            f= new File(pathList.get(i));
            fName = getFileNameNoEx(f.getName());
            BigInteger a=new BigInteger(fName);
            BigInteger b=new BigInteger(goaheadE(historyTimeStamp()));
            if (a.compareTo(b) > 0){
                newpath.add(pathList.get(i));
            }else {
                f.delete();
            }
        }
        return newpath;
    }

    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
    private static boolean checkIsImageFile(String fName) {
        boolean isImageFile = false;
        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("png") || FileEnd.equals("gif")
                || FileEnd.equals("jpeg")|| FileEnd.equals("bmp") ) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }

    public static String timeStamp2Date(String time) {
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isExistSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/linfd";
            File sd = new File(path);
            try {
                sd.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sd.canWrite();
        } else
            return false;
    }

    /*
    * 获取文件夹下的文件名（只有一个文件） ps  仅针对本项目业务
    * 获取最近文件下的文件名
    * */
    public static String obtainFileName(String dirpath){
        File dir = new File(dirpath);
        if (!dir.exists() || dir.isFile()){
            return "";
        }
        File[] array = dir.listFiles();
        String fileName = "";
        if (array.length > 0){
            fileName = array[0].getName();
        }
        return  fileName;
    }

    public static String obtainHistoryFileName(){
        return  obtainFileName(Contanst.CACHE_DIR);
    }
        /*
        * 获取N天前时间戳
        * */
    public static double historyTimeStamp(){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -1);//可编辑
        //String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
        return now.getTimeInMillis();

    }

    /*
    *获取图片的宽高 返回宽和高 在一个集合里 否则返回0，0
    * */
    public static List<Integer> getMapWH(String filePath){
         List<Integer> WH = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        if (bitmap != null){
            WH.add(0,bitmap.getWidth());
            WH.add(1,bitmap.getHeight());
        }else{
            WH.add(0,0);
            WH.add(1,0);
        }
        return WH;
    }

    private static boolean isStatusbarVisible(Activity activity) {
        int uiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
        boolean isStatusbarHide = ((uiOptions | View.SYSTEM_UI_FLAG_FULLSCREEN) == uiOptions);
        return !isStatusbarHide;
    }

    public static void hideStatusBar(Activity activity) {
        if (isStatusbarVisible(activity)) {
            int uiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
            uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        }
    }
    /*
     * 实现了Parcelable对象的深度拷贝
     * */
    public static <T> T copy(Parcelable input) {
        Parcel parcel = null;

        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable(input, 0);

            parcel.setDataPosition(0);
            return parcel.readParcelable(input.getClass().getClassLoader());
        } finally {
            parcel.recycle();
        }
    }

    public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  3000 ;  //超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
        // 当返回值是true时，说明host是可用的，false则不可。
        return status;
    }


    /*
    * 实现了Serializable对象的深度拷贝
    * */
    public static Object deeplyCopy(Serializable obj) {
        try {
            return bytes2object(object2bytes(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] object2bytes(Serializable obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object bytes2object(byte[] bytes) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Android 音乐播放器应用里，读出的音乐时长为 long 类型以毫秒数为单位，例如：将 234736 转化为分钟和秒应为 03:55 （包含四舍五入）
     * @param duration 音乐时长
     * @return
     */
    public static String timeParse(long duration) {
        String time = "" ;
        long minute = duration / 60000 ;
        long seconds = duration % 60000 ;
        long second = Math.round((float)seconds/1000) ;
        if( minute < 10 ){
            time += "0" ;
        }
        time += minute+":" ;
        if( second < 10 ){
            time += "0" ;
        }
        time += second ;
        return time ;
    }



}
