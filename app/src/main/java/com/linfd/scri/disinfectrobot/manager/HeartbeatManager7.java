package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
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
 * 先暂时借用的类，查询充电模式  手动还是自动
 */
public class HeartbeatManager7 {

    public static final String TAG = HeartbeatManager7.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager7 instance;
    public static HeartbeatManager7 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager7.class){
                if(instance == null) {
                    instance = new HeartbeatManager7();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager7() {
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
                BitoAPIManager.getInstance().get_charging_status();
            }
            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
