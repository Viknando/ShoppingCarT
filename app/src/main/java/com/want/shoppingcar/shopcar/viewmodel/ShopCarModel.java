package com.want.shoppingcar.shopcar.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.want.shoppingcar.shopcar.contract.ShopCarContract;


public class ShopCarModel extends BaseObservable {
    private ShopCarContract.Presenter mPresenter;
    private Context mContext;
    public ObservableField<String> selectAll=new ObservableField<>();
    public ObservableField<String> pay=new ObservableField<>();
    public ObservableField<String> shouldPay=new ObservableField<>();
    public ObservableField<String> allPrice=new ObservableField<>();
    public ObservableField<String> discount=new ObservableField<>();




    public ObservableField<Integer> showSelectAll=new ObservableField<>();

    public ShopCarModel(Context context, ShopCarContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
        this.mContext = context;
        setSelectAll("全选");
        setPay("结算(10)");
        setShouldPay("¥4.00");
        setAllPrice("¥5.00");
        setDiscount("¥1.00");
        setShowSelectAll(View.GONE);
    }
    public void setSelectAll(String val){
        this.selectAll.set(val);
    }
    public void setPay(String val){
        this.pay.set(val);
    }
    public void setShowSelectAll(int show){
        this.showSelectAll.set(show);
    }
    public void setShouldPay(String val){
        this.shouldPay.set(val);
    }
    public void setAllPrice(String val){
        this.allPrice.set("总价:"+val);
    }
    public void setDiscount(String val){
        this.discount.set("优惠:"+val);
    }
    public void goPay(View v){
        setPay("结算(0)");
    }

}
