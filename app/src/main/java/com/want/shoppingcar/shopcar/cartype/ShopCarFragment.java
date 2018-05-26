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
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.want.shoppingcar.R;
import com.want.shoppingcar.ceo.frameThings.PFragment;
import com.want.shoppingcar.databinding.ShopCarFragmentBinding;
import com.want.shoppingcar.shopcar.adapter.CouponAdapter;
import com.want.shoppingcar.shopcar.adapter.DelegateRecyclerAdapter;
import com.want.shoppingcar.shopcar.adapter.DiscountAdapter;
import com.want.shoppingcar.shopcar.adapter.StaggeredAdapter;
import com.want.shoppingcar.shopcar.contract.ShopCarContract;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;
import com.want.shoppingcar.shopcar.entity.ShopcarProductBean;
import com.want.shoppingcar.shopcar.viewmodel.ShopCarModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ShopCarFragment extends PFragment implements DelegateRecyclerAdapter.ModifyCountInterface, StaggeredAdapter.ActionInterface,CouponAdapter.CouponInterface,DiscountAdapter.DiscountInterface {
    public ShopCarFragmentBinding binding;
    private ShopCarModel model;
    private StaggeredAdapter staggeredAdapter;
    private DelegateRecyclerAdapter delegateRecyclerAdapter;
    private CouponAdapter couponAdapter;
    private DiscountAdapter discountAdapter;
    private DelegateAdapter delegateAdapter;
    final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private List<ShopcarProductBean> list;
    private List<GuessULikeBean> uList;
    private SwipeRefreshLayout swiperereshlayout;
    private RecyclerView recyclerView;

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
        recyclerView = binding.recyclerview;
        setSwipereresh();
        setRecycleView();
        setShopCar();
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
                        addToShopCar(new ShopcarProductBean("goodsName" + (list.size() + 1), "¥" + (list.size() + 1) + ".00", "url" + (list.size() + 1), (list.size() + 1), "" + (list.size() + 1), false, (list.size() + 1), false));
                        swiperereshlayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

    public void setRecycleView() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    loadMoreULike();
                }
            }
        });
    }

    private boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    public void setShopCar() {
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        adapters.add(initCouponAdapter(getActivity()));
        adapters.add(initDiscountAdapter(getActivity()));
        adapters.add(initDelegateRecycleAdapter(getActivity()));
        adapters.add(initStageredAdapter(getActivity()));

        VirtualLayoutManager manager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);

        delegateAdapter.setAdapters(adapters);
        recyclerView.setAdapter(delegateAdapter);
    }

    public CouponAdapter initCouponAdapter(Context context) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        couponAdapter = new CouponAdapter(context, linearLayoutHelper);
        couponAdapter.setCouponInterface(this);
        return couponAdapter;
    }

    public DiscountAdapter initDiscountAdapter(Context context) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        discountAdapter = new DiscountAdapter(context, linearLayoutHelper);
        discountAdapter.setDiscountInterface(this);
        return discountAdapter;
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

    public StaggeredAdapter initStageredAdapter(Context context) {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2, 20);
        staggeredAdapter = new StaggeredAdapter(context, staggeredGridLayoutHelper);
        staggeredAdapter.setActionInterface(this);
        uList = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            uList.add(new GuessULikeBean("uGoodsName" + i, "¥" + i + ".00", "url" + i, "" + i));
        }
        staggeredAdapter.setData(uList);
        return staggeredAdapter;
    }

    //coupon
    @Override
    public void doCoupon(int position) {
        Toast.makeText(getActivity(),"优惠券",Toast.LENGTH_SHORT).show();
    }

    public void changCoupon(){
        couponAdapter.showCoupon(!couponAdapter.isShowing());
    }

    //discount

    @Override
    public void doDiscount(int position) {
        Toast.makeText(getActivity(),"去凑单",Toast.LENGTH_SHORT).show();
    }
    public void changeDiscount(){
        discountAdapter.showDiscount(!discountAdapter.isShowing());
    }
    //shop car
    @Override
    public void doIncrease(int position, TextView showCountView, TextView increaseView, TextView decreaseView) {
        int num = Integer.parseInt(showCountView.getText().toString().trim());
        if (num < 99) {
            showCountView.setText("" + (num + 1));
            list.get(position).setBuyNum(num + 1);
            if (num == 98) {
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

    @Override
    public double doCalculate(List<ShopcarProductBean> list) {
        double money = 0.00;
        for (ShopcarProductBean bean : list) {
            if (!bean.isOutOfStock()) {
                double d = Double.parseDouble(bean.getGoodsPrice().substring(1)) * bean.getBuyNum();
                money += d;
            }
        }
        return money;
    }

    @Override
    public int doBuyNum(List<ShopcarProductBean> list) {
        int num = 0;
        for (ShopcarProductBean bean : list) {
            if (!bean.isOutOfStock()) {
                num += bean.getBuyNum();
            }
        }
        return num;
    }

    @Override
    public void calculateResult(double result, int sum) {
        model.setShouldPay("" + result);
        model.setPay("结算（" + sum + ")");
    }

    public void changeState() {
        delegateRecyclerAdapter.changEdit();
    }

    public boolean isEdit() {
        return delegateRecyclerAdapter.isEidt();
    }

    public void del() {
        delegateRecyclerAdapter.del();
    }

    public void addToShopCar(ShopcarProductBean bean) {
        list.add(bean);
        delegateRecyclerAdapter.setData(list);
    }

    public void addToShopCar(List<ShopcarProductBean> l) {
        list.addAll(l);
        delegateRecyclerAdapter.setData(list);
    }


    //guess ulike
    public void addToULike(GuessULikeBean bean) {
        uList.add(bean);
        staggeredAdapter.setData(uList);
    }

    public void addToULike(List<GuessULikeBean> l) {
        uList.addAll(l);
        staggeredAdapter.setData(uList);
    }

    public void loadMoreULike() {
        List<GuessULikeBean> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(new GuessULikeBean("uGoodsName" + i, "¥" + i + ".00", "url" + i, "" + i));
        }
        addToULike(l);
    }

    @Override
    public void doShare(GuessULikeBean bean) {
        Toast.makeText(getActivity(), bean.getGoodsName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void doAddToShopCar(GuessULikeBean bean) {
        addToShopCar(new ShopcarProductBean(bean.getGoodsName(), "¥" + (list.size() + 1) + ".00", "url" + (list.size() + 1), (list.size() + 1), "" + (list.size() + 1), false, (list.size() + 1), false));
    }


}
