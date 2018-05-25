//package com.want.shoppingcar.shopcar;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.View;
//
//import com.want.shoppingcar.shopcar.cartype.ShopCarFragment;
//
//
//public class ShopCarActivity extends PSellerActivity {
//
//    public static void start(Context context) {
//        Intent starter = new Intent(context, ShopCarActivity.class);
//        context.startActivity(starter);
//    }
//
//    @Override
//    protected Fragment setupFragment() {
//        return ShopCarFragment.newInstance();
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        requestNavigation(false);
//        activities.add(this);
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        resetToolbarIcon();
//    }
//
//    private void resetToolbarIcon() {
//        if (mToolbarMsgIcon != null && mToolbarSearchIcon != null && mToolbarSettingIcon != null) {
//            mToolbarMsgIcon.setVisibility(View.GONE);
//            mToolbarSearchIcon.setVisibility(View.GONE);
//            mToolbarSettingIcon.setVisibility(View.GONE);
//        }
//    }
//}
