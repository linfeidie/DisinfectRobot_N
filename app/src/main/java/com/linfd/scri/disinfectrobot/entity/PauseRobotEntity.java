package com.linfd.scri.disinfectrobot.entity;

/*
* 暂停机器人
* */
public class PauseRobotEntity extends BaseEntity {

    /**
     * nickname : sim_1
     * serial : yg00a00017071020003n00
     */

    private String nickname;
    private String serial;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
