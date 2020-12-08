package com.linfd.scri.disinfectrobot.manager;


import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

/*
* 专门获取状态信息的时间戳
* */
public class ObtainStatusStamp {
/*
*
* */
    public String map_update ;//时间戳
    public static ObtainStatusStamp instacne;

    public static void  init(){
        instacne = new ObtainStatusStamp();
    };

    public ObtainStatusStamp() {
        DataChanger.getInstance().addObserver(watcher);
    }

    private DataWatcher watcher= new DataWatcher(){
        @Override
        public void notifyUpdata(Object data) {
            if (data instanceof DataEntity) {
                DataEntity dataEntity = (DataEntity) data;
                if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.robot_status)){
                    RobotStatusCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),RobotStatusCallbackEntity.class);
                    if (entity != null){
                        map_update = entity.get_hand_map_update_str();
                    }
                }
            }
        }
    };
}
