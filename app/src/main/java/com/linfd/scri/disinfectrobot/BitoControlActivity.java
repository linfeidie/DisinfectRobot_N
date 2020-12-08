package com.linfd.scri.disinfectrobot;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.entity.BaseEntity;
import com.linfd.scri.disinfectrobot.entity.BitoLoginEntity;
import com.linfd.scri.disinfectrobot.entity.CancelTasksEntity;
import com.linfd.scri.disinfectrobot.entity.ChangePwbEntity;
import com.linfd.scri.disinfectrobot.entity.ChargingStationsEntity;
import com.linfd.scri.disinfectrobot.entity.GetAgentsRegisterableEntity;
import com.linfd.scri.disinfectrobot.entity.GetAllTasksEntity;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.entity.GetHanxinStatusEntity;
import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.entity.PauseRobotEntity;
import com.linfd.scri.disinfectrobot.entity.ResumeRobotEntity;
import com.linfd.scri.disinfectrobot.entity.RobotRegisterEntity;
import com.linfd.scri.disinfectrobot.entity.RobotUnregisterEntity;
import com.linfd.scri.disinfectrobot.listener.SimpleHttpCallbackEntity;
import com.linfd.scri.disinfectrobot.manager.BitoActionStateManager;
import com.linfd.scri.disinfectrobot.manager.BitoHanxinManager;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager3;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager4;
import com.linfd.scri.disinfectrobot.manager.HttpRequestManager;
import com.linfd.scri.disinfectrobot.tools.ClickProxy;
import com.linfd.scri.disinfectrobot.tools.Tools;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class BitoControlActivity extends BaseActivity {

    public static final String TAG = BitoControlActivity.class.getSimpleName();
    private Button bt_hanxin_start,bt_hanxin_stop,bt_robot_register,bt_get_all_tasks,bt_get_repeat_tasks;
    private Button bt_get_charge_tasks,bt_switch_charging_mode_man,bt_switch_charging_mode_auto;
    private Button bt_cancel_task_walk,bt_cancel_task_charge,bt_get_hanxin_status,bt_get_error_code;
    private Button bt_login,bt_changePwb,bt_reset_agents,bt_robot_unregister;
    private Button bt_get_agents_registerable,bt_get_robot_perform_task;
    private Button bt_one_key_start,bt_charging_stations,bt_cancel_tasks,bt_pause_robot,bt_resume_robot;

    private TextView tv_get_hanxin_status,tv_get_error_code;

    private int disinTaskId = -1;
    private int chargeTaskId = -1 ;
    @Override
    public void initView() {
        setContentView(R.layout.activity_bito_control);
        bt_hanxin_start = findViewById(R.id.bt_hanxin_start);
        bt_hanxin_stop = findViewById(R.id.bt_hanxin_stop);
        bt_robot_register = findViewById(R.id.bt_robot_register);
        bt_get_all_tasks = findViewById(R.id.bt_get_all_tasks);
        bt_get_repeat_tasks = findViewById(R.id.bt_get_repeat_tasks);
        bt_get_charge_tasks = findViewById(R.id.bt_get_charge_tasks);
        bt_switch_charging_mode_man = findViewById(R.id.bt_switch_charging_mode_man);
        bt_switch_charging_mode_auto = findViewById(R.id.bt_switch_charging_mode_auto);
        bt_cancel_task_walk = findViewById(R.id.bt_cancel_task_walk);
        bt_cancel_task_charge = findViewById(R.id.bt_cancel_task_charge);
        bt_get_hanxin_status = findViewById(R.id.bt_get_hanxin_status);
        tv_get_hanxin_status = findViewById(R.id.tv_get_hanxin_status);
        bt_get_error_code = findViewById(R.id.bt_get_error_code);
        tv_get_error_code = findViewById(R.id.tv_get_error_code);
        bt_login = findViewById(R.id.bt_login);
        bt_changePwb = findViewById(R.id.bt_changePwb);
        bt_reset_agents = findViewById(R.id.bt_reset_agents);
        bt_robot_unregister = findViewById(R.id.bt_robot_unregister);
        bt_get_agents_registerable = findViewById(R.id.bt_get_agents_registerable);
        bt_get_robot_perform_task = findViewById(R.id.bt_get_robot_perform_task);
        bt_one_key_start = findViewById(R.id.bt_one_key_start);
        bt_charging_stations = findViewById(R.id.bt_charging_stations);
        bt_cancel_tasks = findViewById(R.id.bt_cancel_tasks);
        bt_pause_robot = findViewById(R.id.bt_pause_robot);
        bt_resume_robot = findViewById(R.id.bt_resume_robot);
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
        /*
        * 开启韩信
        * */
        bt_hanxin_start.setOnClickListener(new ClickProxy(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // hanxin_start();
            }

        }));

        /*
        * 关闭韩信
        * */
        bt_hanxin_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().hanxin_stop(new SimpleHttpCallbackEntity<BaseEntity>() {

                    @Override
                    public void onSuccess(BaseEntity entity) {
                        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            Tools.showToast("韩信已关闭");
                        }else{
                            onFailure(entity.getErrmsg());
                        }
                    }
                });
            }
        });
        /*
        * 注册机器人
        * */
        bt_robot_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot_register();
            }
        });

        /*
        * 查询所有任务信息
        * */
        bt_get_all_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // getAllTasks();
            }
        });
        /*
        * 重复行走任务
        * */

        bt_get_repeat_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeat_tasks();
            }
        });

        /*
         *重复充电任务，先查询所有任务信息
         * */
        bt_get_charge_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
        /*
        * 手动充电模式
        * */
        bt_switch_charging_mode_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().switch_charging_mode(1, new SimpleHttpCallbackEntity<BaseEntity>() {
                    @Override
                    public void onSuccess(BaseEntity baseEntity) {
                        if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            Tools.showToast("手动充电模式成功");
                        }else{
                            onFailure(baseEntity.getErrmsg());
                        }
                    }
                });
            }
        });

        /*
         * 自动充电模式
         * */
        bt_switch_charging_mode_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().switch_charging_mode(3, new SimpleHttpCallbackEntity<BaseEntity>() {

                    @Override
                    public void onSuccess(BaseEntity baseEntity) {
                        if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            Tools.showToast("自动充电模式成功");
                        }else{
                            onFailure(baseEntity.getErrmsg());
                        }

                    }

                });
            }
        });
        bt_cancel_task_walk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
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
        });
        bt_cancel_task_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chargeTaskId == -1){
                    return;
                }
                List<Integer> id_list = new ArrayList<>();
                id_list.add(chargeTaskId);
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
        });

        /*
        * 韩信状态
        * */

            bt_get_hanxin_status.setOnClickListener(new View.OnClickListener() {
            boolean b= true;
            @Override
            public void onClick(View view) {
                if (b){
                    HeartbeatManager3.getInstance().start();
                    b = false;
                }else{
                    HeartbeatManager3.getInstance().stop();
                    b = true;
                }


            }
        });

        /*
        * 查询所有故障信息
        * */
        bt_get_error_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().get_error_code(new SimpleHttpCallbackEntity<GetErrorCodeResultEntity>() {

                    @Override
                    public void onSuccess(GetErrorCodeResultEntity entity) {

//                        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
//
//                        }else{
//                            onFailure(entity.getErrmsg());
//                        }
                    }

                });
            }
        });

        /*
        * 登录
        * */
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().login("admin", "123456", new SimpleHttpCallbackEntity<BitoLoginEntity>() {

                    @Override
                    public void onSuccess(BitoLoginEntity entity) {
                        if (entity.getCode() == Contanst.REQUEST_OK_200){
                            Tools.showToast("登录成功");
                        }else{
                            onFailure(entity.getMessage());
                        }
                    }
                });
            }
        });
        /*
        * 修改密码
        * */
        bt_changePwb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().changePwb("", "", "", "", new SimpleHttpCallbackEntity<ChangePwbEntity>() {

                    @Override
                    public void onSuccess(ChangePwbEntity entity) {
                        if (entity.getCode() == Contanst.REQUEST_OK_200){
                            Tools.showToast("修改成功");
                        }else{
                            onFailure(entity.getMessage());
                        }
                    }
                });
            }
        });
        /*
        * 重置机器人
        * */
        bt_reset_agents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpRequestManager.getInstance().reset_agents(new SimpleHttpCallbackEntity<BaseEntity>() {

                    @Override
                    public void onSuccess(BaseEntity baseEntity) {
                        if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            Tools.showToast("重置成功");
                        }else{
                            onFailure(baseEntity.getErrmsg());
                        }
                    }

                });
            }
        });

        /*
        * 注销机器人
        * */
        bt_robot_unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    HttpRequestManager.getInstance().robot_unregister(new SimpleHttpCallbackEntity<RobotUnregisterEntity>() {

                        @Override
                        public void onSuccess(RobotUnregisterEntity entity) {
                            if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                                Tools.showToast("注销成功");
                            }else{
                                onFailure(entity.getErrmsg());
                            }
                        }
                    });
            }
        });

        /*
        * 查询所有在线机器⼈是否可注册
        * */
        bt_get_agents_registerable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // get_agents_registerable();
            }
        });

        /*
         * 查询正在执⾏的任务 - 根据机器⼈序列号
         * */
        bt_get_robot_perform_task.setOnClickListener(new View.OnClickListener() {

            boolean b = true;
            @Override
            public void onClick(View view) {
                if (b){
                    HeartbeatManager4.getInstance().start();
                    b = false;
                }else{
                    HeartbeatManager4.getInstance().stop();
                    b = true;
                }
            }
        });

        /*
        * 一键开启  3连    开启韩信 +  获取机器人序列号 + 注册机器人
        * */
        bt_one_key_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hanxin_start();
            }
        });

        /*
        查询所有⾃动充电桩信息*
        */
        bt_charging_stations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                charing_stations();
            }
        });

        /*
        * 取消所有任务
        * */
        bt_cancel_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Integer> id_list = new ArrayList<>();
                id_list.add(1);
                HttpRequestManager.getInstance().cancel_tasks(id_list, new SimpleHttpCallbackEntity<CancelTasksEntity>() {
                    @Override
                    public void onSuccess(CancelTasksEntity entity) {
                        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                            Tools.showToast("取消任务成功");
                        }else{
                            onFailure(entity.getErrmsg());
                        }
                    }
                });
            }
        });

        /*
        *暂停机器人
        * */
        bt_pause_robot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });

        /*
        * 恢复机器人
        * */
        bt_resume_robot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("注册成功");
                }else{
                    onFailure(entity.getErrmsg());
                }

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
    * 启动韩信
    * */
    private void hanxin_start() {
        HttpRequestManager.getInstance().hanxin_start(new SimpleHttpCallbackEntity<BaseEntity>() {
            @Override
            public void onSuccess(BaseEntity baseEntity) {
                if (baseEntity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK)){
                    Tools.showToast("韩信启动成功");
                    get_agents_registerable();//获取机器人系列号 并注册机器人
                    charing_stations();//获取充电桩序列号
                }else{
                    Tools.showToast("韩信启动失败");
                };
            }


        });
    }


    private void repeat_tasks() {
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
     * 接收韩信状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetHanxinStatusEntity entity) {
        Log.e(TAG,"韩信："+ BitoHanxinManager.obtainState(entity.getStatus()));

    }
    /*
           正在执行的任务状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetRobotPerformTaskEntity entity) {

        //返回正确且有值
        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && entity.getData().getTasks().size() != 0){
            Log.e(TAG,BitoActionStateManager.obtainState(entity.getData().getTasks().get(0).getStatus()));
        }else{
            Tools.showToast("当前没有任务状态");
        }
    }
}
