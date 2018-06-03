package com.want.shoppingcar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.want.shoppingcar.shopcar.adapter.GuessULikeAdapter;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;

import java.util.ArrayList;
import java.util.List;

public class ScrollFragmentAcitivity extends AppCompatActivity implements View.OnClickListener, GuessULikeAdapter.ActionInterface{
    private Button btn_edit,btn_del,btn_coupon,btn_discount,btn_postage;
    private GuessULikeFragment guessULikeFragment;
    private List<GuessULikeBean> uList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_fragment);
        btn_edit=findViewById(R.id.btn_edit);
        btn_del=findViewById(R.id.btn_del);
        btn_coupon=findViewById(R.id.btn_coupon);
        btn_discount=findViewById(R.id.btn_discount);
        btn_postage=findViewById(R.id.btn_postage);
        btn_edit.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_coupon.setOnClickListener(this);
        btn_discount.setOnClickListener(this);
        btn_postage.setOnClickListener(this);
        FragmentManager frgmentManager = getSupportFragmentManager(); // v4中，getSupportFragmentManager
        FragmentTransaction transaction = frgmentManager.beginTransaction();
        guessULikeFragment = GuessULikeFragment.newInstance();
        uList=new ArrayList<>();
        for (int i = 1; i < 28; i++) {
            if(i%3==0)
                uList.add(new GuessULikeBean("uGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsName" + i, "¥" + i + ".00", "url" + i, "" + i));
            else if((i%7==0))
                uList.add(new GuessULikeBean("uGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsNameuGoodsName" + i, "¥" + i + ".00", "url" + i, "" + i));
            else
                uList.add(new GuessULikeBean("uGoods" + i, "¥" + i + ".00", "url" + i, "" + i));
        }
        guessULikeFragment.setDataToULike(uList);
        transaction.add(R.id.fragment,guessULikeFragment);
        transaction.commit();
        guessULikeFragment.addToULike(new GuessULikeBean("1", "¥.00", "url", "1"));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_edit:
                break;
            case R.id.btn_del:
                break;
            case R.id.btn_coupon:
                break;
            case R.id.btn_discount:
                break;
            case R.id.btn_postage:
                guessULikeFragment.setDataToULike(uList);
                break;
        }
    }

    @Override
    public void doShare(GuessULikeBean bean) {
        Toast.makeText(this, bean.getGoodsName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void doAddToShopCar(GuessULikeBean bean) {
        Log.e("doAddToShopCar","doAddToShopCar");
    }
}
