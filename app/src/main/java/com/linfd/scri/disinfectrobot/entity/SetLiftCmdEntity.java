package com.linfd.scri.disinfectrobot.entity;

import com.linfd.scri.disinfectrobot.Contanst;

/*
* 设置顶升设备命令
* */
public class SetLiftCmdEntity extends TypeEntity {

    /**
     "id":"",
     "to_id":"",
     "type":"set_lift_cmd",
     "updown":0,//0无动作,1下降,2上升
     "turn":0,//顶升旋转,0不旋转,1旋转,默认0
     */

    private String id;
    private String to_id;
    private int updown;
    private int turn;

    public SetLiftCmdEntity() {
        setType(Contanst.set_lift_cmd);
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

    public int getUpdown() {
        return updown;
    }

    public void setUpdown(int updown) {
        this.updown = updown;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
