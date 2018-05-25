package com.want.shoppingcar.shopcar.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.want.shoppingcar.R;
import com.want.shoppingcar.databinding.ItemGuessUlikeProductBinding;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;

/**
 * Created by viknando on 2018/5/24.
 */

public class StaggeredAdapter extends DelegateAdapter.Adapter<GuessULikeViewHolder> {

    private Context context;
    private LayoutHelper helper;

    public StaggeredAdapter(Context context, LayoutHelper helper, String name) {
        this.context = context;
        this.helper = helper;
    }

    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @Override
    public GuessULikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGuessUlikeProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_guess_ulike_product, parent, false);
        GuessULikeViewHolder holder = new GuessULikeViewHolder(binding);
        return holder;
    }

    public void onBindViewHolder(final GuessULikeViewHolder holder, int position) {
        holder.setData(new GuessULikeBean("goodsName" + position, "¥" + position + ".00", "url" + position, "" + position));
        ImageView goodsImage = holder.mBinding.goodsImage;
        TextView goodsName = holder.mBinding.goodsName;
        TextView goodsPrice = holder.mBinding.goodsPrice;
        TextView reduceGoodsNum = holder.mBinding.tvSellNum;
        ImageView ivAddtoShopcar=holder.mBinding.ivAddtoShopcar;
        ivAddtoShopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"add to shop car", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount() {
        return 10;
    }

}
