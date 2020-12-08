package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.entity.TasksEntity;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 先暂时借用的类，查询未执行的任务
 */
public class HeartbeatManager6 {

    public static final String TAG = HeartbeatManager6.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager6 instance;
    public static HeartbeatManager6 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager6.class){
                if(instance == null) {
                    instance = new HeartbeatManager6();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager6() {
        mHandler = BaseApplication.getHandler();
    }

    public void start(){
        if (mRunnable == null) {
            mRunnable = new MyRunnable();
            mHandler.postDelayed(mRunnable, 0);
        }
    }

    public void stop(){
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            if (Contanst.status_hanxin == 1){
                List<Integer> condition = new ArrayList<>();
                condition.add(0);
                condition.add(1);
                HttpRequestManager.getInstance().tasks(condition,new SimpleHttpCallbackEntity<TasksEntity>() {

                    @Override
                    public void onSuccess(TasksEntity entity) {
                        EventBus.getDefault().post(entity);
                    }

                });
            }

            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
