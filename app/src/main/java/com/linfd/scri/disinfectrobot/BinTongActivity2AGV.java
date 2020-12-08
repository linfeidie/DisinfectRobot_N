package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.entity.DesinStateCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionCodesCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionEntity;
import com.linfd.scri.disinfectrobot.entity.GetChargingStatusEntity;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeEntity;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.entity.GetHanxinStatusEntity;
import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.TasksEntity;
import com.linfd.scri.disinfectrobot.eventbus.EventPoint;
import com.linfd.scri.disinfectrobot.eventbus.RobotRegisterEvent;
import com.linfd.scri.disinfectrobot.manager.AckListenerService;
import com.linfd.scri.disinfectrobot.manager.BitoAPIManager;
import com.linfd.scri.disinfectrobot.manager.BitoActionStateManager;
import com.linfd.scri.disinfectrobot.manager.BitoHanxinManager;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager3;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager4;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager6;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager7;
import com.linfd.scri.disinfectrobot.manager.HttpRequestManager;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.manager.UpdateStateControlManager;
import com.linfd.scri.disinfectrobot.nicedialog.BaseNiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.NiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.ViewConvertListener;
import com.linfd.scri.disinfectrobot.nicedialog.ViewHolder;
import com.linfd.scri.disinfectrobot.test.MyIconModel;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.view.MyStatusLayout;
import com.linfd.scri.disinfectrobot.view.battery.BaseHandlerCallBack;
import com.linfd.scri.disinfectrobot.view.battery.PowerConsumptionRankingsBatteryView;
import com.suke.widget.SwitchButton;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;
import com.wihaohao.PageGridView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import cn.iwgang.countdownview.CountdownView;

public class BinTongActivity2AGV extends  BaseActivity   implements  BaseHandlerCallBack {

    public static final String TAG = BinTongActivity2AGV.class.getSimpleName();

    private PageGridView<MyIconModel> mPageGridView;
    private TextView tv_exception,tv_get_hanxin_status,tv_get_robot_perform_task,tv_pre_tasks,tv_disin_time;
    private List<ExceptionEntity> entities;
    private PowerConsumptionRankingsBatteryView mBatteryView;
    private BinTongActivity2AGV.NoLeakHandler mHandler;
    private int power;
    private TextView tv_power,tv_robot_register,tv_robot_mode,tv_current_time;
    private CountdownView countdown_view;
    private MyStatusLayout status_layout_spary, status_layout_box_store;
    private SwitchButton switch_button;
    private boolean hasPointed = false; //记录下是否描点了
    private boolean isPos = false;
    List<MyIconModel> mList;
    @Override
    public void initView() {

        setContentView(R.layout.activity_bintong2_agv);
        //dynamicSoreView = findViewById(R.id.dynamicSoreView);
        mPageGridView =findViewById(R.id.vp_grid_view);
        tv_exception = findViewById(R.id.tv_exception);
        mBatteryView = findViewById(R.id.mPowerConsumptionRankingsBatteryView);
        countdown_view = findViewById(R.id.countdown_view);
        mHandler = new BinTongActivity2AGV.NoLeakHandler(this);
        tv_power = findViewById(R.id.tv_power);
        status_layout_spary = findViewById(R.id.status_layout_spary);
        status_layout_box_store = findViewById(R.id.status_layout_box_store);
        switch_button = findViewById(R.id.switch_button);
        tv_get_hanxin_status = findViewById(R.id.tv_get_hanxin_status);
        tv_get_robot_perform_task = findViewById(R.id.tv_get_robot_perform_task);
        tv_robot_register = findViewById(R.id.tv_robot_register);
        tv_robot_mode = findViewById(R.id.tv_robot_mode);
        tv_pre_tasks = findViewById(R.id.tv_pre_tasks);
        tv_current_time = findViewById(R.id.tv_current_time);
        tv_disin_time = findViewById(R.id.tv_disin_time);
        data();
        super.initView();
        mTopBar.setVisibility(View.GONE);
        hideBottomMenu();


    }


