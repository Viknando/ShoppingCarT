package com.want.shoppingcar.shopcar.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.want.shoppingcar.R;
import com.want.shoppingcar.databinding.ItemShopCarProductBinding;
import com.want.shoppingcar.shopcar.entity.ShopcarProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viknando on 2018/5/24.
 */

public class DelegateRecyclerAdapter extends DelegateAdapter.Adapter<ShopCarViewHolder> {
    public Context context;
    private LayoutHelper helper;
    private List<ShopcarProductBean> list = new ArrayList<>();

    private ModifyCountInterface modifyCountInterface;
    private boolean isEidt;

    public DelegateRecyclerAdapter(Context context, LayoutHelper helper) {
        this.helper = helper;
        this.context = context;
    }

    public void setData(List<ShopcarProductBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void changEdit() {
        isEidt=!isEidt;
        notifyDataSetChanged();
    }
    public boolean isEidt(){
        return isEidt;
    }

    public void del() {
        if(isEidt){
           ArrayList<Integer> delList=new ArrayList<>();
           for(int i=0;i<list.size();i++){
               if(list.get(i).isChoosed()){
                   delList.add(i);
               }
           }
           for (int i=delList.size()-1;i>=0;i--){
               list.remove((int)delList.get(i));
           }
            setData(list);
        }

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    @Override
    public ShopCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemShopCarProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_shop_car_product, parent, false);
        ShopCarViewHolder holder = new ShopCarViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ShopCarViewHolder holder, final int position) {
        holder.setData(list.get(position));

        holder.setShowCheckBox(isEidt);

        //改变背景色的逻辑判断
        if (list.get(position).getBuyNum() == 1) {
            holder.mBinding.reduceGoodsNum.setTextColor(Color.parseColor("#E4E3E3"));
            holder.mBinding.increaseGoodsNum.setTextColor(Color.parseColor("#2E2D2D"));
        } else if (list.get(position).getBuyNum() == 99) {
            holder.mBinding.increaseGoodsNum.setTextColor(Color.parseColor("#E4E3E3"));
            holder.mBinding.reduceGoodsNum.setTextColor(Color.parseColor("#2E2D2D"));
        } else {
            holder.mBinding.increaseGoodsNum.setTextColor(Color.parseColor("#2E2D2D"));
            holder.mBinding.reduceGoodsNum.setTextColor(Color.parseColor("#2E2D2D"));
        }
        holder.mBinding.reduceGoodsNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCountInterface.doDecrease(position, holder.mBinding.goodsNum, holder.mBinding.increaseGoodsNum, holder.mBinding.reduceGoodsNum);
            }
        });
        holder.mBinding.increaseGoodsNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCountInterface.doIncrease(position, holder.mBinding.goodsNum, holder.mBinding.increaseGoodsNum, holder.mBinding.reduceGoodsNum);
            }
        });
        holder.mBinding.cbChoose.setChecked(list.get(position).isChoosed());
        holder.mBinding.cbChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setChoosed(holder.mBinding.cbChoose.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * 改变数量的接口
     */
    public interface ModifyCountInterface {
        /**
         * 增加操作
         *
         * @param childPosition 子元素的位置
         * @param showCountView 用于展示变化后数量的View
         */
        void doIncrease(int childPosition, TextView showCountView, TextView increaseView, TextView decreaseView);

        void doDecrease(int childPosition, TextView showCountView, TextView increaseView, TextView decreaseView);
    }

    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }

}
