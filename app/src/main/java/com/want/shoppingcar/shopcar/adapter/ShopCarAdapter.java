package com.want.shoppingcar.shopcar.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.want.shoppingcar.R;
import com.want.shoppingcar.databinding.ItemShopCarProductBinding;


public class ShopCarAdapter extends RecyclerView.Adapter<ShopCarViewHolder> {
    @Override
    public ShopCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemShopCarProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_shop_car_product, parent, false);
        ShopCarViewHolder holder = new ShopCarViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShopCarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
