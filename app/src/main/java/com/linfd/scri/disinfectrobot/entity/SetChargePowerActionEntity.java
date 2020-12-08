package com.linfd.scri.disinfectrobot.entity;

import android.provider.SyncStateContract;

import com.linfd.scri.disinfectrobot.Contanst;

/*
* 对接充电任务
* */
public class SetChargePowerActionEntity extends TypeEntity {


    /**
     "id":"xxx",//本机uuid
     "to_id":"xxx",//要控制的uuid
     "type":"set_charge_power_action",//对接充电器任务
     "method":"head/tail/left/right",//对接方式头,尾,左侧,右侧
     "not_sleep": false,//充电时不要进入休眠
     "action_id": 0,//任务id号,int,从0开始
     "follow":-1 //表示关联上一个任务,int,-1表示不关联,其他数值表示关联的任务id
     */

    private String id;
    private String to_id;
    private String method;
    private boolean not_sleep;
    private int action_id;
    private int follow;

    public SetChargePowerActionEntity() {
        this.setType(Contanst.set_charge_power_action);
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isNot_sleep() {
        return not_sleep;
    }

    public void setNot_sleep(boolean not_sleep) {
        this.not_sleep = not_sleep;
    }

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }
}
