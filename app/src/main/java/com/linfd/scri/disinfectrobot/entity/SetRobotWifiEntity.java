package com.linfd.scri.disinfectrobot.entity;

import com.linfd.scri.disinfectrobot.Contanst;
//设置机器人wifi连接
public class SetRobotWifiEntity extends TypeEntity {

    /**
     "id":"",
     "to_id":"",
     "type":"set_robot_wifi",
     "wifi_type":"hotspot",//wifi类型,"hotspot"自身发射热点,"ap"连接其他热点
     "action": "create",//"create"新建立一个热点或连接一个ap,"up"启动已连接的热点或ap,"down"关闭已连接的热点或ap(ps:up 已废弃)
     "passwd":"xxxxxxxx",//当类型为"ap"时有效
     "ssid":"xxxxxx",//当类型为"ap"时有效
     */

    private String id;
    private String to_id;
    private String wifi_type;
    private String action;
    private String passwd;
    private String ssid;

    public SetRobotWifiEntity() {
        this.setType(Contanst.set_robot_wifi);
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

    public String getWifi_type() {
        return wifi_type;
    }

    public void setWifi_type(String wifi_type) {
        this.wifi_type = wifi_type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }
}
