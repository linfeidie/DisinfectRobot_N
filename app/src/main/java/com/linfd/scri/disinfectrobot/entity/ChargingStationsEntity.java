package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 查询所有⾃动充电桩信息
* */
public class ChargingStationsEntity extends BaseEntity {

    /**
     * code : 200
     * data : [{"agent_serial":"","charging_controller_serial":"","charging_station_serial":"cj02","connected_nodes":"101","connected_nodes_text":"A1","device_id":1,"id":1,"robot_pose_theta":-0.05,"robot_pose_x":-0.44,"robot_pose_y":-0.04,"status":0}]
     * msg : success
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * agent_serial :
         * charging_controller_serial :
         * charging_station_serial : cj02
         * connected_nodes : 101
         * connected_nodes_text : A1
         * device_id : 1
         * id : 1
         * robot_pose_theta : -0.05
         * robot_pose_x : -0.44
         * robot_pose_y : -0.04
         * status : 0
         */

        private String agent_serial;
        private String charging_controller_serial;
        private String charging_station_serial;
        private String connected_nodes;
        private String connected_nodes_text;
        private int device_id;
        private int id;
        private double robot_pose_theta;
        private double robot_pose_x;
        private double robot_pose_y;
        private int status;

        public String getAgent_serial() {
            return agent_serial;
        }

        public void setAgent_serial(String agent_serial) {
            this.agent_serial = agent_serial;
        }

        public String getCharging_controller_serial() {
            return charging_controller_serial;
        }

        public void setCharging_controller_serial(String charging_controller_serial) {
            this.charging_controller_serial = charging_controller_serial;
        }

        public String getCharging_station_serial() {
            return charging_station_serial;
        }

        public void setCharging_station_serial(String charging_station_serial) {
            this.charging_station_serial = charging_station_serial;
        }

        public String getConnected_nodes() {
            return connected_nodes;
        }

        public void setConnected_nodes(String connected_nodes) {
            this.connected_nodes = connected_nodes;
        }

        public String getConnected_nodes_text() {
            return connected_nodes_text;
        }

        public void setConnected_nodes_text(String connected_nodes_text) {
            this.connected_nodes_text = connected_nodes_text;
        }

        public int getDevice_id() {
            return device_id;
        }

        public void setDevice_id(int device_id) {
            this.device_id = device_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getRobot_pose_theta() {
            return robot_pose_theta;
        }

        public void setRobot_pose_theta(double robot_pose_theta) {
            this.robot_pose_theta = robot_pose_theta;
        }

        public double getRobot_pose_x() {
            return robot_pose_x;
        }

        public void setRobot_pose_x(double robot_pose_x) {
            this.robot_pose_x = robot_pose_x;
        }

        public double getRobot_pose_y() {
            return robot_pose_y;
        }

        public void setRobot_pose_y(double robot_pose_y) {
            this.robot_pose_y = robot_pose_y;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
