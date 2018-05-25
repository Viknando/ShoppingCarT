package com.want.shoppingcar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.want.shoppingcar.shopcar.cartype.ShopCarFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager frgmentManager = getSupportFragmentManager(); // v4中，getSupportFragmentManager
        FragmentTransaction transaction = frgmentManager.beginTransaction();
        transaction.add(R.id.fragment,ShopCarFragment.newInstance());
        transaction.commit();
    }
}
