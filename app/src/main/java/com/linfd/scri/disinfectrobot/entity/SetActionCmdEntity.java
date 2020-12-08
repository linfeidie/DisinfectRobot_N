package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 启动或停止任务队列
* */
public class SetActionCmdEntity extends TypeEntity {

    /**
     * id : xxx
     * to_id : xxx
     * cmd : start/stop/pause/resume/exit_cur
     * add_type : create/push_back
     */

    private String id;
    private String to_id;
    private String cmd;
    private String add_type;

    public SetActionCmdEntity() {
        this.setType(Contanst.set_action_cmd);
        this.setAdd_type("create");//默认
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

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getAdd_type() {
        return add_type;
    }

    public void setAdd_type(String add_type) {
        this.add_type = add_type;
    }
}
