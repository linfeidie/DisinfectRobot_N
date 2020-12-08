package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.eventbus.EventConnect;
import com.linfd.scri.disinfectrobot.listener.SimpleUdpListener;

import org.greenrobot.eventbus.EventBus;


/**
 * 注意  注意
 * 文件描述：.
 * <p>  心跳管理类 作用变了
 * 不断轮询和ros是否断开的监听  另开线程  可以做耗时操作
 * <p>
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 */
public class CompareEntityManager {

    public static final String TAG = CompareEntityManager.class.getSimpleName();
    private MyRunnable mRunnable;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("check_connect");
    private static CompareEntityManager instance;

    public static CompareEntityManager getInstance() {
        if (instance == null) {
            synchronized (CompareEntityManager.class) {
                if (instance == null) {
                    instance = new CompareEntityManager();
                }
            }
        }
        return instance;
    }

    public CompareEntityManager() {
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    public void start() {
        if (mRunnable == null) {

            mRunnable = new MyRunnable();
            mHandler.postDelayed(mRunnable, 0);
        }
    }

    public void stop() {
        mHandler.removeCallbacks(mRunnable);
        mHandlerThread.quit();
        mRunnable = null;
    }

    private class MyRunnable implements Runnable {
        DataEntity mfreshly;
        DataEntity mold;
        EventConnect event = new EventConnect();


        @Override
        public void run() {

            mfreshly = ControlDirectionManager.getInstance().dataEntity;
            if (mfreshly == null) {
                event.isConnect = false;
                EventBus.getDefault().post(event);
            }
            //不知道为什么2个disin_state会判断为相同 所以暂时把disin_state去除掉
            if (mfreshly != null && !mfreshly.getType().equalsIgnoreCase("disin_state")) {
                if (mold != null) {
                    Log.e(TAG, "4444" + mfreshly.equals(mold));
                    Log.e(TAG, mfreshly.getType());
                    Log.e(TAG, mold.getType());
                    //如果是相同就代表断开了
                    event.isConnect = !mfreshly.equals(mold);
                    EventBus.getDefault().post(event);
                }

                mold = mfreshly;
            }


            mHandler.postDelayed(this, 3000);
        }
    }

}
