package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.DataEntity;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 控制方向的管理类
 */
public class ControlDirectionManager {

    private MyRunnable mRunnable;
    private Handler mHandler;
    public  DataEntity dataEntity;
    private static ControlDirectionManager instance;
    public static ControlDirectionManager getInstance(){
        if(instance == null) {
            synchronized (ControlDirectionManager.class){
                if(instance == null) {
                    instance = new ControlDirectionManager();
                }
            }
        }
        return instance;
    }

    public ControlDirectionManager() {
        mHandler = BaseApplication.getHandler();
    }

    public void start(Direct direct){
        if (mRunnable == null) {
            mRunnable = new MyRunnable(direct);
            mHandler.postDelayed(mRunnable, 0);
        }
    }

    public void stop(){
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
    }

    private class MyRunnable implements Runnable {
        Direct mDirect;
        public MyRunnable(Direct direct) {
            mDirect = direct;
        }

        @Override
        public void run() {
           // if (mDirect == Direct.rightward)
            switch (mDirect){
                case leftward:
                    UdpControlSendManager.getInstance().leftward(Contanst.id,Contanst.to_id, 0.3);
                    break;
                case forward:
                    UdpControlSendManager.getInstance().forward(Contanst.id,Contanst.to_id, 0.1);
                    break;
                case rightward:
                    UdpControlSendManager.getInstance().rightward(Contanst.id,Contanst.to_id, 0.3);
                    break;
                case backward:
                    UdpControlSendManager.getInstance().backward(Contanst.id,Contanst.to_id, 0.1);
                    break;
                default:
                    //Tools.showToast("111");

            }
            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }

    public static enum Direct{
        leftward,forward,rightward,backward;
    }
}