    @Override
    protected void initData() {
        super.initData();

        initData2();
        startTiming();//不能放onstart中
        mPageGridView.setData(mList);
        mPageGridView.setOnItemClickListener(new PageGridView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(BinTongActivity2.this,position+"",Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0://启动系统
                        if (Contanst.status_hanxin == 1){
                            Tools.showToast("系统已经开启，无需再启动");
                            return;
                        }
                        if (Contanst.isCurrentChargeTask){
                            Tools.showToast("现在在充电，先取消充电");
                            return;
                        }
                        //核心
                        BitoAPIManager.getInstance().hanxin_start();
                        Contanst.man_switch = 1;
                        UdpControlSendManager.getInstance().set_manual_ctrl_stop(Contanst.id,Contanst.to_id);//打开锁轴
                        break;
                    case 1://关闭系统
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
//                        if (Contanst.isCurrentChargeTask){
//                            Tools.showToast("现在在充电，先取消充电");
//                            return;
//                        }
                        //核心
                        mDialogHelper.showConfirmDialog("关闭系统", new OnDialogConfirmListener() {
                            @Override
                            public void onDialogConfirmListener(AlertDialog dialog) {
                                BitoAPIManager.getInstance().hanxin_stop();
                                Contanst.man_switch = 0;
                                UdpControlSendManager.getInstance().set_manual_ctrl_stop(Contanst.id,Contanst.to_id);//锁轴
                                dialog.dismiss();
                            }
                        });

                        break;
                    case 2://启动消毒
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
                       // BitoAPIManager.getInstance().repeat_tasks();
                        BitoAPIManager.getInstance().add_task_walk();
                        break;
                    case 3://暂停消毒
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }

                        BitoAPIManager.getInstance().pause_robot();
                        break;
                    case 4://恢复消毒
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
                        BitoAPIManager.getInstance().resume_robot();
                        break;
                    case 5://取消消毒
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
                        if (Contanst.isCurrentChargeTask){
                            Tools.showToast("当前正在充电哦");
                            return;
                        }
                       // BitoAPIManager.getInstance().cancel_task_walk();
                        mDialogHelper.showConfirmDialog("取消消毒", new OnDialogConfirmListener() {
                            @Override
                            public void onDialogConfirmListener(AlertDialog dialog) {
                                BitoAPIManager.getInstance().cancle_walk();//
                                dialog.dismiss();
                            }
                        });

                        break;
                    case 6://手动模式下充电
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
                        if (Contanst.isCurrentChargeTask){
                            Tools.showToast("当前正在充电哦");
                            return;
                        }
                        BitoAPIManager.getInstance().repeat_tasks_charge_man();
                        break;
                    case 7://取消手动充电
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }
                        BitoAPIManager.getInstance().cancel_task_charge_man();
                        break;
                    case 8:  //自动模式下充电
                        if (Contanst.status_hanxin == 0){
                            Tools.showToast("系统已经关闭");
                            return;
                        }

                        BitoAPIManager.getInstance().repeat_tasks_charge_auto();
                        break;
                    case 9://建图
                        navi_mode_build();
                        break;
                    case 10://  改名定位    取消建图 （就是切换回定位模式）
                        navi_mode_loc();
                        break;
                    case 11://改名保存地图    建图完成
                        set_save_map();
                        break;
                    case 12://重置机器人
                        mDialogHelper.showConfirmDialog("恢复机器", new OnDialogConfirmListener() {
                            @Override
                            public void onDialogConfirmListener(AlertDialog dialog) {
                                BitoAPIManager.getInstance().reset_agents();//重置机器人
                                BitoAPIManager.getInstance().reset_charging_station();//重置充电桩
                                dialog.dismiss();
                            }
                        });
                        break;
                   case 15://控制
                       Tools.showToast("控制");
                           Intent intent = new Intent(BinTongActivity2AGV.this,WalkingDirectionActivity.class);
                           startActivity(intent);
                        break;
                    case 16://释放
//                        if (Contanst.status_hanxin == 0){
//                            Tools.showToast("系统已经关闭，请开启");
//                            return;
//                        }
                        switch_open();
                        break;
                    case 17://锁轴
//                        if (Contanst.status_hanxin == 0){
//                            Tools.showToast("系统已经关闭，请开启");
//                            return;
//                        }
                        switch_close();
                        break;
                    case 18:
                        Intent i = new Intent(BinTongActivity2AGV.this,BitoSettingActivity.class);
                        startActivity(i);
                        break;
                    case 20:

                        break;
                    case 21:

                        break;
                    case 22:

                        break;
                    case 30://关机
                        power_off();
                        break;
                    case 31://开启喷雾
                        auto_q();
                        break;
                    case 32://关闭喷雾
                        disin_cmd_spray_off();
                        break;
                    case 33:

                        break;
                    case 34:


                        break;
                    case 35:

                        break;
                    case 36:

//                        HttpRequestManager.getInstance().tasks(new HttpCallbackEntity<BaseEntity>() {
//
//                            @Override
//                            public void onSuccess(BaseEntity entity) {
//
//                            }
//
//                            @Override
//                            public void onFailure(String errmsg) {
//
//                            }
//                        });
                        break;

                }
            }
        });
    }


    private void data(){
        //switch_button.setChecked(true);
    }
    @Override
    protected void initListener() {
        super.initListener();
        tv_exception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BinTongActivity2AGV.this,ErrorShowActivity.class);
                startActivity(intent);

            }
        });
        switch_button.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
               // switch_button.setChecked(isChecked);
                if (isChecked){
                    NiceDialog.init().setLayoutId(R.layout.dialog_password).setConvertListener(new ViewConvertListener() {
                        @Override
                        public void convertView(final ViewHolder holder, final BaseNiceDialog dialog) {
                            holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if ( ((EditText)holder.getView(R.id.et_password)).getText().toString().equalsIgnoreCase("123456")){
                                        mPageGridView.setVisibility(View.VISIBLE);
                                    }else if(TextUtils.isEmpty(((EditText)holder.getView(R.id.et_password)).getText().toString())){
                                        Tools.showToast("密码不能为空");
                                        switch_button.setChecked(false);

                                    }else {
                                        Tools.showToast("密码错误");
                                        switch_button.setChecked(false);
                                    }


                                    dialog.dismiss();

                                }
                            });
                        }
                    }).setWidth(250).setHeight(250).setPosition(Gravity.CENTER).show(getSupportFragmentManager());

                }else {
                    mPageGridView.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        HeartbeatManager3.getInstance().start();//获取韩信状态
        HeartbeatManager4.getInstance().start();//当前任务状态
       // HeartbeatManager5.getInstance().start();//异常状态获取
        HeartbeatManager6.getInstance().start();//未执行任务
        HeartbeatManager7.getInstance().start();//轮询充电手动或自动模式
//        List<Integer> list = new ArrayList<>();
//        list.add(99999);
//        list.add(12405);
//        ExceptionCodesCallbackEntity entity = new ExceptionCodesCallbackEntity();
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(3);
//        entity.setNums(list2);
//        entity.setCodes(list);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(145455);
//        list3.add(334636);
//        entity.setStamps(list3);
//        entities = ExceptionCodesHelper.instance.obtainExceptionEntitys(entity);

    }

    @Override
    protected void onStop() {
        super.onStop();
        HeartbeatManager3.getInstance().stop();//关闭韩信
        HeartbeatManager4.getInstance().stop();//关闭任务状态
        //HeartbeatManager5.getInstance().stop();//关闭异常
        HeartbeatManager6.getInstance().stop();//关闭任务状态
        HeartbeatManager7.getInstance().stop();//轮询充电手动或自动模式
        stopTiming();//停止计时
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    /*
     * 接收机器人状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotStatusCallbackEntity entity) {
// wave_view_electric.setmWaterLevel((float) (entity.getBattery_percent() / 1000));//(float) (entity.getBattery_percent()/10)
        mBatteryView.setLevelHeight((int)entity.getBattery_percent()/10);
        tv_power.setText("电量:"+ (int)entity.getBattery_percent() + "%");

        //如果有异常字段为真
//        if (entity.isException()){
//            //获取异常
//            UdpControlSendManager.getInstance().get_robot_exception(Contanst.id,Contanst.to_id);
//        }else {
//
//        };
//
//        if (entity.isCharge_state()){
//            startCharge();
//        }else{
//            // Tools.showToast("停止充电");
//            stopCharge();
//        }
        //电量达到100 就弹出

        if ((int)entity.getBattery_percent() == 100){
            BitoAPIManager.getInstance().cancel_task_charge_man();//先切换成手动再取消充电
            //延迟处理
            BaseApplication.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    HttpRequestManager.getInstance().switch_charging_mode(3,null);//自动充电模式
                }
            },1000);

        }
    }

    /*
     * 接收消毒状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(DesinStateCallbackEntity entity) {
        // Log.e(TAG, "onReceiveMsg: " + entity.toString());
        status_layout_spary.changeStatus(entity.getSpray_level());//喷雾强度
        status_layout_box_store.changeStatus(entity.getBox_store());//蓄水室液位
        countdown_view.updateShow((int) entity.getDisin_time() * 1000);//时间
        tv_disin_time.setText("消毒时间:"+Tools.timeParse((long) (entity.getDisin_time() * 1000)) );

    }

    /*
     * 接收异常代码
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(ExceptionCodesCallbackEntity entity) {


    }
    /*
     * 充电模式监听
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetChargingStatusEntity event) {
        //Contanst.mode = event.mode;//赋值
        tv_robot_mode.setText("充电模式:" + event.getStatus());

    }


    public void setGridView(View view, final int type, List data) {
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               switch (type){
//                   case 0:
//                       if (position == 0){
//
//                           actionStart();
//                       }else if(position == 1){
//
//                           action_cmd_stop();
//                       }else if(position == 2){
//                           navi_mode_build();
//                       }else if(position == 3){
//                           auto_q();
//                       }else if(position == 4){
//                           auto_r();
//                       }else if(position == 5){
//                           Tools.showToast("喷雾关");
//                           disin_cmd_spray_off();
//                       }
//
//                       break;
//                   case 1:
//                       if (position == 0){
//                           navi_mode_loc();
//                       }else if(position == 1){
//                           switch_open();
//                       }else if(position == 2){
//                           switch_close();
//                       }else if(position == 3){
//                           Tools.showToast("打开热点");
//                           robot_wifi_open();
//                       }else if(position == 4){
//                           Tools.showToast("关闭热点");
//                           robot_wifi_close();
//                       }else if(position == 5){
//                           Tools.showToast("连接AP");
//                           robot_wifi_ap_open();
//                       }
//                       break;
//                   case 2:
//                       if (position == 0){
//                           Tools.showToast("断开AP");
//                           robot_wifi_ap_close();
//                       }else if(position == 1){
//                           Tools.showToast("控制");
//                           Intent intent = new Intent(BinTongActivity2.this,WalkingDirectionActivity.class);
//                           startActivity(intent);
//                       }else if(position == 2){
//                           Tools.showToast("锁屏");
//                           lock_screen();
//                       }else if(position == 3){
//                           Tools.showToast("关机");
//                           power_off();
//                       }else if(position == 4){
//                           Tools.showToast("描点");
//                           set_goal();
//                       }else if(position == 5){
//                           set_save_map();
//                       }
//                       break;
//
//
//               }
//            }
//        });
    }
    private void set_goal(){
        //只发一次建图模式
        Tools.showToast(getString(R.string.tracing_point));
        if (!hasPointed){
            //清除描点
            UdpControlSendManager.getInstance().set_goal_new(Contanst.id,Contanst.to_id);

            // Contanst.hasHistoryPoints = true;
            //只有是定位模式才是切换成建图模式
            if (UpdateStateControlManager.getInstance().localization){
                UdpControlSendManager.getInstance().set_navi_mode_build(Contanst.id,Contanst.to_id);
            }
            hasPointed = true;
        }else {
            UdpControlSendManager.getInstance().set_goal_back(Contanst.id,Contanst.to_id);
        }
        EventPoint event = new EventPoint();
        EventBus.getDefault().post(event);
    }
    private void power_off() {
        mDialogHelper.showConfirmDialog(getString(R.string.sure_turn_off), new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                // Tools.showToast("关机");
                UdpControlSendManager.getInstance().set_base_cmd_power_off(Contanst.id, Contanst.to_id);
                mDialogHelper.showLoadingDialog("");
                dialog.dismiss();
            }
        });
    }

    private void lock_screen() {
        Tools.showToast("锁屏");
        Intent intent = new Intent(BinTongActivity2AGV.this,LockScreenActivity.class);
        startActivity(intent);
    }

    private void robot_wifi_ap_close() {
        Tools.showToast("断开AP");
        UdpControlSendManager.getInstance().set_robot_wifi_ap_close(Contanst.id,Contanst.to_id);
    }

    private void robot_wifi_ap_open() {
        Tools.showToast("连接AP");
        UdpControlSendManager.getInstance().set_robot_wifi_ap_open(Contanst.id,Contanst.to_id);
    }

    private void robot_wifi_close() {
        Tools.showToast("已关闭热点");
        UdpControlSendManager.getInstance().set_robot_wifi_close(Contanst.id,Contanst.to_id);
    }

    private void robot_wifi_open() {
        UdpControlSendManager.getInstance().set_robot_wifi_open(Contanst.id,Contanst.to_id);
        Tools.showToast("已打开热点");
    }

    private void switch_close() {
        UdpControlSendManager.getInstance().close_shaft();
        AckListenerService.instance.addACKListener("set_base_cmd", new AckListenerService.ACKListener() {
            @Override
            public void onACK(boolean isSuccess) {

                if (isSuccess){
                    Tools.showToast("加锁成功");

                }else {
                    Tools.showToast("加锁失败");
                }
                AckListenerService.instance.removeACKListener();
            }
        });
    }

    private void switch_open() {
        UdpControlSendManager.getInstance().open_shaft();

        AckListenerService.instance.addACKListener("set_base_cmd", new AckListenerService.ACKListener() {
            @Override
            public void onACK(boolean isSuccess) {

                if (isSuccess){
                    Tools.showToast("解锁成功");

                }else {
                    Tools.showToast("解锁失败");
                }
                AckListenerService.instance.removeACKListener();
            }
        });

    }

    private void navi_mode_loc() {
        //Tools.showToast("已设成location模式");
        UdpControlSendManager.getInstance().set_navi_mode_loc(Contanst.id, Contanst.to_id);
        AckListenerService.instance.addACKListener("set_navi_mode", new AckListenerService.ACKListener() {
            @Override
            public void onACK(boolean isSuccess) {

                if (isSuccess){
                    Tools.showToast("定位成功");

                }else {
                    Tools.showToast("定位失败");
                }
                AckListenerService.instance.removeACKListener();
            }
        });
    }

    private void disin_cmd_spray_off() {
        Tools.showToast("喷雾关");
        UdpControlSendManager.getInstance().set_disin_cmd_spray_off(Contanst.id, Contanst.to_id);
    }

    private void auto_r() {
        Tools.showToast("行走喷雾弱");
        UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,1,1);
    }
    /*
    * 按第一次说1，按第二次是2 第三次变成1
    * */
    int spray_level = 1;
    private void auto_q() {
        //Tools.showToast("行走喷雾");
        UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,3,spray_level);
        spray_level++;
        if (spray_level == 3){
            spray_level = 1;
        }
    }

    private void navi_mode_build() {

        NiceDialog.init().setLayoutId(R.layout.dialog_password).setConvertListener(new ViewConvertListener() {
            @Override
            public void convertView(final ViewHolder holder, final BaseNiceDialog dialog) {
                holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ( ((EditText)holder.getView(R.id.et_password)).getText().toString().equalsIgnoreCase("123456")){
                            UdpControlSendManager.getInstance().set_navi_mode_build(Contanst.id,Contanst.to_id);
                            Tools.showToast(getString(R.string.reset_map));
                        }else if(TextUtils.isEmpty(((EditText)holder.getView(R.id.et_password)).getText().toString())){
                            Tools.showToast("密码不能为空");
                        }else {
                            Tools.showToast("密码错误");
                        }


                        dialog.dismiss();

                    }
                });
            }
        }).setWidth(250).setHeight(250).setPosition(Gravity.CENTER).show(getSupportFragmentManager());

    }

    private void set_save_map() {
        mDialogHelper.showConfirmDialog("保存地图", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                UdpControlSendManager.getInstance().set_save_map(Contanst.id,Contanst.to_id);
                Tools.showToast("保存地图成功");
                dialog.dismiss();
            }
        });

    }

    private void action_cmd_stop() {
        if (switch_button.isChecked()){
            NiceDialog.init().setLayoutId(R.layout.dialog_password).setConvertListener(new ViewConvertListener() {
                @Override
                public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                    holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Tools.showToast("任务停止");
                            UdpControlSendManager.getInstance().set_action_cmd_stop(Contanst.id, Contanst.to_id);
                        }
                    });
                }
            }).setWidth(250).setHeight(250).setPosition(Gravity.CENTER).show(getSupportFragmentManager());
        }else{
            Tools.showToast("任务停止");
            UdpControlSendManager.getInstance().set_action_cmd_stop(Contanst.id, Contanst.to_id);
        }

    }

    /*
    * 启动消毒
    * */
    private void actionStart() {
        if (switch_button.isChecked()){
            NiceDialog.init().setLayoutId(R.layout.dialog_password).setConvertListener(new ViewConvertListener() {
                @Override
                public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                    holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Tools.showToast("消毒任务");
                            UdpControlSendManager.getInstance().set_action_cmd_start(Contanst.id, Contanst.to_id);
                        }
                    });
                }
            }).setWidth(250).setHeight(250).setPosition(Gravity.CENTER).show(getSupportFragmentManager());
        }else{
            Tools.showToast("消毒任务");
            UdpControlSendManager.getInstance().set_action_cmd_start(Contanst.id, Contanst.to_id);
        }

    }
    private void initData2() {
        mList=new ArrayList<>();
        mList.add(new MyIconModel("启动系统",R.drawable.hanxin_start));
        mList.add(new MyIconModel("关闭系统",R.drawable.hanxin_stop));
        mList.add(new MyIconModel("启动",R.drawable.icon_start));
        mList.add(new MyIconModel("暂停",R.drawable.icon_stop));
        mList.add(new MyIconModel("恢复",R.drawable.icon_resume_robot));
        mList.add(new MyIconModel("取消",R.drawable.icon_cancel_walk));
        mList.add(new MyIconModel("手动充电",R.drawable.icon_charge));
        mList.add(new MyIconModel("取消手动充电",R.drawable.icon_cancel_charge));
        mList.add(new MyIconModel("自动充电",R.drawable.icon_charge_auto));
        mList.add(new MyIconModel("建图",R.drawable.icon_map));
        mList.add(new MyIconModel("定位",R.drawable.icon_loaction));
        mList.add(new MyIconModel("保存建图",R.drawable.icon_map_finish));
        mList.add(new MyIconModel("清除故障",R.drawable.icon_reset_agents));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));


        mList.add(new MyIconModel("控制",R.drawable.icon_control));
        mList.add(new MyIconModel("释放锁轴",R.drawable.icon_lock_open));
        mList.add(new MyIconModel("锁轴",R.drawable.icon_lock_close));
