package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;

import org.greenrobot.eventbus.EventBus;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 先暂时借用的类，轮询当前异常
 */
public class HeartbeatManager5 {

    public static final String TAG = HeartbeatManager5.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager5 instance;
    public static HeartbeatManager5 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager5.class){
                if(instance == null) {
                    instance = new HeartbeatManager5();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager5() {
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
            //韩信开启才轮询
            if (Contanst.status_hanxin == 1){
                HttpRequestManager.getInstance().get_error_code(new SimpleHttpCallbackEntity<GetErrorCodeResultEntity>() {

                    @Override
                    public void onSuccess(GetErrorCodeResultEntity entity) {
                        EventBus.getDefault().post(entity);
                    }

                });
            }

            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
