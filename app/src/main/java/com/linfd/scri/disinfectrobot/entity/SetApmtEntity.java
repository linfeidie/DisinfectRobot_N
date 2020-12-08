package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 设置预约任务
* */
public class SetApmtEntity extends TypeEntity {

    /**
     * id : xxx
     * to_id : xxx
     * action : add/del
     * time : 1578979892
     */

    private String id;
    private String to_id;
    private String action;
    private double time;

    public SetApmtEntity() {
        this.setType(Contanst.set_apmt);
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
