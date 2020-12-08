package com.linfd.scri.disinfectrobot.entity;

/*
* 查询任务运⾏状态 - 根据任务id
* */
public class TaskStatusEntity extends BaseErrEntity{

    /**
     * data : {"id":1670,"status":3}
     * errmsg : Query_OK
     * errno : 0
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
         * id : 1670
         * status : 3
         */

        private int id;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "TaskStatusEntity{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno='" + errno + '\'' +
                '}';
    }
}
