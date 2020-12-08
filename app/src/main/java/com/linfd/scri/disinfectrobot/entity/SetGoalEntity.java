package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

import java.util.List;

/*
* 设置描点
* */
public class SetGoalEntity extends TypeEntity {


    /**
     {
     "id":"",
     "to_id":"",
     "type":"set_goal",
     "ui_pose":false,//true 表示使用界面的定位点,false 使用机器当前的定位点
     "goal":[0.1,0.1,0.0],//x,y,yaw,ui_pose = true时有效,
     "insert":0,//插入方法,0 新建/重新开始建立描点队列,1 插入到后面队列的后面,2 front 插入到描点队列的前面,
     }
     */

    private String id;
    private String to_id;
    private boolean ui_pose;
    private int insert;
    private List<Double> goal;

    public SetGoalEntity() {
        this.setType(Contanst.set_goal);
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

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public List<Double> getGoal() {
        return goal;
    }

    public void setGoal(List<Double> goal) {
        this.goal = goal;
    }
}
