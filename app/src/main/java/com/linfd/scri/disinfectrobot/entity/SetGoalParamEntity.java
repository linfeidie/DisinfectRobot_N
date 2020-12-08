package com.linfd.scri.disinfectrobot.entity;

import com.linfd.scri.disinfectrobot.Contanst;

/*
* 设置描点参数
* */
public class SetGoalParamEntity extends TypeEntity {

    /**
     "id":"",
     "to_id":"",
     "type":"set_goal_param",
     "goal_type":"import",//"import"取货,"export"发货
     "goal_id":0 //描点id,从0开始 int
     */

    private String id;
    private String to_id;
    private String goal_type;
    private int goal_id;

    public SetGoalParamEntity() {
        this.setType(Contanst.set_goal_param);
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

    public String getGoal_type() {
        return goal_type;
    }

    public void setGoal_type(String goal_type) {
        this.goal_type = goal_type;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }
}
