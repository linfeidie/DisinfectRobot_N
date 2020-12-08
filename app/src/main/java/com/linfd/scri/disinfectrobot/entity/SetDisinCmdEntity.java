package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

/*
* 设置消毒设备命令  与任务隔离
* */
public class SetDisinCmdEntity extends TypeEntity {


    /**
     {
     "id":"xxx",
     "to_id


     ":"xxx",
     "type":"set_disin_cmd",


     "cmd":0,//0无,1自动消毒,2清空雾化室的蓄水,3 手动喷雾
     "spray_level":0,//喷雾开启,0,无动作,1小,2大
     }
     */

    private String id;
    private String to_id;
    private int cmd;
    private int spray_level;

    public SetDisinCmdEntity() {
        this.setType(Contanst.set_disin_cmd);
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

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getSpray_level() {
        return spray_level;
    }

    public void setSpray_level(int spray_level) {
        this.spray_level = spray_level;
    }

    @Override
    public String toString() {
        return "SetDisinCmdEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", cmd=" + cmd +
                ", spray_level=" + spray_level +
                '}';
    }
}