//        mList.add(new MyIconModel("打开热点",R.drawable.icon_wifi_open));
//        mList.add(new MyIconModel("关闭热点",R.drawable.icon_wifi_close));
//        mList.add(new MyIconModel("连接AP",R.drawable.icon_ap_open));
//        mList.add(new MyIconModel("断开AP",R.drawable.icon_ap_close));
        //mList.add(new MyIconModel("充电_手动",R.drawable.icon_charging_mode_man));
        mList.add(new MyIconModel("设置",R.drawable.icon_setting));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));
        mList.add(new MyIconModel("",R.drawable.icon_transparent));

        //mList.add(new MyIconModel("导航",R.drawable.icon_navigation));
        //mList.add(new MyIconModel("锁屏",R.drawable.icon_lock_screen));
        mList.add(new MyIconModel("关机",R.drawable.icon_turn_off));

//        mList.add(new MyIconModel("开启喷雾",R.drawable.icon_fog_q));
//        mList.add(new MyIconModel("关闭喷雾",R.drawable.icon_fog_close));

    }

    @Override
    public void callBack(Message msg) {
        switch (msg.what) {
            case 0:

//                long sysTime = System.currentTimeMillis();
//                CharSequence sysTimeStr = DateFormat.format("hh:mm:ss", sysTime);
                String currentDateTimeString =
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA).format(new Date());
                tv_current_time.setText(currentDateTimeString);
                //Log.e(TAG,currentDateTimeString);
                break;
            default:
                break;
        }
    }

    private static class NoLeakHandler<T extends BaseHandlerCallBack> extends Handler {
        private WeakReference<T> wr;

        public NoLeakHandler(T t) {
            wr = new WeakReference<>(t);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t = wr.get();
            if (t != null) {
                t.callBack(msg);
            }
        }
    }

    /*
    * 关闭定时
    *
    * */
    private void stopTiming() {
         mHandler.removeCallbacksAndMessages(null);
        mHandler.removeMessages(0);

    }
    /*
    * 开始计时
    * */
    private void startTiming() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        }, 0, 1000);
    }
    /*
     * 接收韩信状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetHanxinStatusEntity entity) {
        Log.e(TAG,"韩信："+ BitoHanxinManager.obtainState(entity.getStatus()));
        Contanst.status_hanxin = entity.getStatus();
        tv_get_hanxin_status.setText("系统："+ BitoHanxinManager.obtainState(entity.getStatus()));
    }

    /*
     * 接收机器人注册状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotRegisterEvent event) {

        tv_robot_register.setText(event.getStatus());
    }
    /*
          正在执行的任务状态
    * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetRobotPerformTaskEntity entity) {

        //返回正确且有值
        if (entity.getErrno().equalsIgnoreCase(Contanst.REQUEST_OK) && entity.getData().getTasks().size() != 0){
            Log.e(TAG, BitoActionStateManager.obtainState(entity.getData().getTasks().get(0).getStatus()));
            tv_get_robot_perform_task.setText("当前任务:"+BitoActionStateManager.obtainState(entity.getData().getTasks().get(0).getStatus()));
            if (entity.getData().getTasks().get(0).getGoal_action() == 10){//10代表充电
                Contanst.isCurrentChargeTask = true;
            }else{
                tv_get_robot_perform_task.setText("当前任务:"+"无");
                Contanst.isCurrentChargeTask = false;
            }

        }else{
            Contanst.isCurrentChargeTask = false;
            //Tools.showToast("当前没有任务状态");
            tv_get_robot_perform_task.setText("当前任务:"+"无");
        }
    }
    /*
     * 接收未执行的任务
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(TasksEntity event) {

        tv_pre_tasks.setText("剩余任务："+ event.getData().getTasks().size());
    }

    /*
     * 接收异常信息的
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetErrorCodeResultEntity entity) {
        if (entity.hanxins.size() == 0){
            entity.hanxins.addAll(GetErrorCodeEntity.EnBeanToZhCnBeanXX(entity.yugongs));
        }
        entity.hanxins.addAll(GetErrorCodeEntity.EnBeanToZhCnBeanX(entity.charges));
        if (entity.hanxins.size() == 0){
            tv_exception.setVisibility(View.INVISIBLE);
        }else {
            tv_exception.setVisibility(View.VISIBLE);
        }
        //Log.e(TAG,entity.charges.get(0).getError_mode());
//        //充电桩的
//        List<GetErrorCodeEntity.InfoBean.ChargingStationBean.Cj02Bean.EnBean> zhCnBeanXES = new ArrayList<>();//过滤掉重复的
//        for (int i = 0; i < entity.charges.size(); i++) {
//            if (!zhCnBeanXES.contains(entity.charges.get(i))){//如果不包含就加入
//                zhCnBeanXES.add( entity.charges.get(i));
//            }
//        }
//        //韩信  可以恢复的异常
//        List<GetErrorCodeEntity.InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX> zhCnBeanHXSY = new ArrayList<>();
//        //不可恢复的
//        List<GetErrorCodeEntity.InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX> zhCnBeanHXSN = new ArrayList<>();
//        for (int i = 0; i < entity.hanxins.size(); i++) {
//
//            //如果是可以恢复的  否则是不可以恢复的
//            if(entity.hanxins.get(i).getSelf_recoverable().equals("Y")){
//                zhCnBeanHXSY.add(entity.hanxins.get(i));
//            }else if(entity.hanxins.get(i).getSelf_recoverable().equals("N")){
//                zhCnBeanHXSN.add(entity.hanxins.get(i));
//            }
//        }
//
//        //愚公 可以恢复
//        List<GetErrorCodeEntity.InfoBean.YugongBean.Yg00a00020071211000n00BeanX.ZhCnBeanXX> zhCnBeanYGY = new ArrayList<>();
//        //愚公 不可以恢复
//        List<GetErrorCodeEntity.InfoBean.YugongBean.Yg00a00020071211000n00BeanX.ZhCnBeanXX> zhCnBeanYGN = new ArrayList<>();
//        for (int i = 0; i < entity.yugongs.size(); i++) {
//
//            //如果是可以恢复的  否则是不可以恢复的
//            if(entity.yugongs.get(i).getSelf_recoverable().equals("Y")){
//                zhCnBeanYGY.add(entity.yugongs.get(i));
//            }else if(entity.yugongs.get(i).getSelf_recoverable().equals("N")){
//                zhCnBeanYGN.add(entity.yugongs.get(i));
//            }
//        }



    }


}
