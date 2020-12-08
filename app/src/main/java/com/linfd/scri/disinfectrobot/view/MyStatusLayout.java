package com.linfd.scri.disinfectrobot.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.R;

public class MyStatusLayout extends LinearLayout {
    private View rootView;
    private TextView tv_name;
    private String show_name = "";
    private View view_point1,view_point2;
    public MyStatusLayout(Context context) {
        this(context,null);
    }

    public MyStatusLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public MyStatusLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.MyStatusLayout);
        show_name = array.getString(R.styleable.MyStatusLayout_showName);
        array.recycle();
        init(context);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
        LayoutInflater mInflater = LayoutInflater.from(context);
        rootView = mInflater.inflate(R.layout.layout_my_status, this,false);
        addView(rootView);
        handlerView();
    }

    private void handlerView() {
        tv_name = rootView.findViewById(R.id.tv_name);
        view_point1 = rootView.findViewById(R.id.view_point1);
        view_point2 = rootView.findViewById(R.id.view_point2);
        tv_name.setText(show_name);

    }

    //处理3中状态   关  弱  强
    public void changeStatus(int status){
       if (status == 0){
           close();
       }
       if (status == 1){
           weak();
       }
       if (status == 2){
           strong();
       }
    }

    private void close(){
        view_point1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray));
        view_point2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray));
    }

    private void weak(){
        view_point1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
        view_point2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray));
    }

    private void strong(){
        view_point1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
        view_point2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
    }


}
