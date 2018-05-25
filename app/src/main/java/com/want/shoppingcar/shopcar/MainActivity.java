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
    private Button btn_edit;
    private ShopCarFragment shopCarFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_edit=findViewById(R.id.btn_edit);
        FragmentManager frgmentManager = getSupportFragmentManager(); // v4中，getSupportFragmentManager
        FragmentTransaction transaction = frgmentManager.beginTransaction();
        shopCarFragment = ShopCarFragment.newInstance();
        transaction.add(R.id.fragment,shopCarFragment);
        transaction.commit();
        btn_edit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_edit:
                shopCarFragment.changeState();
                if(shopCarFragment.isEdit()){
                    btn_edit.setText("完成");
                }else{
                    btn_edit.setText("编辑");
                }
        }
    }
}
