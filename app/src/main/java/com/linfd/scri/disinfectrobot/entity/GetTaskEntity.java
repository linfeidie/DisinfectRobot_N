package com.linfd.scri.disinfectrobot.entity;


public class GetTaskEntity extends BaseEntity{

    /**
     * data : {"actual_time":"","assignment":"","assignment_nickname":"","complete_time":"","create_time":"2020-12-24 11:28:03","goal":"s2","goal_action":0,"id":4002,"item_type":"","plan_time":"","preassignment":"","preassignment_nickname":"","priority":10,"run_err_code":"","run_err_msg":"","start":"s2","start_action":12,"status":5,"task_id":""}
     */

    public DataBean data;


    public static class DataBean {
        /**
         * actual_time :
         * assignment :
         * assignment_nickname :
         * complete_time :
         * create_time : 2020-12-24 11:28:03
         * goal : s2
         * goal_action : 0
         * id : 4002
         * item_type :
         * plan_time :
         * preassignment :
         * preassignment_nickname :
         * priority : 10
         * run_err_code :
         * run_err_msg :
         * start : s2
         * start_action : 12
         * status : 5
         * task_id :
         */

        public String actual_time;
        public String assignment;
        public String assignment_nickname;
        public String complete_time;
        public String create_time;
        public String goal;
        public int goal_action;
        public int id;
        public String item_type;
        public String plan_time;
        public String preassignment;
        public String preassignment_nickname;
        public int priority;
        public String run_err_code;
        public String run_err_msg;
        public String start;
        public int start_action;
        public int status;
        public String task_id;
    }
}
