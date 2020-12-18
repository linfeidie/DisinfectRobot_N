package com.linfd.scri.disinfectrobot.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linfd.scri.disinfectrobot.R;
import com.linfd.scri.disinfectrobot.entity.DtcCodesEntity;
import com.linfd.scri.disinfectrobot.manager.BitoAPIManager;
import com.linfd.scri.disinfectrobot.view.recyclerviewUtil.BaseRecyclerViewAdapter;
import com.linfd.scri.disinfectrobot.view.recyclerviewUtil.BaseViewHolder;

import java.util.List;

public class ErrorAdapter extends BaseRecyclerViewAdapter<DtcCodesEntity.DataBean.ListBean> {



    public ErrorAdapter(Context context, List<DtcCodesEntity.DataBean.ListBean> datas, int layoutId) {
        super(context, datas, layoutId);
    }



    @Override
    protected void bindData(final BaseViewHolder holder, final DtcCodesEntity.DataBean.ListBean data, int position) {

        TextView tv_dec1 = (TextView) holder.getView(R.id.tv_dec1);
        TextView tv_dec2 = (TextView) holder.getView(R.id.tv_dec2);
        TextView tv_dec3 = (TextView) holder.getView(R.id.tv_dec3);
        TextView tv_dec4 = (TextView) holder.getView(R.id.tv_dec4);
        Button bt_del = holder.getView(R.id.bt_del);

        if (data.getRecoverable().equalsIgnoreCase("Y")){
            tv_dec1.setText("是");
            bt_del.setVisibility(View.INVISIBLE);
            tv_dec1.setTextColor(holder.getRootView().getResources().getColor(R.color.color_green));

        }else if(data.getRecoverable().equalsIgnoreCase("N") && data.getStatus().equalsIgnoreCase("active")){
            tv_dec1.setText("否");
            bt_del.setVisibility(View.VISIBLE);
            tv_dec1.setTextColor(holder.getRootView().getResources().getColor(R.color.config_color_red));
        }

        tv_dec2.setText(data.getCreate_time()+"");
        tv_dec3.setText(data.getInstruction());
        tv_dec4.setText(data.getInfo());
        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitoAPIManager.getInstance().solve_error_code(data.getDtc_id());

            }
        });

    }
}
