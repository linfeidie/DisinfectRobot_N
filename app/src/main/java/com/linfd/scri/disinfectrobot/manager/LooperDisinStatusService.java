package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.LooperRunnable;

public class LooperDisinStatusService {
    public static void  obtainStatus(){
        LooperRunnable r = new LooperRunnable() {
            @Override
            public void call() {
                UdpControlSendManager.getInstance().get_disin_state(Contanst.id,Contanst.to_id);
            }
        };

        TimerManager.getInstance().start(r);
    }
}
