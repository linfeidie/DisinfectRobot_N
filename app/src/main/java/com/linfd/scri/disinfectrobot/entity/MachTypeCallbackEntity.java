package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.Contanst;

public class MachTypeCallbackEntity extends TypeEntity {

    /**
     * id : xx
     * to_id : xxx
     * mach_type : 0
     */

    private String id;
    private String to_id;
    private int mach_type;

    public MachTypeCallbackEntity() {
        this.setType(Contanst.mach_type);
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

    public int getMach_type() {
        return mach_type;
    }

    public void setMach_type(int mach_type) {
        this.mach_type = mach_type;
    }

    @Override
    public String toString() {
        return "MachTypeCallbackEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", mach_type=" + mach_type +
                '}';
    }
}
