package com.linfd.scri.disinfectrobot.entity;

import java.util.List;
/*
* system - 查询dtc codes

 * */
public class DtcCodesEntity extends BaseEntity {

    /**
     * data : {"count":1434,"levels":[10,20,30,2],"list":[{"create_time":"2020-12-11 12:14:25","dtc_code":"B0LP010002","dtc_id":4341,"info":"轨迹运行中检测到近处有障碍物","instruction":"移除障碍物","last_update_time":"2020-12-11 12:14:34","level":10,"nickname":"yg00sh8020103119000000","recoverable":"Y","robot_origin":"yg00sh8020103119000000","status":"resolved"},{"create_time":"2020-12-11 12:14:25","dtc_code":"B0IB010001","dtc_id":4340,"info":"软急停(monitor)","instruction":"请按提示修复异常或按复位键","last_update_time":"2020-12-11 12:14:34","level":10,"nickname":"yg00sh8020103119000000","recoverable":"Y","robot_origin":"yg00sh8020103119000000","status":"resolved"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * count : 1434
         * levels : [10,20,30,2]
         * list : [{"create_time":"2020-12-11 12:14:25","dtc_code":"B0LP010002","dtc_id":4341,"info":"轨迹运行中检测到近处有障碍物","instruction":"移除障碍物","last_update_time":"2020-12-11 12:14:34","level":10,"nickname":"yg00sh8020103119000000","recoverable":"Y","robot_origin":"yg00sh8020103119000000","status":"resolved"},{"create_time":"2020-12-11 12:14:25","dtc_code":"B0IB010001","dtc_id":4340,"info":"软急停(monitor)","instruction":"请按提示修复异常或按复位键","last_update_time":"2020-12-11 12:14:34","level":10,"nickname":"yg00sh8020103119000000","recoverable":"Y","robot_origin":"yg00sh8020103119000000","status":"resolved"}]
         */

        private int count;
        private List<Integer> levels;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Integer> getLevels() {
            return levels;
        }

        public void setLevels(List<Integer> levels) {
            this.levels = levels;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", levels=" + levels +
                    ", list=" + list +
                    '}';
        }

        public static class ListBean {
            /**
             * create_time : 2020-12-11 12:14:25
             * dtc_code : B0LP010002
             * dtc_id : 4341
             * info : 轨迹运行中检测到近处有障碍物
             * instruction : 移除障碍物
             * last_update_time : 2020-12-11 12:14:34
             * level : 10
             * nickname : yg00sh8020103119000000
             * recoverable : Y
             * robot_origin : yg00sh8020103119000000
             * status : resolved
             */

            private String create_time;
            private String dtc_code;
            private int dtc_id;
            private String info;
            private String instruction;
            private String last_update_time;
            private int level;
            private String nickname;
            private String recoverable;
            private String robot_origin;
            private String status;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getDtc_code() {
                return dtc_code;
            }

            public void setDtc_code(String dtc_code) {
                this.dtc_code = dtc_code;
            }

            public int getDtc_id() {
                return dtc_id;
            }

            public void setDtc_id(int dtc_id) {
                this.dtc_id = dtc_id;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getInstruction() {
                return instruction;
            }

            public void setInstruction(String instruction) {
                this.instruction = instruction;
            }

            public String getLast_update_time() {
                return last_update_time;
            }

            public void setLast_update_time(String last_update_time) {
                this.last_update_time = last_update_time;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRecoverable() {
                return recoverable;
            }

            public void setRecoverable(String recoverable) {
                this.recoverable = recoverable;
            }

            public String getRobot_origin() {
                return robot_origin;
            }

            public void setRobot_origin(String robot_origin) {
                this.robot_origin = robot_origin;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "create_time='" + create_time + '\'' +
                        ", dtc_code='" + dtc_code + '\'' +
                        ", dtc_id=" + dtc_id +
                        ", info='" + info + '\'' +
                        ", instruction='" + instruction + '\'' +
                        ", last_update_time='" + last_update_time + '\'' +
                        ", level=" + level +
                        ", nickname='" + nickname + '\'' +
                        ", recoverable='" + recoverable + '\'' +
                        ", robot_origin='" + robot_origin + '\'' +
                        ", status='" + status + '\'' +
                        '}';
            }
        }
    }
}
