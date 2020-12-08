package com.linfd.scri.disinfectrobot.manager;


import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.RobotAckCallbackEntity;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

public class AckListenerService {

    public static AckListenerService instance;
    private  ACKListener mACKListener;
    private String ack_type;

    public static void  init(){
        instance = new AckListenerService();
    }

    public AckListenerService() {
        DataChanger.getInstance().addObserver(watcher);
    }
    private DataWatcher watcher= new DataWatcher(){
        @Override
        public void notifyUpdata(Object data) {
            if (data instanceof DataEntity) {
                DataEntity dataEntity = (DataEntity) data;
                if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.robot_ack)){
                    RobotAckCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),RobotAckCallbackEntity.class);
                    if (mACKListener != null && ack_type != null && ack_type.equalsIgnoreCase(entity.getAck_type())) {
                        mACKListener.onACK(entity.isState());
                        /*
                        * 得到一次就移除掉
                        * */
                       // removeACKListener();
                    }

                   // entity.getAck_type()

                }
            }
        }
    };

    public void addACKListener(String ack_type,ACKListener listener){
        this.ack_type = ack_type;
        this.mACKListener = listener;
    }
/*
* 这个要记得的主动调用
* */
    public void removeACKListener(){
        this.ack_type = "";
        this.mACKListener = null;
    }
     public interface ACKListener{
        void onACK(boolean isSuccess);
    }
}
