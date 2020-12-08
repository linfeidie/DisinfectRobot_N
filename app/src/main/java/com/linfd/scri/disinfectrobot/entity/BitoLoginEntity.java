package com.linfd.scri.disinfectrobot.entity;
/*
* 登录返回
* */
public class BitoLoginEntity extends BaseEntity2{

    /**
     * code : 200
     * data : {"group":"administator","token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwidWlkIjoxLCJleH AiOjE1ODAwMDY4NzZ9.LK9kgk1FF-La38QyGuTkIdYAy085s-Ir2wRjoFBAw9s"}
     * message : Success
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
         * group : administator
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwidWlkIjoxLCJleH AiOjE1ODAwMDY4NzZ9.LK9kgk1FF-La38QyGuTkIdYAy085s-Ir2wRjoFBAw9s
         */

        private String group;
        private String token;

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
