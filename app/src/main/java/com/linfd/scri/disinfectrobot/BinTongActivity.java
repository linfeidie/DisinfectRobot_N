package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.entity.DesinStateCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionCodesCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.manager.ExceptionCodesHelper;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.nicedialog.BaseNiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.NiceDialog;
import com.linfd.scri.disinfectrobot.nicedialog.ViewConvertListener;
import com.linfd.scri.disinfectrobot.nicedialog.ViewHolder;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.view.MyStatusLayout;
import com.linfd.scri.disinfectrobot.view.battery.BaseHandlerCallBack;
import com.linfd.scri.disinfectrobot.view.battery.PowerConsumptionRankingsBatteryView;
import com.linfd.scri.disinfectrobot.view.recyclerviewpoll.AutoPollAdapter;
import com.linfd.scri.disinfectrobot.view.recyclerviewpoll.AutoPollRecyclerView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.iwgang.countdownview.CountdownView;
import ezy.ui.view.RoundButton;

public class BinTongActivity extends  BaseActivity implements BaseHandlerCallBack  {

    public static final String TAG = BinTongActivity.class.getSimpleName();
    private PowerConsumptionRankingsBatteryView mBatteryView;
    private CountdownView countdown_view;
    private MyStatusLayout status_layout_spary, status_layout_box_store;
    private AutoPollRecyclerView mRecyclerView;
    private ProgressBar pb_linear_velocity,pb_angular_velocity;
    private TextView tv_linear_velocity,tv_angular_velocity;
    private RoundButton tv_set_navi_mode_finish;
    private int power;
    private boolean isCharge = false;// 是否在充电

    private NoLeakHandler mHandler;
    private AutoPollAdapter adapter;
    private RoundButton  tv_set_navi_mode_build, bt_set_action_cmd_stop,bt_manual;
    private RoundButton bt_set_base_cmd_power_off,bt_set_disin_cmd_pump,set_navi_mode_loc;
    private TextView tv_power;


    @Override
    public void initView() {
        setContentView(R.layout.activity_bintong);
        mHandler = new NoLeakHandler(this);
        mBatteryView = findViewById(R.id.mPowerConsumptionRankingsBatteryView);
        countdown_view = findViewById(R.id.countdown_view);
        status_layout_spary = findViewById(R.id.status_layout_spary);
        status_layout_box_store = findViewById(R.id.status_layout_box_store);
        pb_linear_velocity = findViewById(R.id.pb_linear_velocity);
        bt_set_base_cmd_power_off = findViewById(R.id.bt_set_base_cmd_power_off);
        tv_linear_velocity = findViewById(R.id.tv_linear_velocity);
        tv_angular_velocity = findViewById(R.id.tv_angular_velocity);
        tv_set_navi_mode_finish = findViewById(R.id.tv_set_navi_mode_finish);
        set_navi_mode_loc = findViewById(R.id.set_navi_mode_loc);
        super.initView();
        mTopBar.setVisibility(View.GONE);
        hideBottomMenu();

        bt_set_action_cmd_stop = findViewById(R.id.bt_set_action_cmd_stop);
        bt_manual = findViewById(R.id.bt_manual);
        mRecyclerView = (AutoPollRecyclerView) findViewById(R.id.recycleView);
        tv_set_navi_mode_build = findViewById(R.id.tv_set_navi_mode_build);
        tv_power = findViewById(R.id.tv_power);
        pb_angular_velocity = findViewById(R.id.pb_angular_velocity);
        bt_set_disin_cmd_pump = findViewById(R.id.bt_set_disin_cmd_pump);
        adapter = new AutoPollAdapter();
        adapter.setOnItemClickListener(new AutoPollAdapter.OnItemClickListener() {
            @Override
            public void onClick(final ExceptionEntity entity) {
                NiceDialog.init().setLayoutId(R.layout.dialog_exception).setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, BaseNiceDialog dialog) {
                        ((TextView)holder.getView(R.id.tv_degree)).setText(entity.getDegree() == 1 ?"错误":"警告");
                        ((TextView)holder.getView(R.id.tv_component)).setText(entity.getComponent());
                        ((TextView)holder.getView(R.id.tv_explain)).setText(entity.getExplain()+entity.getNums()+"/"+entity.getStamps());
                    }
                }).setWidth(300).setHeight(250).setPosition(Gravity.CENTER).show(getSupportFragmentManager());
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.start();
    }

    @Override
    protected void initListener() {
        super.initListener();
        tv_set_navi_mode_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.reset_map));
                UdpControlSendManager.getInstance().set_navi_mode_build(Contanst.id,Contanst.to_id);
                tv_set_navi_mode_finish.setVisibility(View.VISIBLE);
                tv_set_navi_mode_build.setVisibility(View.GONE);
            }
        });
        tv_set_navi_mode_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UdpControlSendManager.getInstance().set_save_map(Contanst.id,Contanst.to_id);
                Tools.showToast("保存地图成功");
