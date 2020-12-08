package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 查询是否有不可恢复故障
* */
public class GetAgentsRegisterableEntity extends BaseEntity {

    /**
     * data : {"agents":[{"agent_registerable":0,"color":null,"nickname":"AGV01","serial":"yg00a00020071211000n00","status":1}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<AgentsBean> agents;

        public List<AgentsBean> getAgents() {
            return agents;
        }

        public void setAgents(List<AgentsBean> agents) {
            this.agents = agents;
        }

        public static class AgentsBean {
            /**
             * agent_registerable : 0
             * color : null
             * nickname : AGV01
             * serial : yg00a00020071211000n00
             * status : 1
             */

            private int agent_registerable;
            private Object color;
            private String nickname;
            private String serial;
            private int status;//小车注册状态（0：未注册，1：已注册）

            public int getAgent_registerable() {
                return agent_registerable;
            }

            public void setAgent_registerable(int agent_registerable) {
                this.agent_registerable = agent_registerable;
            }

            public Object getColor() {
                return color;
            }

            public void setColor(Object color) {
                this.color = color;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSerial() {
                return serial;
            }

            public void setSerial(String serial) {
                this.serial = serial;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
