package com.want.shoppingcar.shopcar.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.want.shoppingcar.shopcar.contract.GuessULikeContract;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;


public class GuessULikeModel extends BaseObservable {
    private GuessULikeContract.Presenter mPresenter;
    private Context mContext;
    private GuessULikeBean data;

    public ObservableField<String> goodsName=new ObservableField<>();
    public ObservableField<String> goodsPrice=new ObservableField<>();
    public ObservableField<String> sellNum=new ObservableField<>();

    public GuessULikeModel(Context context, GuessULikeContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
        this.mContext = context;
    }
    public GuessULikeModel() {
    }
    public void setData(GuessULikeBean data) {
        this.data = data;
        setGoodsName(data.getGoodsName());
        setGoodsPrice(data.getGoodsPrice());
        setSellNum(data.getSellNum());
    }

    public void setGoodsName(String val){
        this.goodsName.set(val);
    }
    public void setSellNum(String val){
        this.sellNum.set("已售:"+val);
    }
    public void setGoodsPrice(String val){
        this.goodsPrice.set(val);
    }
}
