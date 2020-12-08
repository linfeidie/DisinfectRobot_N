package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.entity.AddTaskEntity;
import com.linfd.scri.disinfectrobot.entity.BaseEntity;
import com.linfd.scri.disinfectrobot.entity.BaseEntity2;
import com.linfd.scri.disinfectrobot.entity.CancelTasksEntity;
import com.linfd.scri.disinfectrobot.entity.ChargingStationsEntity;
import com.linfd.scri.disinfectrobot.entity.GetAgentsRegisterableEntity;
import com.linfd.scri.disinfectrobot.entity.GetAllTasksEntity;
import com.linfd.scri.disinfectrobot.entity.GetChargingStatusEntity;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.entity.PauseRobotEntity;
import com.linfd.scri.disinfectrobot.entity.ResumeRobotEntity;
import com.linfd.scri.disinfectrobot.entity.RobotRegisterEntity;
import com.linfd.scri.disinfectrobot.entity.RobotUnregisterEntity;
import com.linfd.scri.disinfectrobot.entity.SolveErrorCodeEntity;
import com.linfd.scri.disinfectrobot.entity.TasksEntity;
import com.linfd.scri.disinfectrobot.eventbus.RobotRegisterEvent;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/*
* 封装了宾通方法
* */
public class BitoAPIManager {

    private static BitoAPIManager instance;

    private int disinTaskId = -1;
    private int chargeTaskId = -1 ;

    public static BitoAPIManager getInstance(){

        if (instance == null){
            synchronized (BitoAPIManager.class){
                if (instance == null){
                    instance = new BitoAPIManager();
                }
            }

        }
        return instance;
    }

