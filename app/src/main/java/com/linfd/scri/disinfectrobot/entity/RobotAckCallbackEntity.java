package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 所有设置返回
* */
public class RobotAckCallbackEntity extends TypeEntity {

    /**
     * id : xxx
     * to_id : xxx
     * ack_type :
     * state : true
     */

    private String id;
    private String to_id;
    private String ack_type;
    private boolean state;

    public RobotAckCallbackEntity() {
        this.setType(Contanst.robot_ack);
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

    public String getAck_type() {
        return ack_type;
    }

    public void setAck_type(String ack_type) {
        this.ack_type = ack_type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RobotAckCallbackEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", ack_type='" + ack_type + '\'' +
                ", state=" + state +
                '}';
    }
}
