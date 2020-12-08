package com.linfd.scri.disinfectrobot.manager;

import android.util.Log;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.entity.ApmtStateCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ChargerPoseCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.DesinStateCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionCodesCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.LoginCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.MachTypeCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.OnlineIdsCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.RobotAckCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.SetBindCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.SetHeartbeatCallbackEntity;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class GetFromServerData {

    public static void listener(){
        DataChanger.getInstance().addObserver(new DataWatcher() {
            @Override
            public void notifyUpdata(Object data) {
                if (data instanceof DataEntity) {
                    DataEntity dataEntity = (DataEntity) data;
                    // Tools.showToast(((DataEntity) data).getMessage());
                    if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.ser_ack_online))
                    {
                        LoginCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(), LoginCallbackEntity.class);
                        handleLogin(entity);

                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.ser_ack_online_ids)){
                        OnlineIdsCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),OnlineIdsCallbackEntity.class);
                        List<OnlineIdsCallbackEntity.IdMachBean> idMachBeans =  entity.getId_mach();
                        //tv_online.setText(idMachBeans.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.ser_ack_onbind)){
                        SetBindCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),SetBindCallbackEntity.class);
                        if (entity.getState().equalsIgnoreCase("true")){
                            Tools.showToast("绑定成功");
                        }else if(entity.getState().equalsIgnoreCase("true")){
                            Tools.showToast("绑定失败");
                        }
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.robot_status)){
                        RobotStatusCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),RobotStatusCallbackEntity.class);
                        if (entity != null){
                            EventBus.getDefault().post(entity);
                        }else{
                            Tools.showToast("异常：状态为空");
                        }

                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.ser_ack_heartbeat)){
                        SetHeartbeatCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),SetHeartbeatCallbackEntity.class);
                        Log.e(TAG,"心跳返回"+entity.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.disin_state)){
                        DesinStateCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),DesinStateCallbackEntity.class);
                        Log.e(TAG,"消毒状态返回"+entity.toString());
                        EventBus.getDefault().post(entity);
                    } else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.apmt_state)){
                        ApmtStateCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),ApmtStateCallbackEntity.class);
                        //showTest("预约状态返回"+entity.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.robot_ack)){
                        RobotAckCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),RobotAckCallbackEntity.class);
                       // showTest("ack返回"+entity.toString());
                        Log.e(TAG,"所有设置ack返回"+entity.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.mach_type)){
                        MachTypeCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),MachTypeCallbackEntity.class);
                        //showTest("机器人类型"+entity.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.charger_pose)){
                        //充电桩监听
                        ChargerPoseCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(),ChargerPoseCallbackEntity.class);
                        EventBus.getDefault().post(entity);
                        BaseApplication.chargerect = HandlePositionHelper.handle(entity.getPose());
//
                        Log.e(TAG, "充电座位置" + entity.toString()+Thread.currentThread().getName());
                        //showTest("充电座位置"+entity.toString());
                    }else if (((DataEntity) data).getType().equalsIgnoreCase(Contanst.exception_codes)){
                        ExceptionCodesCallbackEntity entity = GsonUtil.GsonToBean(dataEntity.getMessage(), ExceptionCodesCallbackEntity.class);
                        EventBus.getDefault().post(entity);
                        Log.e(TAG, "异常返回码" + entity.getCodes().toString());
                    }

                }
            }
        });
    }
    /*
     * 登录后操作
     * */
    private static void handleLogin(LoginCallbackEntity entity) {
        //启动心跳
        startHeartbreat(entity);
    }

    private static void startHeartbreat(LoginCallbackEntity entity) {
        if (entity.getState().equalsIgnoreCase(Contanst.TRUE)){
            HeartbeatManager.getInstance().start();
        }

    }
}
