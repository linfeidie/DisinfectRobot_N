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
 * 先暂时借用的类，轮询是否有充电桩
 */
public class HeartbeatManager2 {

    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager2 instance;
    public static HeartbeatManager2 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager2.class){
                if(instance == null) {
                    instance = new HeartbeatManager2();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager2() {
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
            //充电桩
            UdpControlSendManager.getInstance().get_charger_pose(Contanst.id,Contanst.to_id);
            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
