package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 设置消毒任务
* */
public class SetDisinActionEntity extends TypeEntity {


    /**
     "id":"xxx",
     "to_id":"xxx",
     "type":"set_disin_action",//消毒任务
     "disin_mode":"auto/manual",//消毒任务模式,auto自动覆盖消毒,manual手动定点消毒
     "spray":0,//喷雾开启，0,停止，１小，２大
     "loop_time":0,//循环次数0,-1无限循环,int
     "charge":true/false,//是否回充
     "action_id": 0,//任务id号,int,从0开始
     "follow":-1 //表示关联上一个任务,int,-1表示不关联,其他数值表示关联的任务id
     */

    private String id;
    private String to_id;
    private String disin_mode;
    private int spray;
    private int action_id;
    private int follow;
    private int loop_time;
    private boolean charge;

    public SetDisinActionEntity() {
        this.setType(Contanst.set_disin_action);
       // this.setSpray(2);
        this.setAction_id(0);
        this.setFollow(-1);
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

    public String getDisin_mode() {
        return disin_mode;
    }

    public void setDisin_mode(String disin_mode) {
        this.disin_mode = disin_mode;
    }

    public int getSpray() {
        return spray;
    }

    public void setSpray(int spray) {
        this.spray = spray;
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

    public int getLoop_time() {
        return loop_time;
    }

    public void setLoop_time(int loop_time) {
        this.loop_time = loop_time;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "SetDisinActionEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", disin_mode='" + disin_mode + '\'' +
                ", spray=" + spray +
                ", action_id=" + action_id +
                ", follow=" + follow +
                ", loop_time=" + loop_time +
                ", charge=" + charge +
                '}';
    }
}
