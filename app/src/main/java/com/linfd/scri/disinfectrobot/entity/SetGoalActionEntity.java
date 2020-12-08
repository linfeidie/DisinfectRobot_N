package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

import java.util.List;

/*
*设置目标点任务
* */
public class SetGoalActionEntity extends TypeEntity {


    /**
     {
     "id":"xxx",//本机uuid
     "to_id":"xxx",//要控制的uuid
     "type":"set_goal_action",//目标点任务
     "ui_pose":false,//true 表示使用界面的定位点,false 使用机器当前的定位点
     "goal":[0.1,0.1,0.0],//x,y,yaw,ui_pose = true时有效,
     "goal_id":1,//目标点id
     "move_type":"flex/stiff",//flex灵活的路线,stiff固定的路线
     "max_l":0.3,//最大允许的线速度
     "max_a":0.3,//最大允许的角速度
     "time_out":1.0,//任务超时 单位秒,0:表示没有超时,
     "action_id": 0,//任务id号,int,从0开始
     "follow":-1 //表示关联上一个任务,int,-1表示不关联,其他数值表示关联的任务id号
     }
     */

    private String id;
    private String to_id;
    private boolean ui_pose;
    private int goal_id;
    private String move_type;
    private double max_l;
    private double max_a;
    private double time_out;
    private int action_id;
    private int follow;
    private List<Double> goal;

    public SetGoalActionEntity() {
        this.setType(Contanst.set_goal_action);
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

    public boolean isUi_pose() {
        return ui_pose;
    }

    public void setUi_pose(boolean ui_pose) {
        this.ui_pose = ui_pose;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public String getMove_type() {
        return move_type;
    }

    public void setMove_type(String move_type) {
        this.move_type = move_type;
    }

    public double getMax_l() {
        return max_l;
    }

    public void setMax_l(double max_l) {
        this.max_l = max_l;
    }

    public double getMax_a() {
        return max_a;
    }

    public void setMax_a(double max_a) {
        this.max_a = max_a;
    }

    public double getTime_out() {
        return time_out;
    }

    public void setTime_out(double time_out) {
        this.time_out = time_out;
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

    public List<Double> getGoal() {
        return goal;
    }

    public void setGoal(List<Double> goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "SetGoalActionEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", ui_pose=" + ui_pose +
                ", goal_id=" + goal_id +
                ", move_type='" + move_type + '\'' +
                ", max_l=" + max_l +
                ", max_a=" + max_a +
                ", time_out=" + time_out +
                ", action_id=" + action_id +
                ", follow=" + follow +
                ", goal=" + goal +
                '}';
    }
}
