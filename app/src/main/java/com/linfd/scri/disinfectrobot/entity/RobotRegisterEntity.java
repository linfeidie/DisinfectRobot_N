package com.linfd.scri.disinfectrobot.entity;
/*
* 注册机器人
* {
    "code": 100920,
    "data": {
        "angle": -0.004202,
        "node_id": 25,
        "x": 1.014389,
        "y": -0.009913
    },
    "message": "robot is far away from road node"
}
* */
public class RobotRegisterEntity extends BaseEntity {


    /**
     * data : {"angle":-0.004202,"node_id":25,"x":1.014389,"y":-0.009913}
     */

    //private DataBean data;

//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }

    public static class DataBean {
        /**
         * angle : -0.004202
         * node_id : 25
         * x : 1.014389
         * y : -0.009913
         */

        private double angle;
        private int node_id;
        private double x;
        private double y;

        public double getAngle() {
            return angle;
        }

        public void setAngle(double angle) {
            this.angle = angle;
        }

        public int getNode_id() {
            return node_id;
        }

        public void setNode_id(int node_id) {
            this.node_id = node_id;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}
