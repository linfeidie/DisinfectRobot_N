package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

import java.util.List;

/*
* 预约状态返回
* */
public class ApmtStateCallbackEntity extends TypeEntity {

    /**
     * id : xxx
     * to_id : xxx
     * time : [1523423534]
     */

    private String id;
    private String to_id;
    private List<Integer> time;

    public ApmtStateCallbackEntity() {
        this.setType(Contanst.apmt_state);
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

    public List<Integer> getTime() {
        return time;
    }

    public void setTime(List<Integer> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ApmtStateCallbackEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", time=" + time +
                '}';
    }
}
