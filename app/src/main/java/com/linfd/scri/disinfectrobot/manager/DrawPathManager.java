package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;


import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.eventbus.Event2;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/*
* 绘制历史路径的管理类
* */
public class DrawPathManager {
    private static final DrawPathManager ourInstance = new DrawPathManager();
    private Paint paint;//画描点的笔

    private Path trailpath;//轨迹路径

    private List<Rect> trails = new ArrayList<>();//记录轨迹
    private List<Double> speed;
    private long time_stamp = 0;
    private long time_diff;//时间间隔
    private RobotStatusCallbackEntity satusEntity;
    private List<List<Double>> original_robot_poses; //存储服务器发来的未处理的定位数据

    public static DrawPathManager getInstance() {
        return ourInstance;
    }
    private DataWatcher watcher = new DataWatcher() {

        @Override
        public void notifyUpdata(Object data) {
            if (data instanceof DataEntity) {
                DataEntity dataEntity = (DataEntity) data;
                if (dataEntity.getType().equalsIgnoreCase(Contanst.robot_status)) {

                    try {
                         satusEntity = GsonUtil.GsonToBean(dataEntity.getMessage(), RobotStatusCallbackEntity.class);
                         speed = satusEntity.getSpeedReal();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("linfd", e.toString());
                       // Tools.showToast(e.toString());
                    }
                }
            }
        }
    };
    private DrawPathManager() {
        original_robot_poses = new ArrayList<>();
        if (!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }
        trailpath = new Path();
        paint = new Paint();
        paint.setColor(BaseApplication.getApplication().getResources().getColor(android.R.color.holo_red_light));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.5f);
        paint.setAntiAlias(true);
        //paint.setPathEffect(new CornerPathEffect(1));
        DataChanger.getInstance().addObserver(watcher);

    }
/*
* 主要方法
* */
    public Canvas drawPath(Canvas canvas){

        //线速度和角速度都其中一个不为0
        time_diff = System.currentTimeMillis() - time_stamp ;
        //或者集合没有点也加进去
        if ((speed != null && (speed.get(0) != 0 || speed.get(1) != 0) && time_diff > Contanst.DRAWPATHFREQUENCY) || trails.size() == 0){

            trails.add(HandlePositionHelper.handle(satusEntity.getRobot_pose_real()));
            //添加进去
            original_robot_poses.add(satusEntity.getRobot_pose_real());

            time_stamp = System.currentTimeMillis();
        }
        if (trails.size() == 0){
            return canvas;
        }
        //每次清除路径再画
        trailpath.reset();
        trailpath.moveTo(trails.get(0).left, trails.get(0).top);//来到第一个位置
        for (int i = 1; i < trails.size(); i++) {
            trailpath.lineTo(trails.get(i).left, trails.get(i).top);
        }
        canvas.drawPath(trailpath, paint);
        return canvas;
    }
    /*
    * 清除路径
    * */
    public void cleanTrails() {
        this.trails.clear();
    }

    /*
    * 宽高发生变化的监听
    * */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onReceiveMsg(Event2 entity) {
        /*
         * 服务器定位变成可以画的rect
         * */
        //把旧的定位清掉
        trails.clear();
        //宽高发生变化了  要从新计算定位
        for (int i = 0; i < original_robot_poses.size(); i++) {
            trails.add(HandlePositionHelper.handle(original_robot_poses.get(i)));
        }
    }
}
