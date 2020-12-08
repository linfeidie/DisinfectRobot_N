package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
*
* 循环任务
* */
public class SetCycleActionEntity extends TypeEntity {

    /**
     * id : xxx
     * to_id : xxx
     * jump_to_id : 0
     * cycle_time : 0
     */

    private String id;
    private String to_id;
    private int jump_to_id;
    private int cycle_time;

    public SetCycleActionEntity() {
        this.setType(Contanst.set_cycle_action);
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

    public int getJump_to_id() {
        return jump_to_id;
    }

    public void setJump_to_id(int jump_to_id) {
        this.jump_to_id = jump_to_id;
    }

    public int getCycle_time() {
        return cycle_time;
    }

    public void setCycle_time(int cycle_time) {
        this.cycle_time = cycle_time;
    }
}
