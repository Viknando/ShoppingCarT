package com.want.shoppingcar.shopcar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.want.shoppingcar.R;

/**
 * Created by viknando on 2018/5/28.
 */

public class EmptyViewAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;
    private EmptyViewInterface emptyViewInterface;
    private boolean havingData;

    public EmptyViewAdapter(Context context, LayoutHelper helper) {
        this.helper = helper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    public void showEmptyView(Boolean bool){
        this.havingData=bool;
        notifyDataSetChanged();
    }
    public boolean isShowing(){
        return havingData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(R.layout.emptyview_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TheViewHolder myViewHolder=(TheViewHolder)holder;
        myViewHolder.btv_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emptyViewInterface!=null){
                    emptyViewInterface.goShopping();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(havingData){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 改变数量的接口
     */
    public interface EmptyViewInterface {
        /**
         * 点击操作
         */
        void goShopping();
    }
    public void setEmptyViewInterface(EmptyViewInterface emptyViewInterface){
        this.emptyViewInterface=emptyViewInterface;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder{
        public TextView btv_shopping;
        public TheViewHolder(View itemView) {
            super(itemView);
            btv_shopping=(TextView)itemView.findViewById(R.id.btv_shopping);
        }
    }
}
