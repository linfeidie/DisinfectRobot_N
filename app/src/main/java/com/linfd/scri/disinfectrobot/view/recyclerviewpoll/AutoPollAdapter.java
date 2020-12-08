package com.linfd.scri.disinfectrobot.view.recyclerviewpoll;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.linfd.scri.disinfectrobot.R;
import com.linfd.scri.disinfectrobot.entity.ExceptionEntity;

import java.util.List;

public class AutoPollAdapter extends RecyclerView.Adapter<AutoPollAdapter.BaseViewHolder> {
    private  List<ExceptionEntity> mData;
    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(ExceptionEntity entity);
    }

    private OnItemClickListener mListener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public AutoPollAdapter() {

    }

    public void setmData(List<ExceptionEntity> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto_poll, parent, false);
        BaseViewHolder holder = new BaseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (mData == null || mData.size() == 0){
            return;
        }
        final ExceptionEntity data = mData.get(position % mData.size());
        if (data.getDegree() == 1){
            holder.tv.setTextColor(Color.RED);
        }else {
            holder.tv.setTextColor(Color.rgb(255,204,51));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(data);
            }
        });
        holder.tv.setText(data.getExplain());

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public BaseViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);

        }
    }
}
