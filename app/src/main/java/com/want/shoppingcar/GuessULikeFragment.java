package com.want.shoppingcar;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.want.shoppingcar.ceo.frameThings.PFragment;
import com.want.shoppingcar.databinding.UlikeFragmentBinding;
import com.want.shoppingcar.shopcar.adapter.GuessULikeAdapter;
import com.want.shoppingcar.shopcar.contract.ShopCarContract;
import com.want.shoppingcar.shopcar.entity.GuessULikeBean;
import com.want.shoppingcar.shopcar.viewmodel.ShopCarModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GuessULikeFragment extends PFragment{
    public UlikeFragmentBinding binding;
    private ShopCarModel model;
    private GuessULikeAdapter guessULikeAdapter;
    private DelegateAdapter delegateAdapter;
    final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private List<GuessULikeBean> uList=new ArrayList<>();
    private MyRecyclerView recyclerView;

    private GuessULikeAdapter.ActionInterface actionInterface;

    public static GuessULikeFragment newInstance() {
        GuessULikeFragment shopCarFragment = new GuessULikeFragment();
//        Bundle args = new Bundle();
//        args.putParcelable("interface",actionInterface);
//        shopCarFragment.setArguments(args);

        return shopCarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.ulike_fragment, null, false);
        model = new ShopCarModel(getActivity(), getPresenter());
        binding.setModel(model);
        recyclerView = binding.recyclerview;
        setShopCar();
        return binding.getRoot();
    }

    @Override
    protected ShopCarContract.Presenter getPresenter() {
        return super.getPresenter();
    }


//    public void setRecycleView() {
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (isSlideToBottom(recyclerView)) {
//                    Log.e("recycleview","isSlideToBottom");
//                }
//            }
//        });
//    }
//
//    private boolean isSlideToBottom(RecyclerView recyclerView) {
//        if (recyclerView == null) return false;
//        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
//            return true;
//        return false;
//    }

    public void setShopCar() {
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        adapters.add(initStageredAdapter(getActivity()));

        VirtualLayoutManager manager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);

        delegateAdapter.setAdapters(adapters);
        recyclerView.setAdapter(delegateAdapter);
    }

    public GuessULikeAdapter initStageredAdapter(Context context) {
        if(guessULikeAdapter!=null){
            return guessULikeAdapter;
        }
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2, 5);
        staggeredGridLayoutHelper.setMargin(13,0,13,0);
        guessULikeAdapter = new GuessULikeAdapter(context, staggeredGridLayoutHelper);
//        guessULikeAdapter.setActionInterface((GuessULikeAdapter.ActionInterface)getArguments().getParcelable("interface"));
        guessULikeAdapter.setData(uList);
        return guessULikeAdapter;
    }


    //guess ulike
    public void addToULike(GuessULikeBean bean) {
        if(uList==null)
            uList=new ArrayList<>();
        uList.add(bean);
        if(guessULikeAdapter ==null)
            initStageredAdapter(getActivity());
        guessULikeAdapter.addData(uList);
    }

    public void addToULike(List<GuessULikeBean> l) {
        if(uList==null)
            uList=new ArrayList<>();
        uList.addAll(l);
        if(guessULikeAdapter ==null)
            initStageredAdapter(getActivity());
        guessULikeAdapter.addData(uList);
    }
    public void setDataToULike(List<GuessULikeBean> l) {
        if(guessULikeAdapter ==null)
            initStageredAdapter(getActivity());
        guessULikeAdapter.setData(l);
    }

//    public void loadMoreULike() {
//        List<GuessULikeBean> l = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            l.add(new GuessULikeBean("uGoodsName" + i, "¥" + i + ".00", "url" + i, "" + i));
//        }
//        addToULike(l);
//    }



}
