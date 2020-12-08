package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.LooperRunnable;

/*
* 轮询获取状态 和消毒状态  应该要分离一下，但是轮询框架有问题
* */
public class LooperStatusService {

    public static void  obtainStatus(){
        LooperRunnable r = new LooperRunnable() {
            @Override
            public void call() {
                UdpControlSendManager.getInstance().get_robot_status(Contanst.id,Contanst.to_id);
                UdpControlSendManager.getInstance().get_disin_state(Contanst.id,Contanst.to_id);
            }
        };

        TimerManager.getInstance().start(r);
    }
}
