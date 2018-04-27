package com.goldlogic.jiadianxi.subFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.adapter.ProductAdapter;
import com.goldlogic.jiadianxi.bean.Product;
import com.goldlogic.jiadianxi.fragment.BaseFragment;
import com.goldlogic.jiadianxi.ui.WrapContentListView;
import com.goldlogic.jiadianxi.ui.WrapContentViewPager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/22.
 */

public class ProductVIPFragment extends BaseFragment {


    @Bind(R.id.lv_product_list_vip)
    WrapContentListView lvProductListVip;
    private ProductAdapter productAdapter;
    private WrapContentViewPager viewPager;
    private int type;


    public ProductVIPFragment() {

    }

    @SuppressLint("ValidFragment")
    public ProductVIPFragment(WrapContentViewPager viewPager, int type) {


        this.viewPager = viewPager;
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    @Override
    protected void initData() {


        String url = "http://h5.jiadianxi.com/taskapi/getlist?pageindex=1&pageSize=36&year=true";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {

                List<Product> productList = JSON.parseArray(content, Product.class);
                productAdapter = new ProductAdapter(context, productList);
                lvProductListVip.setAdapter(productAdapter);//显示列表
                viewPager.calculate(type, lvProductListVip.getRealHeight());
                Log.d("lvProductListVip年化高", "onSuccess: " + lvProductListVip.getRealHeight());
            }

            @Override
            public void onFailure(Throwable error, String content) {

            }
        });


    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product_vip;
    }

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
