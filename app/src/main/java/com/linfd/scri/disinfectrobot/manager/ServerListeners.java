package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.listener.SimpleUdpListener;
/*
* 注册了才能接收到服务器的回调
* */
public class ServerListeners {

    public static void register(){
        UdpControlSendManager.getInstance().addUdpClientListener(new SimpleUdpListener());
    }
}
