package com.want.shoppingcar.shopcar.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.want.shoppingcar.databinding.ItemShopCarProductBinding;
import com.want.shoppingcar.shopcar.entity.ShopcarProductBean;
import com.want.shoppingcar.shopcar.viewmodel.ShopCarProductModel;


/**
 * <b>Create Date:</b> 2017/6/9<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

public class ShopCarViewHolder extends RecyclerView.ViewHolder {

    private ShopCarProductModel mViewModel;

    public ItemShopCarProductBinding mBinding;

    public ShopCarViewHolder(ItemShopCarProductBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
        mViewModel = new ShopCarProductModel();
        mBinding.setModel(mViewModel);
    }
    public void setData(ShopcarProductBean bean) {
        mViewModel.setData(bean);
    }
    public void setShowCheckBox(Boolean bool){
        if(bool){
            mViewModel.setShowCheckBox(View.VISIBLE);
        }else {
            mViewModel.setShowCheckBox(View.GONE);
        }
    }

}
