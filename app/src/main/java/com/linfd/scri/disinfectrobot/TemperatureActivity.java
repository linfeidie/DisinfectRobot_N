package com.linfd.scri.disinfectrobot;

import android.view.View;

public class TemperatureActivity extends BaseActivity{
    public void initView() {
        setContentView(R.layout.activity_temperature);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
