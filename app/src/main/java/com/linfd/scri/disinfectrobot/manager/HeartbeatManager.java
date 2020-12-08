package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;
import android.os.HandlerThread;

import com.linfd.scri.disinfectrobot.Contanst;


/**注意  注意
 * 文件描述：.
 * <p>  心跳管理类 作用变了
 * 不断轮询和ros是否断开的监听  另开线程  可以做耗时操作
 *
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 */
public class HeartbeatManager {

    public static final String TAG = HeartbeatManager.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("check_connect");
    private static HeartbeatManager instance;
    public static HeartbeatManager getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager.class){
                if(instance == null) {
                    instance = new HeartbeatManager();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager() {
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    public void start(){
        if (mRunnable == null) {

            mRunnable = new MyRunnable();
            mHandler.postDelayed(mRunnable, 0);
        }
    }

    public void stop(){
        mHandler.removeCallbacks(mRunnable);
        mHandlerThread.quit();
        mRunnable = null;
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            boolean b = false;
            UdpControlSendManager.getInstance().set_heartbeat("b4f89c82-8d3f-4b15-b293-0c605678a537");
            mHandler.postDelayed(this, Contanst.HEARTBEAT);
        }
    }
}
