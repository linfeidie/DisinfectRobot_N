package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

public class SetInitPoseEntity extends TypeEntity {

    /**
     * id :
     * to_id :
     * pose : [0,0,0,0]
     */

    private String id;
    private String to_id;
    private List<Double> pose;

    public SetInitPoseEntity() {
        setType("set_init_pose");
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

    public List<Double> getPose() {
        return pose;
    }

    public void setPose(List<Double> pose) {
        this.pose = pose;
    }

    @Override
    public String toString() {
        return "SetInitPoseEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", pose=" + pose +
                '}';
    }
}
