package com.linfd.scri.disinfectrobot.entity;

import com.linfd.scri.disinfectrobot.Contanst;

/*
* 获取异常代码
* */
public class GetRobotExceptionEntity extends TypeEntity{

    /**
     * id : xxx
     * to_id : xxx
     */

    private String id;
    private String to_id;

    public GetRobotExceptionEntity() {
        this.setType(Contanst.get_robot_exception);
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
