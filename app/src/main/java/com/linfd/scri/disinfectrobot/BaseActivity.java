package com.linfd.scri.disinfectrobot;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.linfd.scri.disinfectrobot.manager.HeartbeatManager3;
import com.stx.xhb.commontitlebar.CustomTitleBar;
import com.td.framework.module.dialog.DialogHelper;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.tsy.sdk.myokhttp.MyOkHttp;

import org.greenrobot.eventbus.EventBus;

/*
*
* */
public  class BaseActivity extends AppCompatActivity implements OnDialogCancelListener {
    protected CustomTitleBar mTopBar;
    protected DialogHelper mDialogHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_main);
        hideBottomMenu();  //先注释掉
        getSupportActionBar().hide();
        initView();
        if (mDialogHelper == null) {
            mDialogHelper = new DialogHelper(BaseActivity.this, this);
        }
        initListener();
        initData();
    }

    protected void initData() {
    }
    protected void initListener(){

    };
    public void initView() {
        mTopBar = (CustomTitleBar) findViewById(R.id.titlebar);
        mTopBar.setTitle(R.string.app_name);

    };

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        hideBottomMenu();
    }
    protected void hideBottomMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
