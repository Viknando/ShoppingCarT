package com.want.shoppingcar.shopcar.cartype;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.want.shoppingcar.R;
import com.want.shoppingcar.ceo.frameThings.PFragment;
import com.want.shoppingcar.databinding.ShopCarFragmentBinding;
import com.want.shoppingcar.shopcar.adapter.DelegateRecyclerAdapter;
import com.want.shoppingcar.shopcar.adapter.StaggeredAdapter;
import com.want.shoppingcar.shopcar.contract.ShopCarContract;
import com.want.shoppingcar.shopcar.entity.ShopcarProductBean;
import com.want.shoppingcar.shopcar.viewmodel.ShopCarModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ShopCarFragment extends PFragment implements DelegateRecyclerAdapter.ModifyCountInterface {
    public ShopCarFragmentBinding binding;
    private ShopCarModel model;
    private StaggeredAdapter staggeredAdapter;
    private DelegateRecyclerAdapter delegateRecyclerAdapter;
    private DelegateAdapter delegateAdapter;
    final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private List<ShopcarProductBean> list;
    private SwipeRefreshLayout swiperereshlayout;

    public static ShopCarFragment newInstance() {
        ShopCarFragment shopCarFragment = new ShopCarFragment();
        return shopCarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.shop_car_fragment, null, false);
        model = new ShopCarModel(getActivity(), getPresenter());
        binding.setModel(model);
        swiperereshlayout = binding.swiperereshlayout;
        setSwipereresh();
        setShopCar(binding.recyclerview);
        return binding.getRoot();
    }

    @Override
    protected ShopCarContract.Presenter getPresenter() {
        return super.getPresenter();
    }

    public void setSwipereresh() {
        swiperereshlayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        //给swipeRefreshLayout绑定刷新监听
        swiperereshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //设置2秒的时间来执行以下事件
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        list.add(new ShopcarProductBean("goodsName" + (list.size()+1), "¥" + (list.size()+1) + ".00", "url" + (list.size()+1), (list.size()+1), "" + (list.size()+1), false, (list.size()+1),list.size()>3?false:true));
                        delegateRecyclerAdapter.setData(list);
                        swiperereshlayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

    public void setShopCar(RecyclerView recyclerView) {
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);


        adapters.add(initDelegateRecycleAdapter(getActivity()));
        adapters.add(initStageredAdapter(getActivity()));

        VirtualLayoutManager manager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);

        delegateAdapter.setAdapters(adapters);
        recyclerView.setAdapter(delegateAdapter);
    }

    public StaggeredAdapter initStageredAdapter(Context context) {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2, 20);
        staggeredAdapter = new StaggeredAdapter(context, staggeredGridLayoutHelper, "StaggeredGridLayoutHelper");
        return staggeredAdapter;
    }

    public DelegateRecyclerAdapter initDelegateRecycleAdapter(Context context) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        delegateRecyclerAdapter = new DelegateRecyclerAdapter(context, linearLayoutHelper);
        delegateRecyclerAdapter.setModifyCountInterface(this);
        list = new ArrayList<>();
        delegateRecyclerAdapter.setData(list);
        return delegateRecyclerAdapter;
    }

    @Override
    public void doIncrease(int position, TextView showCountView, TextView increaseView, TextView decreaseView) {
        int num = Integer.parseInt(showCountView.getText().toString().trim());
        if (num < 99) {
            showCountView.setText("" + (num + 1));
            list.get(position).setBuyNum(num + 1);
            if(num == 98){
                increaseView.setTextColor(Color.parseColor("#E4E3E3"));
            }
        }
        decreaseView.setTextColor(Color.parseColor("#2E2D2D"));
        delegateRecyclerAdapter.setData(list);
    }

    @Override
    public void doDecrease(int position, TextView showCountView, TextView increaseView, TextView decreaseView) {
        if (!"1".equals(showCountView.getText())) {
            int num = Integer.parseInt(showCountView.getText().toString().trim());
            if (num > 1) {
                showCountView.setText("" + (num - 1));
                list.get(position).setBuyNum(num - 1);
                if (num == 2) {
                    decreaseView.setTextColor(Color.parseColor("#E4E3E3"));
                }
            }
        }
        increaseView.setTextColor(Color.parseColor("#2E2D2D"));
        delegateRecyclerAdapter.setData(list);


    }
    public void changeState(){
        delegateRecyclerAdapter.changEdit();
    }
    public boolean isEdit(){
        return delegateRecyclerAdapter.isEidt();
    }
    public void del(){
        delegateRecyclerAdapter.del();
    }

}
