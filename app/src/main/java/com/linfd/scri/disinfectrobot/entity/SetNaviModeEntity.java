package com.linfd.scri.disinfectrobot.entity;

/*
*设置机器人导航模式
* */
public class SetNaviModeEntity extends TypeEntity {

    /**
     * id :
     * to_id :
     * localization : false
     */

    private String id;
    private String to_id;
    private boolean localization;

    public SetNaviModeEntity() {
        this.setType("set_navi_mode");
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

    public boolean isLocalization() {
        return localization;
    }

    public void setLocalization(boolean localization) {
        this.localization = localization;
    }
}
