package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 先暂时借用的类  查询任务信息 -根据任务id  暂时作用是
 */
public class HeartbeatManager8 {

    public static final String TAG = HeartbeatManager8.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager8 instance;
    public static HeartbeatManager8 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager8.class){
                if(instance == null) {
                    instance = new HeartbeatManager8();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager8() {
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
            /*
            * 韩信开始才轮询
            * */
            if (Contanst.status_hanxin == 1){
                BitoAPIManager.getInstance().get_task(Contanst.man_add_task_id);
            }
            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