    /*
     * 启动韩信
     * */
    public void hanxin_start() {
        HttpRequestManager.getInstance().hanxin_start(new SimpleHttpCallbackEntity<BaseEntity>() {
            @Override
            public void onSuccess(BaseEntity baseEntity) {
                if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("系统启动成功");
                    get_agents_registerable();//获取机器人系列号 并注册机器人
                    charing_stations();//获取充电桩序列号
                    HttpRequestManager.getInstance().switch_charging_mode(3,null);//自动充电模式
                }else{
                    Tools.showToast("系统启动失败");
                };
            }


        });
    }
    /*
     * /*
     * 查询所有在线机器⼈是否可注册
     * */
    private void get_agents_registerable() {
        HttpRequestManager.getInstance().get_agents_registerable(new SimpleHttpCallbackEntity<GetAgentsRegisterableEntity>() {

            @Override
            public void onSuccess(GetAgentsRegisterableEntity entity) {
                // 健壮性
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK ) && entity.getData().getAgents().size() != 0){
                    //赋值
                    Contanst.ROBOT_SERIAL = entity.getData().getAgents().get(0).getSerial();
                    //Tools.showToast(entity.getData().getAgents().get(0).getSerial());
                    robot_register();//
                }else {
                    onFailure(entity.getErrmsg());
                }

            }

        });
    }

    /*
        查询所有⾃动充电桩信息*
        */
    private void charing_stations() {
        HttpRequestManager.getInstance().charging_stations(new SimpleHttpCallbackEntity<ChargingStationsEntity>() {

            @Override
            public void onSuccess(ChargingStationsEntity entity) {
                if (entity.getCode() == Contanst.REQUEST_OK_200 && entity.getData().size() != 0 ){
                    //赋值
                    //拿第一个
                    Contanst.CHARGING_STATION_SERIAL = entity.getData().get(0).getCharging_station_serial();
                }else {
                    onFailure(entity.getMsg());
                }
            }

        });
    }
    /*
     * 注册机器人
     * */
    private void robot_register() {
        HttpRequestManager.getInstance().robot_register(new SimpleHttpCallbackEntity<RobotRegisterEntity>() {
            @Override
            public void onSuccess(RobotRegisterEntity entity) {
                RobotRegisterEvent event = new RobotRegisterEvent();
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    event.status = 0 ;
                    Tools.showToast("注册成功");
                }else{
                    onFailure(entity.getErrmsg());
                    event.status = 1;
                }
                EventBus.getDefault().post(event);
            }

        });
    }

    /*
    * 关闭韩信（要分3步，1，暂停机器人  2关闭前取消所有未执行的任务 3.正式取消韩信）
    * */
    //同步是按顺序来  异步是不按顺序来
    public void hanxin_stop(){
        reset_agents();//重置机器人
        reset_charging_station();//重置充电桩
        HttpRequestManager.getInstance().pause_robot(new SimpleHttpCallbackEntity<PauseRobotEntity>(){

            @Override
            public void onSuccess(PauseRobotEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    List<Integer> condition = new ArrayList<>();
                    condition.add(1);
                    condition.add(0);
                    HttpRequestManager.getInstance().tasks(condition, new SimpleHttpCallbackEntity<TasksEntity>() {
                        @Override
                        public void onSuccess(TasksEntity tasksEntity) {
                            //有任务的情况
                            if (tasksEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && tasksEntity.getData().getTasks().size() != 0){
                                List<Integer> id_list = new ArrayList<>();

                                for (int i = 0; i < tasksEntity.getData().getTasks().size(); i++) {
                                    id_list.add(tasksEntity.getData().getTasks().get(i).getId());
                                }
                                HttpRequestManager.getInstance().cancel_tasks(id_list, new SimpleHttpCallbackEntity<CancelTasksEntity>() {
                                    @Override
                                    public void onSuccess(CancelTasksEntity entity) {
                                        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                                            stop_hanxin_real();
                                        }else{
                                            onFailure(entity.getErrmsg());
                                        }
                                    }


                                });
                                //没任务的情况
                            }else if(tasksEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && tasksEntity.getData().getTasks().size() == 0){
                                stop_hanxin_real();
                            }


                        }
                    });
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });


    }
    private void stop_hanxin_real() {
        HttpRequestManager.getInstance().hanxin_stop(new SimpleHttpCallbackEntity<BaseEntity2>() {

            @Override
            public void onSuccess(BaseEntity2 entity) {
                RobotRegisterEvent event = new RobotRegisterEvent();
                if (entity.getCode() == Contanst.REQUEST_OK_0){
                    Tools.showToast("系统已关闭");
                    event.status = 2;

                }else{
                    onFailure(entity.getMessage());
                }
                EventBus.getDefault().post(event);
            }
        });
    }

    /*
    * 重复消毒行走任务
    * */
    public void repeat_tasks() {
        HttpRequestManager.getInstance().get_all_tasks(new SimpleHttpCallbackEntity<GetAllTasksEntity>() {

            @Override
            public void onSuccess(final GetAllTasksEntity entity) {
                //健壮性
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && entity.getData().getTasks().size() != 0){
                    List<GetAllTasksEntity.DataBean.TasksBean> tasksBeans = entity.getData().getTasks();
                    for (int i = 0; i < tasksBeans.size(); i++) {
                        if (tasksBeans.get(i).getGoal_action() == 0){
                            disinTaskId = tasksBeans.get(i).getId();
                            break;
                        };
                    }
                    HttpRequestManager.getInstance().repeat_tasks(disinTaskId, new SimpleHttpCallbackEntity<BaseEntity>() {

                        @Override
                        public void onSuccess(BaseEntity baseEntity) {
                            if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                                Tools.showToast("重复任务成功");
                            }else {
                                onFailure(baseEntity.getErrmsg());
                            }
                        }
                    });
                }else {
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
    * 添加任务 充电任务
    * */
    public void add_task_charge(){
        HttpRequestManager.getInstance().add_task_charge(new SimpleHttpCallbackEntity<AddTaskEntity>() {
            @Override
            public void onSuccess(AddTaskEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("添加充电任务"+entity.getId());
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
     * 添加任务 充电任务
     * */
    public void add_task_walk(){
        HttpRequestManager.getInstance().add_task_walk(new SimpleHttpCallbackEntity<AddTaskEntity>() {
            @Override
            public void onSuccess(AddTaskEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("添加消毒任务"+entity.getId());
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
     * 暂停机器人
     * */
    public void pause_robot(){
        HttpRequestManager.getInstance().pause_robot(new SimpleHttpCallbackEntity<PauseRobotEntity>(){

            @Override
            public void onSuccess(PauseRobotEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){

                    Tools.showToast("暂停机器人");
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
     * 恢复机器人
     * */
    public void resume_robot(){
        HttpRequestManager.getInstance().resume_robot(new SimpleHttpCallbackEntity<ResumeRobotEntity>() {
            @Override
            public void onSuccess(ResumeRobotEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("恢复机器人");
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
    * 取消行走任务
    * */
    public void cancel_task_walk(){
        if (disinTaskId == -1){
            return;
        }
        List<Integer> id_list = new ArrayList<>();
        id_list.add(disinTaskId);
        HttpRequestManager.getInstance().cancel_tasks(id_list,new SimpleHttpCallbackEntity<CancelTasksEntity>() {

            @Override
            public void onSuccess(CancelTasksEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("取消成功");
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
     *重复充电任务，先查询所有任务信息  手动模式
     * */
    public void repeat_tasks_charge_man(){
        this.repeat_tasks_charge_mode(1);

    }
    /*
     *重复充电任务，先查询所有任务信息  自动模式
     * */
    public void repeat_tasks_charge_auto(){
        this.repeat_tasks_charge_mode(3);

    }
    /*
     *重复充电任务，先查询所有任务信息  参数模式
     * */
    public void repeat_tasks_charge_mode(final int mode){
        HttpRequestManager.getInstance().switch_charging_mode(mode, new SimpleHttpCallbackEntity<BaseEntity2>() {
            @Override
            public void onSuccess(BaseEntity2 baseEntity) {
                if (baseEntity.getCode() == Contanst.REQUEST_OK_200){

                    if (mode == 1){//1是手动
                        add_task_charge();  //自动充电不需要添加任务
                    }
                  //  repeat_tasks_charge();
                    //发送模式变化监听
//                    ChargeModeEvent event = new ChargeModeEvent();  不自己维护了，轮询服务器
//                    event.mode = mode;
//                    EventBus.getDefault().post(event);
                }else{
                    onFailure(baseEntity.getMessage());
                }
            }
        });

    }

    /*
    * 未改为手动充电模式下
    * */
    private void repeat_tasks_charge() {
        HttpRequestManager.getInstance().get_all_tasks(new SimpleHttpCallbackEntity<GetAllTasksEntity>() {

            @Override
            public void onSuccess(GetAllTasksEntity entity) {
                //代码健壮性
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && entity.getData().getTasks().size() != 0){
                    List<GetAllTasksEntity.DataBean.TasksBean> tasksBeans = entity.getData().getTasks();

                    for (int i = 0; i < tasksBeans.size(); i++) {
                        if (tasksBeans.get(i).getGoal_action() == 10){
                            chargeTaskId = tasksBeans.get(i).getId();
                            break;
                        };
                    }
                    HttpRequestManager.getInstance().repeat_tasks(chargeTaskId, new SimpleHttpCallbackEntity<BaseEntity>() {

                        @Override
                        public void onSuccess(BaseEntity baseEntity) {
                            //健壮性
                            if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                                Tools.showToast("充电");
                            }else{
                                onFailure(baseEntity.getErrmsg());
                            }
                        }

                    });
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });
    }

    /*
    * 取消充电任务
    * */
    public void cancel_task_charge_man(){

        HttpRequestManager.getInstance().switch_charging_mode(1, new SimpleHttpCallbackEntity<BaseEntity2>() {
            @Override
            public void onSuccess(BaseEntity2 baseEntity) {
                if (baseEntity.getCode() ==Contanst.REQUEST_OK_200){
                    cancel_task_current();
                }else{
                    onFailure(baseEntity.getMessage());
                }
            }
        });

    }

   /*
   * 取消当前任务（内部获得当前id 再取消）
   * */
    public void cancel_task_current() {
        // 先查询当前任务 获得id
        HttpRequestManager.getInstance().get_robot_perform_task(new SimpleHttpCallbackEntity<GetRobotPerformTaskEntity>() {

            @Override
            public void onSuccess(GetRobotPerformTaskEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    if (entity.getData() != null && entity.getData().getTasks().size() != 0) {
                        cancel_task_by_id(entity.getData().getTasks().get(0).getId());//获得id
                    }else if (entity.getData() != null && entity.getData().getTasks().size() == 0){
                        Tools.showToast("当前没有任务");
                    }
                }else{
                    onFailure(entity.getErrmsg());
                }
            }
        });


    }

    /*
     * 未手动模式之前
     * */
    private void cancel_task_charge(int taskId) {
        List<Integer> id_list = new ArrayList<>();
        id_list.add(taskId);
        HttpRequestManager.getInstance().cancel_tasks(id_list,new SimpleHttpCallbackEntity<CancelTasksEntity>() {

            @Override
            public void onSuccess(CancelTasksEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("取消成功");
                }else{
                    onFailure(entity.getErrmsg());
                }
            }

        });
    }

    private void cancel_task_by_id(int taskId) {
        List<Integer> id_list = new ArrayList<>();
        id_list.add(taskId);
        HttpRequestManager.getInstance().cancel_tasks(id_list,new SimpleHttpCallbackEntity<CancelTasksEntity>() {

            @Override
            public void onSuccess(CancelTasksEntity entity) {
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("取消成功");
                }else{
                    onFailure(entity.getErrmsg());
                }
            }

        });
    }

    /*
     * 重置机器人（重置+注销）
     * */
    public void reset_agents(){
        HttpRequestManager.getInstance().reset_agents(new SimpleHttpCallbackEntity<BaseEntity>() {

            @Override
            public void onSuccess(BaseEntity baseEntity) {
                if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    //Tools.showToast("重置成功");
                    robot_unregister();//再注销
                }else{
                    onFailure(baseEntity.getErrmsg());
                }
            }

        });
    }

    /*
     * 查询所有故障信息
     * */
    public void get_error_code(){
        HttpRequestManager.getInstance().get_error_code(new SimpleHttpCallbackEntity<GetErrorCodeResultEntity>() {

            @Override
            public void onSuccess(GetErrorCodeResultEntity entity) {

            }

        });
    }

    /*
     * 注销机器人
     * */
    public void robot_unregister(){
        HttpRequestManager.getInstance().robot_unregister(new SimpleHttpCallbackEntity<RobotUnregisterEntity>() {

            @Override
            public void onSuccess(RobotUnregisterEntity entity) {
                RobotRegisterEvent event = new RobotRegisterEvent();
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    event.status = 2;
                    Tools.showToast("注销成功");
                }else{
                    event.status = 3;
                    onFailure(entity.getErrmsg());
                }
                EventBus.getDefault().post(event);
            }
        });
    }
    /*
    * 查询⾃动充电开关状态
    * */
    public void get_charging_status(){
        HttpRequestManager.getInstance().get_charging_status(new SimpleHttpCallbackEntity<GetChargingStatusEntity>() {
            @Override
            public void onSuccess(GetChargingStatusEntity entity) {
                //发送模式变化监听
                    EventBus.getDefault().post(entity);
            }
        });
    }

    /*
     * 开启⾃动充电
     * */
   public void start_charging_server(){
       HttpRequestManager.getInstance().start_charging_server(new SimpleHttpCallbackEntity<BaseEntity>() {
           @Override
           public void onSuccess(BaseEntity entity) {

           }
       });
   }

   /*
   * 关闭⾃动充电
   * */
   public void stop_charging_server(){
       HttpRequestManager.getInstance().stop_charging_server(new SimpleHttpCallbackEntity<BaseEntity>() {
           @Override
           public void onSuccess(BaseEntity entity) {

           }
       });
   }

   /*
   * 重置充电桩信息
   * */
   public void reset_charging_station(){
       HttpRequestManager.getInstance().reset_charging_station(new SimpleHttpCallbackEntity<BaseEntity2>() {
           @Override
           public void onSuccess(BaseEntity2 baseEntity2) {

           }
       });
   }

   public void solve_error_code(int id ){
       HttpRequestManager.getInstance().solve_error_code(id, new SimpleHttpCallbackEntity<SolveErrorCodeEntity>() {

           @Override
           public void onSuccess(SolveErrorCodeEntity solveErrorCodeEntity) {

           }
       });
   }

   /*
   * 取消消毒（先暂停，然后取消所有未执行的任务，任何再取消现在的任务）
   * */
   public void cancle_walk(){
       HttpRequestManager.getInstance().pause_robot(new SimpleHttpCallbackEntity<PauseRobotEntity>(){

           @Override
           public void onSuccess(PauseRobotEntity entity) {
               if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                   List<Integer> condition = new ArrayList<>();
                   condition.add(1);
                   condition.add(0);
                   HttpRequestManager.getInstance().tasks(condition, new SimpleHttpCallbackEntity<TasksEntity>() {
                       @Override
                       public void onSuccess(TasksEntity tasksEntity) {
                           //有任务的情况
                           if (tasksEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && tasksEntity.getData().getTasks().size() != 0){
                               List<Integer> id_list = new ArrayList<>();

                               for (int i = 0; i < tasksEntity.getData().getTasks().size(); i++) {
                                   id_list.add(tasksEntity.getData().getTasks().get(i).getId());
                               }
                               HttpRequestManager.getInstance().cancel_tasks(id_list, new SimpleHttpCallbackEntity<CancelTasksEntity>() {
                                   @Override
                                   public void onSuccess(CancelTasksEntity entity) {
                                       if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                                           cancel_task_current();
                                       }else{
                                           onFailure(entity.getErrmsg());
                                       }
                                   }


                               });
                               //没任务的情况
                           }else if(tasksEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && tasksEntity.getData().getTasks().size() == 0){
                               cancel_task_current();
                           }


                       }
                   });
               }else{
                   onFailure(entity.getErrmsg());
               }
           }
       });
   }
}
