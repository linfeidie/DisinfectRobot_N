package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.view.View;

import com.linfd.scri.disinfectrobot.eventbus.EventConnect;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ezy.ui.view.RoundButton;

/*
* 锁屏界面
* */
public class LockScreenActivity extends BaseActivity {
    private RoundButton tv_login;

    public void initView() {
        setContentView(R.layout.activity_lock_screen);
        super.initView();
        mTopBar.setVisibility(View.GONE);
        tv_login = findViewById(R.id.tv_login);
    }

    @Override
    protected void initListener() {
        super.initListener();
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LockScreenActivity.this,BinTongActivity2.class);
                startActivity(intent);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(EventConnect entity) {


    }
}
