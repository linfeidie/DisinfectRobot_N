package com.linfd.scri.disinfectrobot;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.linfd.scri.disinfectrobot.entity.GetRobotPerformTaskEntity;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.tools.SPUtils;
import com.linfd.scri.disinfectrobot.tools.Tools;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BitoSettingActivity extends BaseActivity {
    private EditText et_repeat,et_ssid,et_password,et_start_walk_positon,et_goal_walk_position,et_charge_position;
    private Button bt_sure,bt_wifi_open,bt_wifi_close,bt_wifi_ap_open,bt_wifi_ap_close;

    @Override
    public void initView() {
        setContentView(R.layout.activity_bito_setting);
        et_repeat = findViewById(R.id.et_repeat);
        et_ssid = findViewById(R.id.et_ssid);
        et_password = findViewById(R.id.et_password);
        bt_sure = findViewById(R.id.bt_sure);
        et_start_walk_positon = findViewById(R.id.et_start_walk_positon);
        et_goal_walk_position = findViewById(R.id.et_goal_walk_position);
        et_charge_position = findViewById(R.id.et_charge_position);
        bt_wifi_open = findViewById(R.id.bt_wifi_open);
        bt_wifi_close = findViewById(R.id.bt_wifi_close);
        bt_wifi_ap_open = findViewById(R.id.bt_wifi_ap_open);
        bt_wifi_ap_close = findViewById(R.id.bt_wifi_ap_close);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveSetting();
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    protected void onStart() {
        super.onStart();
        int repeat_num = SPUtils.get(SPUtils.repeat_num,1);
        et_repeat.setText(repeat_num+"");
        String ssid =  SPUtils.get(SPUtils.ssid,"");
        et_ssid.setText(ssid);
        et_password.setText(SPUtils.get(SPUtils.passwd,""));
        et_start_walk_positon.setText(SPUtils.get(SPUtils.start_walk_positon,""));
        et_goal_walk_position.setText(SPUtils.get(SPUtils.goal_walk_position,""));
        et_charge_position.setText(SPUtils.get(SPUtils.charge_position,""));
    }

    /*
                  正在执行的任务状态
            * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetRobotPerformTaskEntity entity) {


    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveSetting();
                finish();
            }
        });
        bt_wifi_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot_wifi_open();
            }
        });
        bt_wifi_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot_wifi_close();
            }
        });
        bt_wifi_ap_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot_wifi_ap_open();
            }
        });
        bt_wifi_ap_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot_wifi_ap_close();
            }
        });
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

    private void onSaveSetting() {
        if (!TextUtils.isEmpty(et_repeat.getText().toString())){
           // Contanst.repeat_num =  Integer.valueOf(et_repeat.getText().toString());
            SPUtils.put(SPUtils.repeat_num,Integer.valueOf(et_repeat.getText().toString()));
        }
        if (!TextUtils.isEmpty(et_ssid.getText().toString())){
            //Contanst.ssid = et_ssid.getText().toString();
            SPUtils.put(SPUtils.ssid,et_ssid.getText().toString());
        }
        if (!TextUtils.isEmpty(et_password.getText().toString())){
            //Contanst.passwd =  et_password.getText().toString();
            SPUtils.put(SPUtils.passwd,et_password.getText().toString());
        }
        if (!TextUtils.isEmpty(et_start_walk_positon.getText().toString())){
           // Contanst.start_walk_positon =  et_start_walk_positon.getText().toString();
            SPUtils.put(SPUtils.start_walk_positon,et_start_walk_positon.getText().toString());
        }
        if (!TextUtils.isEmpty(et_goal_walk_position.getText().toString())){
           // Contanst.goal_walk_position =  et_goal_walk_position.getText().toString();
            SPUtils.put(SPUtils.goal_walk_position,et_goal_walk_position.getText().toString());
        }
        if (!TextUtils.isEmpty(et_charge_position.getText().toString())){
            //Contanst.charge_position =  et_charge_position.getText().toString();
            SPUtils.put(SPUtils.charge_position,et_charge_position.getText().toString());
        }
    }

}
