package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 获取消毒机器人状态
* */
public class GetDisinStateEntity extends TypeEntity {

    /**
     * id :
     * to_id :
     */

    private String id;
    private String to_id;

    public GetDisinStateEntity() {
        setType(Contanst.get_disin_state);
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
