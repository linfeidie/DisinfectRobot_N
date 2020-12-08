package com.linfd.scri.disinfectrobot.entity;


import com.linfd.scri.disinfectrobot.tools.Tools;

import java.util.ArrayList;
import java.util.List;

/*
 * 返回的机器人状态  注意：此类不要删  更新好了
 * */
public class RobotStatusCallbackEntity extends TypeEntity {

//  注意：此类不要删  更新好了
    /**
     "id":"xxx",//本机uuid
     "to_id":"xxx",//目标uuid
     "type":"robot_status",//机器人状态
     "localization":false,//false建图模式,true定位模式,默认false
     "action":"",//当前任务名称
     "action_id":1,//当前任务ids
     "action_state":0,//# 任务状态 0 idle ,1 running , 2 pause, 3 finish, 4 stoping
     "battery_percent":800,//int,实际电量需要除以10
     "charge_state": false,//true,表示正在充电
     "speed":[100,100],//int,[线速度，角速度] ,需要除以1000
     "robot_pose":[1000,2000,1000],//int,机器人坐标,x,y,z,yaw,需要除以1000
     "exception":false,//bool,true有异常/警告,false没有
     "stamp":1588923840.34235,//系统时间戳,double
     "map_update":1588923840.34235,//地图更新时间戳,单位dobule,
     "nav_state":0//导航状态 ,0正常,1重定位,2未准备好,3定位异常,int
     */

    private String id;
    private String to_id;
    private String action;
    private double battery_percent;
    private boolean exception;
    private double stamp;
    private double map_update;
    private List<Double> speed;
    private List<Double> speed_real = new ArrayList<>();//真正的  给外界调用的
    private List<Double> robot_pose;
    private List<Double> robot_pose_real = new ArrayList<>();//真正的  给外界调用的;
    private boolean localization;
    private int temperature;
    private int humidity;
    private int action_state;
    private boolean charge_state = false;
    private int nav_state;
    private int action_id;


    public int getNav_state() {
        return nav_state;
    }

    public void setNav_state(int nav_state) {
        this.nav_state = nav_state;
    }

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getBattery_percent() {
        return battery_percent;
    }

    public void setBattery_percent(double battery_percent) {
        this.battery_percent = battery_percent;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }

    public double getStamp() {
        return stamp;
    }

    public void setStamp(double stamp) {
        this.stamp = stamp;
    }

    public double getMap_update() {
        return map_update;
    }

    public void setMap_update(double map_update) {
        this.map_update = map_update;
    }

    public List<Double> getSpeed() {
        return speed;
    }
    public List<Double> getSpeedReal() {
        for (int i = 0; i < speed.size(); i++) {
            speed_real.add(i, (double) (speed.get(i)/1000));
        }
        return speed_real;
    }

    public void setSpeed(List<Double> speed) {
        this.speed = speed;
    }

    private List<Double> getRobot_pose() {
        return robot_pose;
    }
    /*
    * 调用这个方法要注意，最好不要频繁调用
    * */
    public List<Double> getRobot_pose_real() {
        robot_pose_real.clear();
        for (int i = 0; i < robot_pose.size(); i++) {
            robot_pose_real.add(i, (double) (robot_pose.get(i)/1000));
        }
        return robot_pose_real;
    }


    public void setRobot_pose(List<Double> robot_pose) {
        this.robot_pose = robot_pose;
    }
    /*
    * 1585552060.5534401 转 1585552060553
    * */
    public double get_hand_map_update(){
        return Tools.nami2mil(this.map_update);
    }

    /*
    * 去掉科学计数法 并转成了字符串
    * */
    public String get_hand_map_update_str(){
        return Tools.goaheadE(get_hand_map_update());
    }

    public boolean isLocalization() {
        return localization;
    }

    public void setLocalization(boolean localization) {
        this.localization = localization;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getAction_state() {
        return action_state;
    }

    public void setAction_state(int action_state) {
        this.action_state = action_state;
    }

    public boolean isCharge_state() {
        return charge_state;
    }

    public void setCharge_state(boolean charge_state) {
        this.charge_state = charge_state;
    }

    @Override
    public String toString() {
        return "RobotStatusCallbackEntity{" +
                "id='" + id + '\'' +
                ", to_id='" + to_id + '\'' +
                ", action='" + action + '\'' +
                ", battery_percent=" + battery_percent +
                ", exception=" + exception +
                ", stamp=" + stamp +
                ", map_update=" + map_update +
                ", speed=" + speed +
                ", speed_real=" + speed_real +
                ", robot_pose=" + robot_pose +
                ", robot_pose_real=" + robot_pose_real +
                ", localization=" + localization +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", action_state=" + action_state +
                ", charge_state=" + charge_state +
                '}';
    }
}
