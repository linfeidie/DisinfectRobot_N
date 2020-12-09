package com.linfd.scri.disinfectrobot.entity;

/*
 *查询所有故障信息
 * */


import java.util.ArrayList;
import java.util.List;

public class GetErrorCodeEntity extends BaseEntity{


    private String errmsg;
    private String errno;
    private InfoBean info;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {


        private ChargingStationBean charging_station;
        private YugongBean yugong;

        public ChargingStationBean getCharging_station() {
            return charging_station;
        }

        public void setCharging_station(ChargingStationBean charging_station) {
            this.charging_station = charging_station;
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
                     * category_group : null
                     * count : 137
                     * create_time : null
                     * dtc_id : B5GPM20530
                     * hostname : cj02
                     * id : 4005
                     * last_update_time : null
                     * level : 2
                     * robot_type : charging_station
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }

                public static class ZhCnBean {
                    /**
                     * category_group : null
                     * count : 137
                     * create_time : null
                     * dtc_id : B5GPM20530
                     * hostname : cj02
                     * id : 4005
                     * last_update_time : null
                     * level : 2
                     * robot_type : charging_station
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }

                public static class ZhTwBean {
                    /**
                     * category_group : null
                     * count : 137
                     * create_time : null
                     * dtc_id : B5GPM20530
                     * hostname : cj02
                     * id : 4005
                     * last_update_time : null
                     * level : 2
                     * robot_type : charging_station
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }
            }
        }

        public static class YugongBean {

            private Yg00sh8020103119000000Bean yg00sh8020103119000000;

            public Yg00sh8020103119000000Bean getYg00sh8020103119000000() {
                return yg00sh8020103119000000;
            }

            public void setYg00sh8020103119000000(Yg00sh8020103119000000Bean yg00sh8020103119000000) {
                this.yg00sh8020103119000000 = yg00sh8020103119000000;
            }

            public static class Yg00sh8020103119000000Bean {
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
                     * category_group : null
                     * count : 48
                     * create_time : null
                     * dtc_id : B0PC020000
                     * hostname : yg00sh8020103119000000
                     * id : 4134
                     * last_update_time : null
                     * level : 20
                     * robot_type : yugong
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }

                public static class ZhCnBeanX {
                    /**
                     * category_group : null
                     * count : 48
                     * create_time : null
                     * dtc_id : B0PC020000
                     * hostname : yg00sh8020103119000000
                     * id : 4134
                     * last_update_time : null
                     * level : 20
                     * robot_type : yugong
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }

                public static class ZhTwBeanX {
                    /**
                     * category_group : null
                     * count : 48
                     * create_time : null
                     * dtc_id : B0PC020000
                     * hostname : yg00sh8020103119000000
                     * id : 4134
                     * last_update_time : null
                     * level : 20
                     * robot_type : yugong
                     * status : active
                     */

                    private Object category_group;
                    private int count;
                    private Object create_time;
                    private String dtc_id;
                    private String hostname;
                    private int id;
                    private Object last_update_time;
                    private int level;
                    private String robot_type;
                    private String status;

                    public Object getCategory_group() {
                        return category_group;
                    }

                    public void setCategory_group(Object category_group) {
                        this.category_group = category_group;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public Object getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(Object create_time) {
                        this.create_time = create_time;
                    }

                    public String getDtc_id() {
                        return dtc_id;
                    }

                    public void setDtc_id(String dtc_id) {
                        this.dtc_id = dtc_id;
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

                    public Object getLast_update_time() {
                        return last_update_time;
                    }

                    public void setLast_update_time(Object last_update_time) {
                        this.last_update_time = last_update_time;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getRobot_type() {
                        return robot_type;
                    }

                    public void setRobot_type(String robot_type) {
                        this.robot_type = robot_type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }
            }
        }
    }

    /*
     * 充电桩实例转成韩信实例 韩信实例在P987  充电桩实例P99 愚公实例P1648
     * */
//    public static List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX >EnBeanToZhCnBeanX(List<GetErrorCodeEntity.InfoBean.ChargingStationBean.Cj02Bean.EnBean> charges){
//        List<InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX > zhCnBeanXES = new ArrayList<>();
//        for (int i = 0; i < charges.size(); i++) {
//            InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX zhCnBeanX = new InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX();
//            zhCnBeanX.setSelf_recoverable(charges.get(i).getSelf_recoverable());
//            zhCnBeanX.setCreate_time(charges.get(i).getCreate_time());
//            zhCnBeanX.setError_mode(charges.get(i).getError_mode());
//            zhCnBeanX.setInstruction(charges.get(i).getInstruction());
//            zhCnBeanX.setId(charges.get(i).getId());
//            zhCnBeanXES.add(zhCnBeanX);
//        }
//        return zhCnBeanXES;
//    }

    /*
     * 愚公实例转成韩信实例 韩信实例在P987  充电桩实例P99 愚公实例P1648(弃)
     * 以充电桩为主
     * 愚公转充电桩
     * */
    public static List<InfoBean.ChargingStationBean.Cj02Bean.ZhCnBean>EnBeanToZhCnBeanXX(List<InfoBean.YugongBean.Yg00sh8020103119000000Bean.ZhCnBeanX> yugongs){
        List<InfoBean.ChargingStationBean.Cj02Bean.ZhCnBean> zhCnBeanCSList = new ArrayList<>();
        for (int i = 0; i < yugongs.size(); i++) {
            InfoBean.ChargingStationBean.Cj02Bean.ZhCnBean zhCnBeanX = new InfoBean.ChargingStationBean.Cj02Bean.ZhCnBean();
            InfoBean.YugongBean.Yg00sh8020103119000000Bean.ZhCnBeanX yugong = yugongs.get(i);
            zhCnBeanX.setCategory_group(yugong.getCategory_group());
            zhCnBeanX.setCount(yugong.getCount());
            zhCnBeanX.setCreate_time(yugong.getCreate_time());
            zhCnBeanX.setDtc_id(yugong.getDtc_id());
            zhCnBeanX.setHostname(yugong.getHostname());
            zhCnBeanX.setLast_update_time(yugong.getLast_update_time());
            zhCnBeanX.setRobot_type(yugong.getRobot_type());
            zhCnBeanX.setStatus(yugong.getStatus());
            zhCnBeanX.setId(yugong.getId());
            zhCnBeanX.setLevel(yugong.getLevel());
            zhCnBeanCSList.add(zhCnBeanX);
        }
        return zhCnBeanCSList;
    }
}