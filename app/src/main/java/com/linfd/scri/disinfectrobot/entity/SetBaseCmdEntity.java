package com.linfd.scri.disinfectrobot.entity;

/*
*设置底盘命令
* */


import com.linfd.scri.disinfectrobot.Contanst;

public class SetBaseCmdEntity extends TypeEntity {

    /**
     {
     "id":"",
     "to_id":"",
     "type":"set_base_cmd",
     "power":0,//底盘电源,0无动作,1关机,2休眠
     "ext_power":false,//设置外部电源开关,true
     "motor_lock":false,//电机锁开关
     "obs_disable":false,//失能红外/超声波
     "charge_enable": false,//充电使能
     "charger_dock_enable": false,//充电桩使能
     }
     */

    private String id;
    private String to_id;
    private int power;
//    private boolean ext_power;
    private int  motor_lock;
//    private boolean obs_enable;
    private int charge_enable;
//    private boolean charger_dock_enable;

    public SetBaseCmdEntity() {
        this.setType(Contanst.set_base_cmd);
//        this.setMotor_lock(false);
//        this.setObs_enable(false);
//        this.setExt_power(false);
//        this.setCharger_dock_enable(false);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }




    public void setCharge_enable(int charge_enable) {
        this.charge_enable = charge_enable;
    }

    public int getMotor_lock() {
        return motor_lock;
    }

    public void setMotor_lock(int motor_lock) {
        this.motor_lock = motor_lock;
    }
}
