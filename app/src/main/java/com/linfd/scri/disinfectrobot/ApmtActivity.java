package com.linfd.scri.disinfectrobot;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;

public class ApmtActivity extends BaseActivity {

    private TextView tv_set_apmt;
    private TimePickerDialog mDialogHourMinute;

    public void initView() {
        setContentView(R.layout.activity_apmt);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle(getResources().getString(R.string.appointment_task));
        tv_set_apmt = findViewById(R.id.tv_set_apmt);
        tv_set_apmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialogHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.HOURS_MINS)
                        .setCallBack(null)
                        .setMinMillseconds(System.currentTimeMillis())
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        .build();
                mDialogHourMinute.show(getSupportFragmentManager(), "hour_minute");
                mDialogHelper.dismissDialog();
            }
        });
    }
}
