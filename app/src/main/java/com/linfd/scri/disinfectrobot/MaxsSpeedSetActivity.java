package com.linfd.scri.disinfectrobot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MaxsSpeedSetActivity extends BaseActivity {
    public void initView() {
        setContentView(R.layout.activity_max_speed);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
