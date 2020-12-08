package com.linfd.scri.disinfectrobot;

import android.view.View;

import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.linfd.scri.disinfectrobot.tools.Tools;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ezy.ui.view.RoundButton;

/*
* 顶升主界面
* */
public class LiftMainActivity extends BaseActivity{
    private RoundButton bt_lift_cmd_up,bt_lift_cmd_down,bt_lift_cmd_turn;

    public void initView() {
        setContentView(R.layout.activity_lift_main);
        super.initView();
        mTopBar.setVisibility(View.GONE);

        bt_lift_cmd_up = findViewById(R.id.bt_lift_cmd_up);
        bt_lift_cmd_down = findViewById(R.id.bt_lift_cmd_down);
        bt_lift_cmd_turn = findViewById(R.id.bt_lift_cmd_turn);
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_lift_cmd_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("上升");
                UdpControlSendManager.getInstance().set_lift_cmd_up(Contanst.id, Contanst.to_id);
            }
        });
        bt_lift_cmd_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("下降");
                UdpControlSendManager.getInstance().set_lift_cmd_down(Contanst.id, Contanst.to_id);
            }
        });
        bt_lift_cmd_turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.showToast("旋转");
                UdpControlSendManager.getInstance().set_lift_cmd_turn(Contanst.id, Contanst.to_id);
            }
        });
    }

    /*
     * 接收机器人状态
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(RobotStatusCallbackEntity entity) {

    }
}
