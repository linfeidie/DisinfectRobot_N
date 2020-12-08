package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;

import org.greenrobot.eventbus.EventBus;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 先暂时借用的类，轮询宾通当前任务状态
 */
public class HeartbeatManager4 {

    public static final String TAG = HeartbeatManager4.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager4 instance;
    public static HeartbeatManager4 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager4.class){
                if(instance == null) {
                    instance = new HeartbeatManager4();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager4() {
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
            if (Contanst.status_hanxin != 0){ //韩信关闭就不执行行了
                HttpRequestManager.getInstance().get_robot_perform_task(new SimpleHttpCallbackEntity<GetRobotPerformTaskEntity>() {

                    @Override
                    public void onSuccess(GetRobotPerformTaskEntity entity) {
                        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            EventBus.getDefault().post(entity);
                        }else{
                            onFailure(entity.getErrmsg());
                        }
                    }
                });
            }

            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
