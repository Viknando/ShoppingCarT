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

public class PostageAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;
    private PostageInterface postageInterface;
    private boolean havingData;
    private String msg="",msg2="";

    public PostageAdapter(Context context, LayoutHelper helper) {
        this.helper = helper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    public void showPostage(Boolean bool){
        this.havingData=bool;
        notifyDataSetChanged();
    }
    public boolean isShowing(){
        return havingData;
    }

    public void setMsg(String msg,String msg2){
        this.msg=msg;
        this.msg2=msg2;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(R.layout.postage_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TheViewHolder myViewHolder=(TheViewHolder)holder;
        myViewHolder.tv_msg.setText(msg);
        myViewHolder.tv_msg2.setText(msg2);
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
    public interface PostageInterface {
        /**
         * 点击操作
         */
        void doPostage(int position);
    }
    public void setPostageInterface(PostageInterface postageInterface){
        this.postageInterface=postageInterface;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_msg;
        public TextView tv_msg2;
        public TheViewHolder(View itemView) {
            super(itemView);
            tv_msg=(TextView)itemView.findViewById(R.id.tv_msg);
            tv_msg2=(TextView)itemView.findViewById(R.id.tv_msg2);
        }
    }
}
