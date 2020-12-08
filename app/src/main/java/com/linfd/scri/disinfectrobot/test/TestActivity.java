package com.linfd.scri.disinfectrobot.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.linfd.scri.disinfectrobot.R;
import com.wihaohao.PageGridView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    List<MyIconModel> mList;

    private PageGridView<MyIconModel> mPageGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mPageGridView =findViewById(R.id.vp_grid_view);
        initData();
        mPageGridView.setData(mList);
        mPageGridView.setOnItemClickListener(new PageGridView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(TestActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void initData() {
        mList=new ArrayList<>();
        for(int i=0;i<30;i++){
            mList.add(new MyIconModel("测试"+i,R.mipmap.ic_launcher));
        }
    }

}
