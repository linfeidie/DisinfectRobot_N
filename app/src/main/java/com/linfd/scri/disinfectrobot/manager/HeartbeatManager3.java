package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetHanxinStatusEntity;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;

import org.greenrobot.eventbus.EventBus;


/**
 * 文件描述：.
 * <p>  心跳管理类
 * 作者：Created by 林飞堞 on 2020/1/7
 * <p>
 * 版本号：donghaoProect
 * 先暂时借用的类，轮询韩信状态
 */
public class HeartbeatManager3 {

    private MyRunnable mRunnable;
    private Handler mHandler;
    private static HeartbeatManager3 instance;
    public static HeartbeatManager3 getInstance(){
        if(instance == null) {
            synchronized (HeartbeatManager3.class){
                if(instance == null) {
                    instance = new HeartbeatManager3();
                }
            }
        }
        return instance;
    }

    public HeartbeatManager3() {
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
            HttpRequestManager.getInstance().get_hanxin_status(new SimpleHttpCallbackEntity<GetHanxinStatusEntity>() {

                @Override
                public void onSuccess(GetHanxinStatusEntity entity) {
                    if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                        EventBus.getDefault().post(entity);
                    }else{
                        onFailure(entity.getErrmsg());
                    }

                }


            });
            mHandler.postDelayed(this, Contanst.CHARGEPOLLING);
        }
    }
}
