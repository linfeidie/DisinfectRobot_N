package com.linfd.scri.disinfectrobot;

import android.os.Environment;

import com.linfd.scri.disinfectrobot.entity.GetMapParamCallbackEntity;


public class Contanst {
    //192.168.5.130  轻载
    public static  String map_time ; //192.168.1.101（1009） 连接网线  "127.0.0.1"  192.168.2.103 是网络地址  10.42.0.1
    //1.0是有线网段
    public static final String TargetIp = "192.168.2.119";//10.42.0.1  目标IP地址   192.168.2.107  117  192.168.5.100

    public static final int TargetPort = 8999; //目标端口8999 8080

    public static final int LocalPort = 8989 ;//本地端口

    public static final String bitoIP = "http://192.168.2.119:9999/";//宾通的IP  http://192.168.2.108:9999/(无线)

    public static final String bitoAPI = bitoIP + "api/v1/";

    public static final String bitoTask = bitoAPI + "task/";

    public static final String bitoAuth = bitoAPI + "auth/";

    public static final String bitoMonitor = bitoAPI + "monitor/";

    public static final String bitoRobot = bitoAPI + "robot/";

    public static final String api_get_task_status = bitoTask + "get_task_status/";

    public static final String api_hanxin_start = bitoMonitor + "hanxin_start";

    public static final String api_hanxin_stop = bitoMonitor + "hanxin_stop";

    public static final String api_get_hanxin_status = bitoMonitor + "get_hanxin_status";

    public static final String api_robot_register = bitoMonitor + "robot_register/";

    public static final String api_get_all_tasks = bitoTask + "get_all_tasks?";

    public static final String api_repeat_tasks = bitoTask + "repeat_tasks";

    public static final String api_switch_charging_mode = bitoMonitor + "switch_charging_mode/";

    public static final String api_cancel_task = bitoTask + "cancel_task/";

    public static final String api_get_error_code = bitoMonitor + "get_error_code";

    public static final String api_login = bitoAuth + "login";

    public static final String api_changePwb = bitoAuth + "changePwb";

    public static final String api_reset_agents = bitoMonitor + "reset_agents?serial=";

    public static final String api_robot_unregister = bitoMonitor + "robot_unregister/";

    public static final String api_get_agents_registerable = bitoMonitor + "get_agents_registerable";

    public static final String api_get_robot_perform_task = bitoTask + "get_robot_perform_task/";

    public static final String api_charging_stations = bitoMonitor + "charging_stations";

    public static final String api_cancel_tasks = bitoTask + "cancel_tasks";  //取消所有任务

    public static final String api_pause_robot = bitoRobot + "pause_robot?serial=";//暂停机器人

    public static final String api_resume_robot = bitoRobot + "resume_robot?serial=";//恢复机器人

    public static final String api_get_charging_status = bitoMonitor + "get_charging_status";//查询自动充电开关

    public static final String api_stop_charging_server = bitoMonitor + "stop_charging_server";//关闭⾃动充电

    public static final String api_start_charging_server = bitoMonitor + "start_charging_server";//开启自动充电

    public static final String api_reset_charging_station = bitoMonitor + "reset_charging_station/";

    public static final String api_tasks = bitoTask + "tasks";//查询任务信息 - 根据相关条件

    public static final String api_add_task = bitoTask + "add_task";//添加任务

    public static final String api_solve_error_code = bitoMonitor + "solve_error_code?id=";//修改错误信息状态

    public static final String REQUEST_OK = "0";

    public static final int REQUEST_OK_200 = 200;

    public static final int REQUEST_OK_0 = 0;

    public static boolean isNeedStop = true;//自己维护一个状态  恢复还是暂停

    //public static String ssid = "";//热点名

   // public static String passwd = ""; //热点密码

//    public static String start_walk_positon = "A5";//行走开始点
//
//    public static String goal_walk_position = "A2";//结束点
//
//    public static String charge_position = "A1";//充电起始点

    public static final int priority_walk = 11;//行走优先级

    public static final int priority_charge = 20; //充电优先级

    public static  String ROBOT_SERIAL = "";//yg00a00020071211000n00

    public static String CHARGING_STATION_SERIAL = ""; //充电桩序列号  cj02

    public static int status_hanxin = 0;//记录实时韩信状态  0关闭 ，1开启

    public static boolean isCurrentChargeTask = false;//判断当前是否说充电任务

    //public static int mode = -1;//充电模式  1:纯手动，2:半自动，3:纯自动，4:混动 （废弃）

    public static  int MAP_HASHCODE = -1;//正在展示的地图的哈希码

   // public static int repeat_num = 1;//设置机器人行走消毒次数

    public static final String ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();//根目录

    public static final String PROJECT_ROOT = ROOT + "/scri";//项目根目录

