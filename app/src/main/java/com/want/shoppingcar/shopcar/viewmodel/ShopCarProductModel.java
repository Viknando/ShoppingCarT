package com.want.shoppingcar.shopcar.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.want.shoppingcar.shopcar.contract.ShopCarProductContract;
import com.want.shoppingcar.shopcar.entity.ShopcarProductBean;

public class ShopCarProductModel extends BaseObservable {
    private ShopCarProductContract.Presenter mPresenter;
    private Context mContext;
    private ShopcarProductBean data;
    public ObservableField<Integer> showCheckBox=new ObservableField<>();
    public ObservableField<String> goodsName=new ObservableField<>();
    public ObservableField<String> goodSize=new ObservableField<>();
    public ObservableField<String> goodsPrice=new ObservableField<>();
    public ObservableField<String> coupon=new ObservableField<>();
    public ObservableField<Integer> showCoupon=new ObservableField<>();
    public ObservableField<String> buyNum=new ObservableField<>();


    public ShopCarProductModel(Context context, ShopCarProductContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
        this.mContext = context;
    }
    public ShopCarProductModel() {
    }
    public void setData(ShopcarProductBean data) {
        this.data = data;
        setGoodsName(data.getGoodsName());
        setGoodSize(data.getGoodsSize());
        setGoodsPrice(data.getGoodsPrice());
        setCoupon(data.getGoodsPrice());//yet
        setShowCoupon(View.GONE);
        setShowCheckBox(data.isChoosed()? View.VISIBLE: View.GONE);
        setBuyNum(data.getBuyNum());

    }
    public void setShowCheckBox(int visible){
        this.showCheckBox.set(visible);
    }
    public void setGoodsName(String val){
        this.goodsName.set(val);
    }
    public void setGoodSize(String val){
        this.goodSize.set("规格:"+val);
    }
    public void setGoodsPrice(String val){
        this.goodsPrice.set(val);
    }
    public void setCoupon(String val){
        this.coupon.set(val);
    }
    public void setShowCoupon(int visible){
        this.showCoupon.set(visible);
    }
    public void setBuyNum(int val){
        this.buyNum.set(""+val);
    }

}