//                AckListenerService.instance.addACKListener("set_save_map", new AckListenerService.ACKListener() {
//                    @Override
//                    public void onACK(boolean isSuccess) {
//
//                        if (isSuccess){
//                            Tools.showToast("保存地图成功");
//                            UdpControlSendManager.getInstance().set_navi_mode_loc(Contanst.id, Contanst.to_id);
//                            AckListenerService.instance.removeACKListener();
//                        }else {
//                            Tools.showToast("保存地图失败");
//                        }
//
//                    }
//                });
                tv_set_navi_mode_finish.setVisibility(View.GONE);
                tv_set_navi_mode_build.setVisibility(View.VISIBLE);
            }
        });
        //任务停止
        bt_set_action_cmd_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast(getString(R.string.stop));
                UdpControlSendManager.getInstance().set_action_cmd_stop(Contanst.id, Contanst.to_id);
                bt_manual.setVisibility(View.VISIBLE);
                bt_set_action_cmd_stop.setVisibility(View.GONE);
            }
        });

        bt_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("启动成功");
                UdpControlSendManager.getInstance().set_action_cmd_start(Contanst.id, Contanst.to_id);
                bt_manual.setVisibility(View.GONE);
                bt_set_action_cmd_stop.setVisibility(View.VISIBLE);
            }
        });

        bt_set_base_cmd_power_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mDialogHelper.showConfirmDialog(getString(R.string.sure_turn_off), new OnDialogConfirmListener() {
//                    @Override
//                    public void onDialogConfirmListener(AlertDialog dialog) {
//                        // Tools.showToast("关机");
//                        UdpControlSendManager.getInstance().set_base_cmd_power_off(Contanst.id, Contanst.to_id);
//                        mDialogHelper.showLoadingDialog("");
//                        dialog.dismiss();
//                    }
//                });

            }
        });
        bt_set_disin_cmd_pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BinTongActivity.this, WalkingDirectionActivity.class);
                startActivity(intent);
            }
        });
        set_navi_mode_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("已设成location模式");
                UdpControlSendManager.getInstance().set_navi_mode_loc(Contanst.id, Contanst.to_id);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Integer> list = new ArrayList<>();
        list.add(99999);
        list.add(12405);
        ExceptionCodesCallbackEntity entity = new ExceptionCodesCallbackEntity();
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        entity.setNums(list2);
        entity.setCodes(list);
        List<Integer> list3 = new ArrayList<>();
        list3.add(145455);
        list3.add(334636);
        entity.setStamps(list3);


        List<ExceptionEntity> entities = ExceptionCodesHelper.instance.obtainExceptionEntitys(entity);
        adapter.setmData(entities);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        if(null != mRecyclerView){
            mRecyclerView.stop();
        }
    }

    @Override
    public void callBack(Message msg) {
        switch (msg.what) {
            case 0:
                if (!isCharge){//搞不清楚 为什么老是回调，只能这样简单粗暴处理了
                    break;
                }
                mBatteryView.setLevelHeight(power += 5);
                if (power == 100) {
                    power = 0;
                }
//                if (power < 30) {
//                    mPowerConsumptionRankingsBatteryView.setLowerPower();
//                } else if (power < 60) {
//                    mPowerConsumptionRankingsBatteryView.setOffline();
//                } else {
//                    mPowerConsumptionRankingsBatteryView.setOnline();
//                }
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
     * 接收机器人状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotStatusCallbackEntity entity) {
       // wave_view_electric.setmWaterLevel((float) (entity.getBattery_percent() / 1000));//(float) (entity.getBattery_percent()/10)
        mBatteryView.setLevelHeight((int)entity.getBattery_percent()/10);
        tv_power.setText("电量:"+ (int)entity.getBattery_percent()/10 + "%");

        pb_linear_velocity.setProgress((int)(entity.getSpeed().get(0)/10));//线速度
        tv_linear_velocity.setText((entity.getSpeed().get(0)/1000+"m/s"));
        pb_angular_velocity.setProgress((int)(entity.getSpeed().get(1)/10));//角速度
        tv_angular_velocity.setText((entity.getSpeed().get(1)/1000)+"r/s");
        //如果有异常字段为真
        if (entity.isException()){
            //获取异常
            UdpControlSendManager.getInstance().get_robot_exception(Contanst.id,Contanst.to_id);
        }else {

        };

        if (entity.isCharge_state()){
            startCharge();
        }else{
           // Tools.showToast("停止充电");
            stopCharge();
        }
    }

    private void stopCharge() {
       // mHandler.removeCallbacksAndMessages(null);
        mHandler.removeMessages(0);
        isCharge = false;
    }

    private void startCharge() {
        if (!isCharge){
            isCharge = true;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mHandler.sendEmptyMessage(0);
                }
            }, 0, 500);
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

    }

    /*
     * 接收异常代码
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(ExceptionCodesCallbackEntity entity) {
        if (entity != null && entity.getCodes().size() != 0){
            List<ExceptionEntity> entities = ExceptionCodesHelper.instance.obtainExceptionEntitys(entity);
            adapter.setmData(entities);
        }

    }
}
