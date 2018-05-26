package com.want.shoppingcar.shopcar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.want.shoppingcar.R;
import com.want.shoppingcar.shopcar.cartype.ShopCarFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_edit,btn_del,btn_coupon,btn_discount,btn_postage;
    private ShopCarFragment shopCarFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_edit=findViewById(R.id.btn_edit);
        btn_del=findViewById(R.id.btn_del);
        btn_coupon=findViewById(R.id.btn_coupon);
        btn_discount=findViewById(R.id.btn_discount);
        btn_postage=findViewById(R.id.btn_postage);
        FragmentManager frgmentManager = getSupportFragmentManager(); // v4中，getSupportFragmentManager
        FragmentTransaction transaction = frgmentManager.beginTransaction();
        shopCarFragment = ShopCarFragment.newInstance();
        transaction.add(R.id.fragment,shopCarFragment);
        transaction.commit();
        btn_edit.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_coupon.setOnClickListener(this);
        btn_discount.setOnClickListener(this);
        btn_postage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_edit:
                shopCarFragment.changeState();
                shopCarFragment.changDel();
                if(shopCarFragment.isEdit()){
                    btn_edit.setText("完成");
                }else{
                    btn_edit.setText("编辑");
                }
                break;
            case R.id.btn_del:
                shopCarFragment.del();
                break;
            case R.id.btn_coupon:
                shopCarFragment.changCoupon();
                break;
            case R.id.btn_discount:
                shopCarFragment.changeDiscount();
                break;
            case R.id.btn_postage:
                shopCarFragment.changPostage();
                break;
        }
    }
}
