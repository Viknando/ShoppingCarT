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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viknando on 2018/5/24.
 */

public class StaggeredAdapter extends DelegateAdapter.Adapter<GuessULikeViewHolder> {

    private Context context;
    private LayoutHelper helper;
    private ActionInterface mActionInterface;
    private List<GuessULikeBean> list = new ArrayList<>();

    public StaggeredAdapter(Context context, LayoutHelper helper) {
        this.context = context;
        this.helper = helper;
    }
    public void setData(List<GuessULikeBean> list){
         this.list=list;
         notifyDataSetChanged();
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

    public void onBindViewHolder(final GuessULikeViewHolder holder, final int position) {
        holder.setData(list.get(position));

        holder.mBinding.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionInterface.doShare(list.get(position));
            }
        });
        holder.mBinding.ivAddtoShopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionInterface.doAddToShopCar(list.get(position));
            }
        });
    }

    public int getItemCount() {
        return list.size();
    }

    /**
     * 分析和添加到购物车的接口
     */
    public interface ActionInterface {
        /**
         * 增加操作
         *
         * @param bean 喜欢的对象
         */
        void doShare(GuessULikeBean bean);

        void doAddToShopCar(GuessULikeBean bean);
    }
    public void setActionInterface(ActionInterface actionInterface){
        mActionInterface=actionInterface;
    }

}
