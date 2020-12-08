package com.linfd.scri.disinfectrobot.entity;

public class SetSaveMapEntity extends TypeEntity {

    public SetSaveMapEntity() {
        this.setType("set_save_map");
    }

    /**
     * id :
     * to_id :
     */


    private String id;
    private String to_id;

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
