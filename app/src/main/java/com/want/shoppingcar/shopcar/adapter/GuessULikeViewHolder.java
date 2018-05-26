package com.want.shoppingcar.shopcar.adapter;


import android.support.v7.widget.RecyclerView;

import com.want.shoppingcar.databinding.ItemGuessUlikeProductBinding;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;
import com.want.shoppingcar.shopcar.viewmodel.GuessULikeModel;

/**
 * <b>Description:</b> <br>
 */

public class GuessULikeViewHolder extends RecyclerView.ViewHolder {

    private GuessULikeModel mViewModel;

    public ItemGuessUlikeProductBinding mBinding;

    public GuessULikeViewHolder(ItemGuessUlikeProductBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
        mViewModel = new GuessULikeModel();
        mBinding.setModel(mViewModel);
    }
    public void setData(GuessULikeBean bean) {
        mViewModel.setData(bean);
    }

}
