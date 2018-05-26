package com.want.shoppingcar.shopcar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.want.shoppingcar.R;

/**
 * Created by viknando on 2018/5/25.
 */

public class ULikeHeaderAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;

    public ULikeHeaderAdapter(Context context, LayoutHelper helper) {
        this.helper = helper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(R.layout.ulike_header_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder{
        public TheViewHolder(View itemView) {
            super(itemView);
        }
    }
}
