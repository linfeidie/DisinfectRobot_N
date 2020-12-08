package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.entity.DesinStateCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.eventbus.EventConnect;
import com.linfd.scri.disinfectrobot.manager.AckListenerService;
import com.linfd.scri.disinfectrobot.manager.ComBitmapManager;
import com.linfd.scri.disinfectrobot.manager.DrawPathManager;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.manager.UpdateStateControlManager;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.view.MyStatusLayout;
import com.linfd.scri.disinfectrobot.view.PinchImageView;
import com.linfd.scri.disinfectrobot.view.WaterWaveView;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.iwgang.countdownview.CountdownView;
import ezy.ui.view.RoundButton;


public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private WaterWaveView wave_view_electric;
    private RoundButton bt_set, bt_manual, bt_set_action_cmd_pause, bt_set_action_cmd_resume, bt_set_action_cmd_stop;
    private RoundButton bt_set_charge_power_action, tv_set_navi_mode_build ;;
    private CountdownView countdown_view;
    private PinchImageView pinchImageView;
    private MyStatusLayout status_layout_spary, status_layout_box_store;
    private TextView run_state;

    public void initView() {
        setContentView(R.layout.activity_main);
        wave_view_electric = findViewById(R.id.wave_view_electric);
        bt_set = findViewById(R.id.bt_set);
        countdown_view = findViewById(R.id.countdown_view);
        pinchImageView = findViewById(R.id.iv_bitmap);
        status_layout_spary = findViewById(R.id.status_layout_spary);
        status_layout_box_store = findViewById(R.id.status_layout_box_store);
        bt_manual = findViewById(R.id.bt_manual);//手动巡航
        bt_set_action_cmd_pause = findViewById(R.id.bt_set_action_cmd_pause);
        bt_set_action_cmd_resume = findViewById(R.id.bt_set_action_cmd_resume);
        bt_set_action_cmd_stop = findViewById(R.id.bt_set_action_cmd_stop);
        bt_set_charge_power_action = findViewById(R.id.bt_set_charge_power_action);
        run_state  = findViewById(R.id.run_state);
        tv_set_navi_mode_build = findViewById(R.id.tv_set_navi_mode_build);
        super.initView();

//        mTopBar.addRightImageButton(R.mipmap.ic_setting,R.id.topbar_right_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
//                startActivity(intent);
//            }
//        });
//        mTopBar.setTitle("正在开启");
//        mTopBar.setSubTitle("电量:85%");
        mTopBar.setVisibility(View.GONE);
        hideBottomMenu();
        //hideBottomUIMenu(); 使用这个

        UpdateStateControlManager.getInstance().setBitmapCallback(new UpdateStateControlManager.BitmapCallback() {
            @Override
            public void bitmapFinish(Bitmap bitmap) {
                //currentBitmap = bitmap;
                pinchImageView.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseApplication.isdrawPaht = true;//放这个位置要检测  我也不知道放哪里好
                DrawPathManager.getInstance().cleanTrails();//清除之前的行走路径
                mDialogHelper.showConfirmDialog(getString(R.string.tips1),getString(R.string.redraw_point),getString(R.string.sure), new OnDialogConfirmListener() {
                    @Override
                    public void onDialogConfirmListener(AlertDialog dialog) {
                        Intent intent = new Intent(MainActivity.this, DrawableMapActivity.class);
                        startActivity(intent);
                        ComBitmapManager.getInstance().clearPoints2();//清除之前的描点
                    }
                }, new OnDialogCancelListener() {
                    @Override
                    public void onDialogCancelListener(AlertDialog dialog) {
                        //有历史描点
                        if ((!BaseApplication.isFistBoot)){//Contanst.hasHistoryPoints
                            UdpControlSendManager.getInstance().set_disin_action_strong(Contanst.id, Contanst.to_id);
                            AckListenerService.instance.addACKListener("set_disin_action", new AckListenerService.ACKListener() {
                                @Override
                                public void onACK(boolean isSuccess) {

                                    if (isSuccess){
                                        Tools.showToast("启动成功");
                                        UdpControlSendManager.getInstance().set_action_cmd_start(Contanst.id, Contanst.to_id);
                                        AckListenerService.instance.removeACKListener();
                                    }else {
                                        Tools.showToast("启动失败");
                                    }

                                }
                            });
                            //没有描点过程了，要话路径
                            BaseApplication.isdrawPaht = true;
                            bt_manual.setVisibility(View.GONE);
                            bt_set_action_cmd_resume.setVisibility((View.GONE));
                            bt_set_action_cmd_pause.setVisibility(View.VISIBLE);
                            bt_set_action_cmd_stop.setVisibility(View.VISIBLE);
                            bt_set_charge_power_action.setVisibility(View.VISIBLE);

                        }else {
                            mDialogHelper.showWarningDialog(getString(R.string.tips2), new OnDialogConfirmListener() {
                                @Override
                                public void onDialogConfirmListener(AlertDialog dialog) {
                                    Intent intent = new Intent(MainActivity.this, DrawableMapActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }

                    }
                },true);

            }
        });
        bt_set.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              //  a.add(1);
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        //任务暂停
        bt_set_action_cmd_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.suspend));
                UdpControlSendManager.getInstance().set_action_cmd_pause(Contanst.id, Contanst.to_id);
                bt_set_action_cmd_resume.setVisibility((View.VISIBLE));
                bt_set_charge_power_action.setVisibility(View.VISIBLE);
                bt_manual.setVisibility(View.GONE);
                bt_set_action_cmd_pause.setVisibility(View.GONE);
                bt_set_action_cmd_stop.setVisibility(View.GONE);


            }
        });
        //任务恢复
        bt_set_action_cmd_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.resume));
                UdpControlSendManager.getInstance().set_action_cmd_resume(Contanst.id, Contanst.to_id);
                bt_manual.setVisibility(View.GONE);
                bt_set_action_cmd_resume.setVisibility((View.GONE));
                bt_set_action_cmd_pause.setVisibility(View.VISIBLE);
                bt_set_action_cmd_stop.setVisibility(View.VISIBLE);
                bt_set_charge_power_action.setVisibility(View.VISIBLE);
            }
        });

        //任务停止
        bt_set_action_cmd_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.stop));
                UdpControlSendManager.getInstance().set_action_cmd_stop(Contanst.id, Contanst.to_id);
                bt_set_action_cmd_resume.setVisibility((View.GONE));
                bt_manual.setVisibility(View.VISIBLE);
                bt_set_charge_power_action.setVisibility(View.GONE);
                bt_set_action_cmd_pause.setVisibility(View.GONE);
                bt_set_action_cmd_stop.setVisibility(View.GONE);
            }
        });

        //回充
        bt_set_charge_power_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("对接充电任务");
                UdpControlSendManager.getInstance().set_docking_action(Contanst.id, Contanst.to_id);
                AckListenerService.instance.addACKListener("set_charge_power_action", new AckListenerService.ACKListener() {
                    @Override
                    public void onACK(boolean isSuccess) {

                        if (isSuccess){
                            Tools.showToast("启动成功");
                            UdpControlSendManager.getInstance().set_action_cmd_start(Contanst.id, Contanst.to_id);
                            AckListenerService.instance.removeACKListener();
                        }else {
                            Tools.showToast("启动失败");
                        }

                    }
                });
            }
        });

        tv_set_navi_mode_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.reset_map));
                BaseApplication.isFistBoot = true;
                UdpControlSendManager.getInstance().set_navi_mode_build(Contanst.id,Contanst.to_id);
            }
        });
    }

    @Override
    protected void initData() {

        countdown_view.updateShow(60 * 1000);
        //status_layout_spary.changeStatus(2);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String action_key = intent.getAction();
        if (action_key == Contanst.KEY_SHOW01) {
            bt_manual.setVisibility(View.GONE);
            bt_set_action_cmd_resume.setVisibility((View.GONE));
            bt_set_action_cmd_pause.setVisibility(View.VISIBLE);
            bt_set_action_cmd_stop.setVisibility(View.VISIBLE);
            bt_set_charge_power_action.setVisibility(View.VISIBLE);
        } else {
            bt_set_action_cmd_resume.setVisibility((View.GONE));
            bt_manual.setVisibility(View.VISIBLE);
            bt_set_charge_power_action.setVisibility(View.GONE);
            bt_set_action_cmd_pause.setVisibility(View.GONE);
            bt_set_action_cmd_stop.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*
     * 接收消毒状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(DesinStateCallbackEntity entity) {
        // Log.e(TAG, "onReceiveMsg: " + entity.toString());
        status_layout_spary.changeStatus(entity.getSpray_level());
        status_layout_box_store.changeStatus(entity.getBox_store());
        countdown_view.updateShow((int) entity.getDisin_time() * 1000);
    }

    /*
     * 接收机器人状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotStatusCallbackEntity entity) {
        wave_view_electric.setmWaterLevel((float) (entity.getBattery_percent() / 1000));//(float) (entity.getBattery_percent()/10)
        //Tools.showToast(entity.getAction_state()+"");
        if (entity.getAction_state() == Contanst.action_state_finish || entity.getAction_state() == Contanst.action_state_stop || entity.getAction_state() == Contanst.action_state_idle ){
            bt_manual.setVisibility(View.VISIBLE);
            bt_set_charge_power_action.setVisibility(View.GONE);
            bt_set_action_cmd_resume.setVisibility((View.GONE));
            bt_set_action_cmd_pause.setVisibility(View.GONE);
            bt_set_action_cmd_stop.setVisibility(View.GONE);
        }else if (entity.getAction_state() == Contanst.action_state_running){
            bt_manual.setVisibility(View.GONE);
            bt_set_action_cmd_resume.setVisibility((View.GONE));
            bt_set_action_cmd_pause.setVisibility(View.VISIBLE);
            bt_set_action_cmd_stop.setVisibility(View.VISIBLE);
            bt_set_charge_power_action.setVisibility(View.VISIBLE);
        }
        int action_state = entity.getAction_state();
        String action_stage_des = "";
        if (action_state == Contanst.action_state_idle){
            action_stage_des = "state:idle";
        }else if (action_state == Contanst.action_state_running){
            action_stage_des = "state:running";
        }else if (action_state == Contanst.action_state_pause){
            action_stage_des = "state:pause";
        }else if (action_state == Contanst.action_state_finish){
            action_stage_des = "state:finish";
        }else if (action_state == Contanst.action_state_stop){
            action_stage_des = "state:stop";
        }
        run_state.setText(action_stage_des);


        if (entity.isCharge_state()){
            wave_view_electric.setFlowLeft("充电..");
            wave_view_electric.setmWaveColor(getResources().getColor(R.color.color_green));
            wave_view_electric.startWave();
        }else{
            wave_view_electric.setFlowLeft("电量");
            wave_view_electric.setmWaveColor(getResources().getColor(R.color.colorMajor));
            wave_view_electric.stopWave();
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(EventConnect entity) {
        if (!entity.isConnect){
            Tools.showToast("连接已断开");
        }else{
           // Tools.showToast("连上");
        }

    }

}
