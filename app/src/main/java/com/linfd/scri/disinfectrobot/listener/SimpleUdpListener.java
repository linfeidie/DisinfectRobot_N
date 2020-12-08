package com.linfd.scri.disinfectrobot.listener;

import android.text.TextUtils;

import com.blanke.xsocket.udp.client.XUdp;
import com.blanke.xsocket.udp.client.bean.UdpMsg;
import com.blanke.xsocket.udp.client.listener.UdpClientListener;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.TypeEntity;
import com.linfd.scri.disinfectrobot.manager.ControlDirectionManager;
import com.linfd.scri.disinfectrobot.observer.DataChanger;


/*
* 减少一些接口
* */
public  class SimpleUdpListener implements UdpClientListener {
    public static final String TAG = SimpleUdpListener.class.getSimpleName();
    public  DataEntity dataEntity;
    public static boolean isDisconnectRos = true;

    public DataEntity getDataEntity() {
        return dataEntity;
    }

    public SimpleUdpListener() {
        dataEntity = new DataEntity();
    }

    @Override
    public void onStarted(XUdp XUdp) {
    }

    @Override
    public void onStoped(XUdp XUdp) {
    }

    @Override
    public void onSended(XUdp XUdp, UdpMsg udpMsg) {
    }

    @Override
    public  void onReceive(XUdp client, final UdpMsg udpMsg){
        // 接口返回数据  传给观察者
//        ThreadManager.getInstance().createLongPool().execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        TypeEntity entity = GsonUtil.GsonToBean(udpMsg.getSourceDataString(), TypeEntity.class);
        if (!TextUtils.isEmpty(entity.getType())){
            dataEntity.setType(entity.getType());
            dataEntity.setMessage(udpMsg.getSourceDataString());
            ControlDirectionManager.getInstance().dataEntity = (DataEntity)Tools.deeplyCopy(dataEntity);
            //这里分发
            DataChanger.getInstance().postData(dataEntity);

        }
    } ;

    @Override
    public void onError(XUdp client, String msg, Exception e){
        Tools.showToast(e.getMessage());
       // Log.e(TAG,"返回错误数据："+e.toString());
    }
}
