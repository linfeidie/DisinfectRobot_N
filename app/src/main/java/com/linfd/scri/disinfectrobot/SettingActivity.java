package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.listener.OnSimpleSeekChangeListener;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.nicedialog.BaseNiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.NiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.ViewConvertListener;
import com.linfd.scri.disinfectrobot.nicedialog.ViewHolder;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.suke.widget.SwitchButton;
import com.warkiz.widget.IndicatorSeekBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ezy.ui.view.RoundButton;



public class SettingActivity extends BaseActivity  {

    public static final String TAG = SettingActivity.class.getSimpleName();
    private RoundButton bt_set_disin_cmd_pump,bt_set_disin_cmd_close;
    private RoundButton tv_manual_q,tv_manual_r,tv_auto_q,tv_auto_r,bt_set_disin_cmd_charge;
    private RoundButton bt_set_disin_cmd_charge_close,bt_loop_time;
    private RoundButton bt_recharging_yes,bt_recharging_no;


    public void initView() {
        setContentView(R.layout.activity_setting);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       // mTopBar.setTitle(R.string.setting);
        mTopBar.setTitle(R.string.control);
        mTopBar.setSubTitle("power:50%");
        TextView textView= new TextView(this);
       // textView.setText("正在开启");
        textView.setTextColor(getResources().getColor(R.color.white));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mTopBar.addLeftView(textView,1,layoutParams);

       // selectToggleGroup = findViewById(R.id.group_choices);
        bt_set_disin_cmd_pump = findViewById(R.id.bt_set_disin_cmd_pump);
        bt_set_disin_cmd_close = findViewById(R.id.bt_set_disin_cmd_close);
        tv_manual_q = findViewById(R.id.tv_manual_q);
        tv_manual_r = findViewById(R.id.tv_manual_r);
        tv_auto_q = findViewById(R.id.tv_auto_q);
        tv_auto_r = findViewById(R.id.tv_auto_r);
        bt_set_disin_cmd_charge = findViewById(R.id.bt_set_disin_cmd_charge);
        bt_set_disin_cmd_charge_close = findViewById(R.id.bt_set_disin_cmd_charge_close);
        bt_loop_time = findViewById(R.id.bt_loop_time);
        bt_recharging_yes = findViewById(R.id.bt_recharging_yes);
        bt_recharging_no = findViewById(R.id.bt_recharging_no);
        bt_recharging_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("任务完成自动回充");
                Contanst.switch_recharging = true;
            }
        });
        bt_recharging_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("任务完成自动不回充");
                Contanst.switch_recharging = false;
            }
        });
        bt_loop_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoopPanel();
            }
        });
        bt_set_disin_cmd_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("打开充电桩");
                //UdpControlSendManager.getInstance().set_base_cmd(Contanst.id, Contanst.to_id,0,true);
            }
        });
        bt_set_disin_cmd_charge_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("关闭充电桩");
               // UdpControlSendManager.getInstance().set_base_cmd(Contanst.id, Contanst.to_id,0,false);
            }
        });

        tv_manual_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("手动喷雾强");
                UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,3,2);
            }
        });
        tv_manual_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("手动喷雾弱");
                UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,3,1);
            }
        });
        tv_auto_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("行走喷雾强");
                UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,1,2);
            }
        });
        tv_auto_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("行走喷雾弱");
                UdpControlSendManager.getInstance().set_disin_cmd(Contanst.id, Contanst.to_id,1,1);
            }
        });



    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        Toast.makeText(this, "弹窗关闭", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_set_disin_cmd_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UdpControlSendManager.getInstance().set_disin_cmd_spray_off(Contanst.id, Contanst.to_id);
                //Tools.showToast("关闭喷雾");
            }
        });



        bt_set_disin_cmd_pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Tools.showToast("抽水");
               // UdpControlSendManager.getInstance().set_disin_cmd_pump(Contanst.id, Contanst.to_id);
               // DrawPathManager.getInstance().cleanTrails();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        boolean d = false;
//                        try {
//                            d = Tools.ping(Contanst.TargetIp);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        Log.e(TAG,"111"+d);
//                    }
//                }).start();
                Intent intent = new Intent(SettingActivity.this, WalkingDirectionActivity.class);
                startActivity(intent);
            }
        });


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    /*
     * 接收机器人状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotStatusCallbackEntity entity) {
        mTopBar.setSubTitle("power:"+ (int)(entity.getBattery_percent()/10)+"%");
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    IndicatorSeekBar sb_loop_time;
    SwitchButton switch_loop_time_panel;
    private void  showLoopPanel(){
        NiceDialog.init().setLayoutId(R.layout.dialog_panel).setConvertListener(new ViewConvertListener() {
            @Override
            public void convertView(final ViewHolder holder, final BaseNiceDialog dialog) {
                sb_loop_time = holder.getView(R.id.sb_loop_time);
                switch_loop_time_panel = holder.getView(R.id.switch_loop_time_panel);
                if ( Contanst.loop_time == -1){
                    holder.getView(R.id.ll_container).setVisibility(View.INVISIBLE);
                    switch_loop_time_panel.setChecked(true);
                }else {
                    holder.getView(R.id.ll_container).setVisibility(View.VISIBLE);
                    sb_loop_time.setProgress(Contanst.loop_time);
                    switch_loop_time_panel.setChecked(false);
                }

                switch_loop_time_panel.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                        //无限循环
                        if (isChecked){
                            holder.getView(R.id.ll_container).setVisibility(View.INVISIBLE);
                            Tools.showToast("开启无限循环");
                            Contanst.loop_time = -1;
                        }else{
                            holder.getView(R.id.ll_container).setVisibility(View.VISIBLE);
                            Contanst.loop_time = 1;

                        }
                    }
                });
                sb_loop_time = holder.getView(R.id.sb_loop_time);
                sb_loop_time.setOnSeekChangeListener(new OnSimpleSeekChangeListener() {
                    @Override
                    public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                        super.onStopTrackingTouch(seekBar);
                        sb_loop_time = seekBar;
                        //赋值
                        Contanst.loop_time = sb_loop_time.getProgress();
                    }
                });
                sb_loop_time.setIndicatorTextFormat("${PROGRESS} 次");


                holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        TcpControlSendManager.set_distance(Math.abs(sb_distance.getProgressFloat()), sb_angular.getProgressFloat(), sb_distance.getProgressFloat() > 0 ? 0.3 : -0.3, sb_angular.getProgressFloat() > 0 ? 0.3 : -0.3);
//                        sb_distance.setProgress(0);
//                        sb_angular.setProgress(0);
                        dialog.dismiss();
                    }

                });

            }
        }).setWidth(0).setHeight(250).setPosition(Gravity.BOTTOM).show(getSupportFragmentManager());
    }

}
