package com.linfd.scri.disinfectrobot.entity;

/*
*   消毒状态返回
* \*/
public class DesinStateCallbackEntity extends TypeEntity {


    /**
     * {
     * "id":"xxx",
     * "to_id":"",
     * "type":"desin_state",
     * "spray_level":0,//喷雾强度，０没有强度，１小，２大
     * "box_spary":0,//雾化器液位，０无，1低，2高
     * "box_store":0,//蓄水室液位，０无，1低，2高
     * "disin_time":0,//消毒时间,单位秒
     * "disin_area":0//消毒面积,单位平方米
     * }
     */

    private String id;
    private String to_id;
    private int spray_level;
    private int box_spray;
    private int box_store;
    private double disin_time;
    private int disin_area;

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

    public int getSpray_level() {
        return spray_level;
    }

    public void setSpray_level(int spray_level) {
        this.spray_level = spray_level;
    }

    public int getBox_spary() {
        return box_spray;
    }

    public void setBox_spary(int box_spary) {
        this.box_spray = box_spary;
    }

    public int getBox_store() {
        return box_store;
    }

    public void setBox_store(int box_store) {
        this.box_store = box_store;
    }

    public double getDisin_time() {
        return disin_time;
    }

    public void setDisin_time(double disin_time) {
        this.disin_time = disin_time;
    }

    public int getDisin_area() {
        return disin_area;
    }

    public void setDisin_area(int disin_area) {
        this.disin_area = disin_area;
    }

    @Override
    public String toString() {
        return "DesinStateCallbackEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", spray_level=" + spray_level +
                ", box_spary=" + box_spray +
                ", box_store=" + box_store +
                ", disin_time=" + disin_time +
                ", disin_area=" + disin_area +
                '}';
    }
}
