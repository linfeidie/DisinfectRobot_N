package com.linfd.scri.disinfectrobot.entity;

/*
*查询所有故障信息
* */


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetErrorCodeEntity extends BaseEntity{



    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         */

        private ChargingStationBean charging_station;
        private HanxinBean hanxin;
        private YugongBean yugong;

        public ChargingStationBean getCharging_station() {
            return charging_station;
        }

        public void setCharging_station(ChargingStationBean charging_station) {
            this.charging_station = charging_station;
        }

        public HanxinBean getHanxin() {
            return hanxin;
        }

        public void setHanxin(HanxinBean hanxin) {
            this.hanxin = hanxin;
        }

        public YugongBean getYugong() {
            return yugong;
        }

        public void setYugong(YugongBean yugong) {
            this.yugong = yugong;
        }

        public static class ChargingStationBean {

            private Cj02Bean cj02;

            public Cj02Bean getCj02() {
                return cj02;
            }

            public void setCj02(Cj02Bean cj02) {
                this.cj02 = cj02;
            }

            public static class Cj02Bean {
                private List<EnBean> en;
                private List<ZhCnBean> zh_cn;
                private List<ZhTwBean> zh_tw;

                public List<EnBean> getEn() {
                    return en;
                }

                public void setEn(List<EnBean> en) {
                    this.en = en;
                }

                public List<ZhCnBean> getZh_cn() {
                    return zh_cn;
                }

                public void setZh_cn(List<ZhCnBean> zh_cn) {
                    this.zh_cn = zh_cn;
                }

                public List<ZhTwBean> getZh_tw() {
                    return zh_tw;
                }

                public void setZh_tw(List<ZhTwBean> zh_tw) {
                    this.zh_tw = zh_tw;
                }

                public static class EnBean {
                    /**
                     * DTC : B5GPM20530
                     * category_group : GP
                     * consequent_code :
                     * count : 2204
                     * create_time : 2020-10-26 14:21:38
                     * dtc_id : B5GPM20530
                     * error_mode : Charging station fail
                     * hostname : cj02
                     * id : 4932
                     * instruction :
                     * last_update_time : 2020-10-26 14:30:49
                     * level : 2
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : charging_station
                     * self_recoverable : N
                     * status : active
                     * system_abbreviation : GPM
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }

                    @Override
                    public boolean equals(Object o) {
                        if (this == o) return true;
                        if (!(o instanceof EnBean)) return false;
                        EnBean enBean = (EnBean) o;
                        return getDTC().equals(enBean.getDTC());
                    }

                    @Override
                    public int hashCode() {
                        return Objects.hash(getDTC());
                    }

                    @Override
                    public String toString() {
                        return "EnBean{" +
                                "error_mode='" + error_mode + '\'' +
                                '}';
                    }
                }

                public static class ZhCnBean {
                    /**
                     * DTC : B5GPM20530
                     * category_group : GP
                     * consequent_code :
                     * count : 2204
                     * create_time : 2020-10-26 14:21:38
                     * dtc_id : B5GPM20530
                     * error_mode : 充电站异常
                     * hostname : cj02
                     * id : 4932
                     * instruction :
                     * last_update_time : 2020-10-26 14:30:49
                     * level : 2
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : charging_station
                     * self_recoverable : N
                     * status : active
                     * system_abbreviation : GPM
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }

                public static class ZhTwBean {
                    /**
                     * DTC : B5GPM20530
                     * category_group : GP
                     * consequent_code :
                     * count : 2204
                     * create_time : 2020-10-26 14:21:38
                     * dtc_id : B5GPM20530
                     * error_mode : 充電站異常
                     * hostname : cj02
                     * id : 4932
                     * instruction :
                     * last_update_time : 2020-10-26 14:30:49
                     * level : 2
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : charging_station
                     * self_recoverable : N
                     * status : active
                     * system_abbreviation : GPM
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }
            }
        }

        public static class HanxinBean {

            private Yg00a00020071211000n00Bean yg00a00020071211000n00;

            public Yg00a00020071211000n00Bean getYg00a00020071211000n00() {
                return yg00a00020071211000n00;
            }

            public void setYg00a00020071211000n00(Yg00a00020071211000n00Bean yg00a00020071211000n00) {
                this.yg00a00020071211000n00 = yg00a00020071211000n00;
            }

            public static class Yg00a00020071211000n00Bean {
                private List<EnBeanX> en;
                private List<ZhCnBeanX> zh_cn;
                private List<ZhTwBeanX> zh_tw;

                public List<EnBeanX> getEn() {
                    return en;
                }

                public void setEn(List<EnBeanX> en) {
                    this.en = en;
                }

                public List<ZhCnBeanX> getZh_cn() {
                    return zh_cn;
                }

                public void setZh_cn(List<ZhCnBeanX> zh_cn) {
                    this.zh_cn = zh_cn;
                }

                public List<ZhTwBeanX> getZh_tw() {
                    return zh_tw;
                }

                public void setZh_tw(List<ZhTwBeanX> zh_tw) {
                    this.zh_tw = zh_tw;
                }

                public static class EnBeanX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : deviation pause, emergency stop
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : move robot back to the trajectory
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }

                public static class
                ZhCnBeanX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : 偏离轨迹，紧急急停
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : 将机器人开回到轨迹上
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }

                public static class ZhTwBeanX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : 偏離軌跡，緊急急停
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : 將機器人開回到軌跡上
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }
            }
        }

        public static class YugongBean {

            private Yg00a00020071211000n00BeanX yg00a00020071211000n00;

            public Yg00a00020071211000n00BeanX getYg00a00020071211000n00() {
                return yg00a00020071211000n00;
            }

            public void setYg00a00020071211000n00(Yg00a00020071211000n00BeanX yg00a00020071211000n00) {
                this.yg00a00020071211000n00 = yg00a00020071211000n00;
            }

            public static class Yg00a00020071211000n00BeanX {
                private List<EnBeanXX> en;
                private List<ZhCnBeanXX> zh_cn;
                private List<ZhTwBeanXX> zh_tw;

                public List<EnBeanXX> getEn() {
                    return en;
                }

                public void setEn(List<EnBeanXX> en) {
                    this.en = en;
                }

                public List<ZhCnBeanXX> getZh_cn() {
                    return zh_cn;
                }

                public void setZh_cn(List<ZhCnBeanXX> zh_cn) {
                    this.zh_cn = zh_cn;
                }

                public List<ZhTwBeanXX> getZh_tw() {
                    return zh_tw;
                }

                public void setZh_tw(List<ZhTwBeanXX> zh_tw) {
                    this.zh_tw = zh_tw;
                }

                public static class EnBeanXX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : deviation pause, emergency stop
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : move robot back to the trajectory
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }

                public static class ZhCnBeanXX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : 偏离轨迹，紧急急停
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : 将机器人开回到轨迹上
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }

                    @Override
                    public String toString() {
                        return "ZhCnBeanXX{" +
                                "error_mode='" + error_mode + '\'' +
                                '}';
                    }
                }

                public static class ZhTwBeanXX {
                    /**
                     * DTC : B0LP010003
                     * category_group : LP
                     * consequent_code :
                     * count : 337
                     * create_time : 2020-10-27 08:54:39
                     * dtc_id : B0LP010003
                     * error_mode : 偏離軌跡，緊急急停
                     * hostname : yg00a00020071211000n00
                     * id : 5070
                     * instruction : 將機器人開回到軌跡上
                     * last_update_time : 2020-10-27 09:00:16
                     * level : 10
                     * log_file : null
                     * manual_fix_command : null
                     * potential_cause :
                     * robot_type : yugong
                     * self_recoverable : Y
                     * status : active
                     * system_abbreviation : LP0
                     * system_version : null
                     */

                    private String DTC;
                    private String category_group;
                    private String consequent_code;
                    private int count;
                    private String create_time;
                    private String dtc_id;
                    private String error_mode;
                    private String hostname;
                    private int id;
                    private String instruction;
                    private String last_update_time;
                    private int level;
                    private Object log_file;
                    private Object manual_fix_command;
                    private String potential_cause;
                    private String robot_type;
                    private String self_recoverable;
                    private String status;
                    private String system_abbreviation;
                    private Object system_version;

                    public String getDTC() {
                        return DTC;
                    }

                    public void setDTC(String DTC) {
                        this.DTC = DTC;
                    }

                    public String getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(String category_group) {
                        this.category_group = category_group;
                    }

                    public String getConsequent_code() {
                        return consequent_code;
                    }

                    public void setConsequent_code(String consequent_code) {
                        this.consequent_code = consequent_code;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
                    }

                    public String getError_mode() {
                        return error_mode;
                    }

                    public void setError_mode(String error_mode) {
                        this.error_mode = error_mode;
                    }

                    public String getHostname() {
                        return hostname;
                    }

                    public void setHostname(String hostname) {
                        this.hostname = hostname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public Object getLog_file() {
                        return log_file;
                    }

                    public void setLog_file(Object log_file) {
                        this.log_file = log_file;
                    }

                    public Object getManual_fix_command() {
                        return manual_fix_command;
                    }

                    public void setManual_fix_command(Object manual_fix_command) {
                        this.manual_fix_command = manual_fix_command;
                    }

                    public String getPotential_cause() {
                        return potential_cause;
                    }

                    public void setPotential_cause(String potential_cause) {
                        this.potential_cause = potential_cause;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getSelf_recoverable() {
                        return self_recoverable;
                    }

                    public void setSelf_recoverable(String self_recoverable) {
                        this.self_recoverable = self_recoverable;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getSystem_abbreviation() {
                        return system_abbreviation;
                    }

                    public void setSystem_abbreviation(String system_abbreviation) {
                        this.system_abbreviation = system_abbreviation;
                    }

                    public Object getSystem_version() {
                        return system_version;
                    }

                    public void setSystem_version(Object system_version) {
                        this.system_version = system_version;
                    }
                }
            }
        }
    }

    /*
    * 充电桩实例转成韩信实例 韩信实例在P987  充电桩实例P99 愚公实例P1648
    * */
    public static List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX >EnBeanToZhCnBeanX(List<GetErrorCodeEntity.InfoBean.ChargingStationBean.Cj02Bean.EnBean> charges){
        List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX > zhCnBeanXES = new ArrayList<>();
        for (int i = 0; i < charges.size(); i++) {
            InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX zhCnBeanX = new InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX();
            zhCnBeanX.setSelf_recoverable(charges.get(i).getSelf_recoverable());
            zhCnBeanX.setCreate_time(charges.get(i).getCreate_time());
            zhCnBeanX.setError_mode(charges.get(i).getError_mode());
            zhCnBeanX.setInstruction(charges.get(i).getInstruction());
            zhCnBeanX.setId(charges.get(i).getId());
            zhCnBeanXES.add(zhCnBeanX);
        }
        return zhCnBeanXES;
    }

    /*
     * 愚公实例转成韩信实例 韩信实例在P987  充电桩实例P99 愚公实例P1648
     * */
    public static List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX >EnBeanToZhCnBeanXX(List<InfoBean.YugongBean.Yg00a00020071211000n00BeanX.ZhCnBeanXX> yugongs){
        List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX > zhCnBeanXES = new ArrayList<>();
        for (int i = 0; i < yugongs.size(); i++) {
            InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX zhCnBeanX = new InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX();
            zhCnBeanX.setSelf_recoverable(yugongs.get(i).getSelf_recoverable());
            zhCnBeanX.setCreate_time(yugongs.get(i).getCreate_time());
            zhCnBeanX.setError_mode(yugongs.get(i).getError_mode());
            zhCnBeanX.setInstruction(yugongs.get(i).getInstruction());
            zhCnBeanX.setId(yugongs.get(i).getId());
            zhCnBeanXES.add(zhCnBeanX);
        }
        return zhCnBeanXES;
    }
}
