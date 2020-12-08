package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 查询任务信息 - 根据相关条件
* */
public class TasksEntity extends BaseEntity {

    /**
     * data : {"page":{"current_page":1,"limit":2,"total_count":1757,"total_page":879},"tasks":[{"actual_time":"2020-11-10 14:46:07","assignment":"yg00a00020071211000n00","assignment_nickname":"AGV01","complete_time":"2020-11-10 14:54:44","create_time":"2020-11-10 14:37:24","goal":"A2","goal_action":0,"id":2760,"item_type":"","plan_time":"","preassignment":"","preassignment_nickname":"","priority":11,"run_err_code":"","run_err_msg":"","start":"A5","start_action":0,"status":3,"task_id":""},{"actual_time":"2020-11-10 14:37:24","assignment":"yg00a00020071211000n00","assignment_nickname":"AGV01","complete_time":"2020-11-10 14:46:07","create_time":"2020-11-10 14:37:24","goal":"A2","goal_action":0,"id":2759,"item_type":"","plan_time":"","preassignment":"","preassignment_nickname":"","priority":11,"run_err_code":"","run_err_msg":"","start":"A5","start_action":0,"status":3,"task_id":""}]}
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
         * page : {"current_page":1,"limit":2,"total_count":1757,"total_page":879}
         * tasks : [{"actual_time":"2020-11-10 14:46:07","assignment":"yg00a00020071211000n00","assignment_nickname":"AGV01","complete_time":"2020-11-10 14:54:44","create_time":"2020-11-10 14:37:24","goal":"A2","goal_action":0,"id":2760,"item_type":"","plan_time":"","preassignment":"","preassignment_nickname":"","priority":11,"run_err_code":"","run_err_msg":"","start":"A5","start_action":0,"status":3,"task_id":""},{"actual_time":"2020-11-10 14:37:24","assignment":"yg00a00020071211000n00","assignment_nickname":"AGV01","complete_time":"2020-11-10 14:46:07","create_time":"2020-11-10 14:37:24","goal":"A2","goal_action":0,"id":2759,"item_type":"","plan_time":"","preassignment":"","preassignment_nickname":"","priority":11,"run_err_code":"","run_err_msg":"","start":"A5","start_action":0,"status":3,"task_id":""}]
         */

        private PageBean page;
        private List<TasksBean> tasks;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<TasksBean> getTasks() {
            return tasks;
        }

        public void setTasks(List<TasksBean> tasks) {
            this.tasks = tasks;
        }

        public static class PageBean {
            /**
             * current_page : 1
             * limit : 2
             * total_count : 1757
             * total_page : 879
             */

            private int current_page;
            private int limit;
            private int total_count;
            private int total_page;

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public int getTotal_page() {
                return total_page;
            }

            public void setTotal_page(int total_page) {
                this.total_page = total_page;
            }
        }

        public static class TasksBean {
            /**
             * actual_time : 2020-11-10 14:46:07
             * assignment : yg00a00020071211000n00
             * assignment_nickname : AGV01
             * complete_time : 2020-11-10 14:54:44
             * create_time : 2020-11-10 14:37:24
             * goal : A2
             * goal_action : 0
             * id : 2760
             * item_type :
             * plan_time :
             * preassignment :
             * preassignment_nickname :
             * priority : 11
             * run_err_code :
             * run_err_msg :
             * start : A5
             * start_action : 0
             * status : 3
             * task_id :
             */

            private String actual_time;
            private String assignment;
            private String assignment_nickname;
            private String complete_time;
            private String create_time;
            private String goal;
            private int goal_action;
            private int id;
            private String item_type;
            private String plan_time;
            private String preassignment;
            private String preassignment_nickname;
            private int priority;
            private String run_err_code;
            private String run_err_msg;
            private String start;
            private int start_action;
            private int status;
            private String task_id;

            public String getActual_time() {
                return actual_time;
            }

            public void setActual_time(String actual_time) {
                this.actual_time = actual_time;
            }

            public String getAssignment() {
                return assignment;
            }

            public void setAssignment(String assignment) {
                this.assignment = assignment;
            }

            public String getAssignment_nickname() {
                return assignment_nickname;
            }

            public void setAssignment_nickname(String assignment_nickname) {
                this.assignment_nickname = assignment_nickname;
            }

            public String getComplete_time() {
                return complete_time;
            }

            public void setComplete_time(String complete_time) {
                this.complete_time = complete_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getGoal() {
                return goal;
            }

            public void setGoal(String goal) {
                this.goal = goal;
            }

            public int getGoal_action() {
                return goal_action;
            }

            public void setGoal_action(int goal_action) {
                this.goal_action = goal_action;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getItem_type() {
                return item_type;
            }

            public void setItem_type(String item_type) {
                this.item_type = item_type;
            }

            public String getPlan_time() {
                return plan_time;
            }

            public void setPlan_time(String plan_time) {
                this.plan_time = plan_time;
            }

            public String getPreassignment() {
                return preassignment;
            }

            public void setPreassignment(String preassignment) {
                this.preassignment = preassignment;
            }

            public String getPreassignment_nickname() {
                return preassignment_nickname;
            }

            public void setPreassignment_nickname(String preassignment_nickname) {
                this.preassignment_nickname = preassignment_nickname;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public String getRun_err_code() {
                return run_err_code;
            }

            public void setRun_err_code(String run_err_code) {
                this.run_err_code = run_err_code;
            }

            public String getRun_err_msg() {
                return run_err_msg;
            }

            public void setRun_err_msg(String run_err_msg) {
                this.run_err_msg = run_err_msg;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public int getStart_action() {
                return start_action;
            }

            public void setStart_action(int start_action) {
                this.start_action = start_action;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTask_id() {
                return task_id;
            }

            public void setTask_id(String task_id) {
                this.task_id = task_id;
            }
        }
    }
}
