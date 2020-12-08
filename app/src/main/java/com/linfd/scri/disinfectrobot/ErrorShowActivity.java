package com.linfd.scri.disinfectrobot;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.adapter.ErrorAdapter;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeEntity;
import com.linfd.scri.disinfectrobot.entity.GetErrorCodeResultEntity;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager5;
import com.linfd.scri.disinfectrobot.view.recyclerviewUtil.BaseRecyclerViewAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ErrorShowActivity extends BaseActivity {

    public static final String TAG = ErrorShowActivity.class.getSimpleName();
    private TextView tv_yugong;
    private StringBuilder sb_hanxin ;
    private RecyclerView rv_show_err;
    private ErrorAdapter errorAdapter;
    private LinearLayout ll_title;
    @Override
    public void initView() {
        setContentView(R.layout.activity_error_show);
        rv_show_err = findViewById(R.id.rv_show_err);
        ll_title = findViewById(R.id.ll_title);
        super.initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView2();
    }

    @Override
    protected void onStart() {
        super.onStart();
        HeartbeatManager5.getInstance().start();//异常状态获取
    }

    @Override
    protected void onStop() {
        super.onStop();
        HeartbeatManager5.getInstance().stop();
    }

    /*
     * 接收异常信息的
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(GetErrorCodeResultEntity entity) {
       // Log.e(TAG,entity.charges.get(0).getError_mode());
        //entity.charges
//        if (entity.hanxins == null){
//
//        }
        /*
        * 因为韩信和愚公不知道哪个有值 如果韩信为0，那加入愚公
        * */
        if (entity.hanxins.size() == 0){
            entity.hanxins.addAll(GetErrorCodeEntity.EnBeanToZhCnBeanXX(entity.yugongs));
        }
        entity.hanxins.addAll(GetErrorCodeEntity.EnBeanToZhCnBeanX(entity.charges));

       // tv_charging_station.setText(zhCnBeanXES.toString());
        //韩信  可以恢复的异常
        //List<GetErrorCodeEntity.InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX> zhCnBeanHXSY = new ArrayList<>();
        //不可恢复的
       // List<GetErrorCodeEntity.InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX> zhCnBeanHXSN = new ArrayList<>();
//        for (int i = 0; i < entity.hanxins.size(); i++) {
//
//            //如果是可以恢复的  否则是不可以恢复的
//            if (entity.hanxins.get(i).getSelf_recoverable().equalsIgnoreCase("Y")) {
//                zhCnBeanHXSY.add(entity.hanxins.get(i));
//            } else if (entity.hanxins.get(i).getSelf_recoverable().equalsIgnoreCase("N")) {
//                zhCnBeanHXSN.add(entity.hanxins.get(i));
//            }
//      //      sb_hanxin.append(zhCnBeanHXSY.get(i).getError_mode()).append(",");
//        }
        if (entity.hanxins.size() == 0){
            rv_show_err.setVisibility(View.GONE);
            ll_title.setVisibility(View.GONE);
        }else {
            rv_show_err.setVisibility(View.VISIBLE);
            ll_title.setVisibility(View.VISIBLE);
        }
        errorAdapter = new ErrorAdapter(this, entity.hanxins, R.layout.item_error);
        if (errorAdapter != null){
            rv_show_err.setAdapter(errorAdapter);
        }


    }

    private void initView2() {
        //initData();
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_show_err.setLayoutManager(mLinearLayoutManager);
        //添加Android自带的分割线
        rv_show_err.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //errorAdapter = new ErrorAdapter(this, entity.hanxins, R.layout.item_error);
   //     mAdapter.setOnItemClickListner( this );

//        mUserSimpleRecycleAdapter = new UserSimpleRecycleAdapter(mContext, datas);



    }
}
