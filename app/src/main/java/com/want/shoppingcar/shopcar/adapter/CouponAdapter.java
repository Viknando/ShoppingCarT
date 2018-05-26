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
 * Created by viknando on 2018/5/25.
 */

public class CouponAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;
    private CouponInterface couponInterface;
    private boolean havingData;

    public CouponAdapter(Context context, LayoutHelper helper) {
        this.helper = helper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    public void showCoupon(Boolean bool){
        this.havingData=bool;
        notifyDataSetChanged();
    }
    public boolean isShowing(){
        return havingData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(R.layout.coupon_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TheViewHolder myViewHolder=(TheViewHolder)holder;
        myViewHolder.btv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(couponInterface!=null){
                    couponInterface.doCoupon(position);
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
    public interface CouponInterface {
        /**
         * 点击操作
         */
        void doCoupon(int position);
    }
    public void setCouponInterface(CouponInterface couponInterface){
        this.couponInterface=couponInterface;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder{
        public TextView content;
        public TextView btv;
        public TheViewHolder(View itemView) {
            super(itemView);
            content=(TextView)itemView.findViewById(R.id.tv_coupon);
            btv=(TextView)itemView.findViewById(R.id.btv_coupon);
        }
    }
}
