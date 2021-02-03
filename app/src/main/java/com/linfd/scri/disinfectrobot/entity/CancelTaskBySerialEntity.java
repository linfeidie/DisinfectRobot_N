package com.linfd.scri.disinfectrobot.entity;

import java.util.List;
//取消任务 - 根据机器人序列号
public class CancelTaskBySerialEntity extends BaseEntity {

    /**
     * result : [{"dtc_code":"B0HX000007","error_code":2010,"error_instruction":"","error_mode":"正常，任务取消成功","id":"yg00sh8020103119000000"}]
     * serial : yg00sh8020103119000000
     */

    private String serial;
    private List<ResultBean> result;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * dtc_code : B0HX000007
         * error_code : 2010
         * error_instruction :
         * error_mode : 正常，任务取消成功
         * id : yg00sh8020103119000000
         */

        private String dtc_code;
        private int error_code;
        private String error_instruction;
        private String error_mode;
        private String id;

        public String getDtc_code() {
            return dtc_code;
        }

        public void setDtc_code(String dtc_code) {
            this.dtc_code = dtc_code;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public String getError_instruction() {
            return error_instruction;
        }

        public void setError_instruction(String error_instruction) {
            this.error_instruction = error_instruction;
        }

        public String getError_mode() {
            return error_mode;
        }

        public void setError_mode(String error_mode) {
            this.error_mode = error_mode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
