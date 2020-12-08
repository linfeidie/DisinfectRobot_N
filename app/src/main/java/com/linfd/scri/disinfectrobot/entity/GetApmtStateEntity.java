package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 获取预约状态
* */
public class GetApmtStateEntity extends TypeEntity {

    /**
     * id :
     * to_id :
     */

    private String id;
    private String to_id;

    public GetApmtStateEntity() {
        this.setType(Contanst.get_apmt_state);
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
}
