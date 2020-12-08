package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 充电座位置
* */
public class ChargerPoseCallbackEntity extends TypeEntity {


    /**
     * id : 02b01499-f501-4745-b601-43bc8737ed08
     * pose : [1.728138,-0.460928,0.2459,-0.02578017137204114]
     * state : 0
     * to_id : b4f89c82-8d3f-4b15-b293-0c605678a537
     */

    private String id;
    private boolean state;
    private String to_id;
    private List<Double> pose;


    public ChargerPoseCallbackEntity() {
        this.setType("charger_pose");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public List<Double> getPose() {
        return pose;
    }

    public void setPose(List<Double> pose) {
        this.pose = pose;
    }

    @Override
    public String toString() {
        return "ChargerPoseCallbackEntity{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", to_id='" + to_id + '\'' +
                ", pose=" + pose +
                '}';
    }
}