    public static final String CACHE_DIR = PROJECT_ROOT + "/cache";//用于缓存显示中的文件夹 保存原始地图，可整体删掉

    public static final String HISTORY_PATH_DIR = PROJECT_ROOT + "/historypath";//用于保存操作完的带路径的

    public static final String HISTORY_ORIGINAL_DIR = PROJECT_ROOT + "/historyoriginal";//历史最近一次的 原始图
    public static GetMapParamCallbackEntity MAPPARAMENTITY= null;//测试

    public static final int HEARTBEAT = 10000; //心跳

    public static final int CHARGEPOLLING = 1000; //充电桩轮询

    public static final int GETMAPFREQUENCY =  1000*3*1;//地图更新检查频率 10s

    public static final int DRAWPATHFREQUENCY = 2*1000; //绘制路径的刷新频率

    public static final String TRUE = "true" ;

    public static final int ORDER_INTERVAL = 1000 ; //按钮按下命令间隔

    public static final int REQUEST_MAPPACK_COUNT = 5;//UDP 下请求每次获取的包数

    public  static String id = "b4f89c82-8d3f-4b15-b293-0c605678a537"; //本客户的ID

    public static  String to_id = "02b01499-f501-4745-b601-43bc8737ed08";//控制都id e2baac1d-9ec5-4461-a8fb-7b53e202bdf7


    public static  GetMapParamCallbackEntity mapParamCallbackEntity = null;//地图的参数信息

    public static final double LINEAR_SPEED = 0.15;//  直线速度

    public static final double ANGULAR_SPEED = 0.3; //角速度

    public static int loop_time = 0;  //喷雾任务循环

    public static boolean switch_recharging = false;//是否回充

    public  static  int man_switch = 0;//宾通切换

    /*
    * 命令请求
    * */
    public static final String get_robot_status = "get_robot_status";//获取机器人状态

    public static final String get_disin_state = "get_disin_state";//获取消毒状态

    public static final String get_apmt_state = "get_apmt_state";//获取预约状态

    public static final String set_apmt = "set_apmt";//设置预约任务

    public static final String get_mach_type = "get_mach_type";//机器类型

    public static final String set_disin_action = "set_disin_action";//消毒任务

    public static final String set_action_cmd = "set_action_cmd"; //开启，暂停

    public static final String set_base_cmd = "set_base_cmd";//底盘命令

    public static final String set_disin_cmd = "set_disin_cmd";//设置消毒设备命令  与任务隔离

    public static final String set_goal_action = "set_goal_action";//目标点任务

    public static final String set_cycle_action = "set_cycle_action";//循环任务

    public static final String get_charger_pose = "get_charger_pose"; //获取充电座位置

    public static final String get_map_exist = "get_map_exist";//获取历史地图记录

    public static final String set_charge_water_action = "set_charge_water_action"; //对接换水任务(清扫机器人用)

    public static final String set_goal = "set_goal";//设置描点

    public static final String set_charge_power_action = "set_charge_power_action"; //对接充电任务

    public static final String set_lift_cmd = "set_lift_cmd"; //设置顶升设备命令

    public static final String set_goal_param = "set_goal_param"; //

    public static final String get_robot_exception = "get_robot_exception";//获取异常代码

    public static final String set_robot_wifi = "set_robot_wifi"; //设置机器人wifi连接
    /*
    * 指令类型  返回类型
    * */

    public static final String ser_ack_online = "ser_ack_online";

    public static final String ser_ack_online_ids = "ser_ack_online_ids";

    public static final String ser_ack_onbind = "ser_ack_onbind";

    public static final String robot_status = "robot_status";//机器人状态

    public static final String ser_ack_offline = "ser_ack_offline"; //下线返回

    public static final String ser_ack_heartbeat = "ser_ack_heartbeat";

    public static final String map_data = "map_data"; //返回地图数据

    public static final String map_param = "map_param";//地图参数返回

    public static final String  disin_state= "disin_state";//消毒状态返回

    public static final String apmt_state = "apmt_state"; //预约状态
    public static final String robot_ack = "robot_ack";//所有设置

    public static final String mach_type = "mach_type";//机器类型

    public static final String charger_pose = "charger_pose"; //充电座位置


    public static final String KEY_SHOW01 = "show01"; //页面跳转  要主界面显示暂停和停止按钮

    public static final String exception_codes = "exception_codes";

    public static  String KEY_HASHISTORY_POINTS ;//是否有历史保存

    /*
    机器人运行的状态
    * */
    public static final int action_state_idle = 0;
    public static final int action_state_running = 1;
    public static final int action_state_pause = 2;
    public static final int action_state_finish = 3;
    public static final int action_state_stop = 4;



}
