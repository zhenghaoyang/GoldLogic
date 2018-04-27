package com.goldlogic.jiadianxi.subFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.adapter.ProductAdapter;
import com.goldlogic.jiadianxi.bean.Product;
import com.goldlogic.jiadianxi.ui.WrapContentListView;
import com.goldlogic.jiadianxi.ui.WrapContentViewPager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import butterknife.ButterKnife;

import static com.goldlogic.jiadianxi.util.MyApplication.context;

/**
 * Created by Administrator on 2018/3/22.
 */

public class ProductSuperFragment1 extends Fragment {


    private WrapContentListView lvProductListSuper;
    private ProductAdapter productAdapter;
    private WrapContentViewPager viewPager;
    private int type;

    public ProductSuperFragment1() {
    }

    @SuppressLint("ValidFragment")
    public ProductSuperFragment1(WrapContentViewPager viewPager, int type) {
        this.viewPager = viewPager;
        this.type = type;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product_super, null);
        lvProductListSuper = (WrapContentListView) rootView.findViewById(R.id.lv_product_list_super);
        ButterKnife.bind(this, rootView);
        initData();
        lvProductListSuper.setAdapter(productAdapter);//显示列表
        viewPager.calculate(type, lvProductListSuper.getRealHeight());//从新计算
        Log.d("lvProductListSuper超级加息高", "onSuccess: " + lvProductListSuper.getRealHeight());
        return rootView;
    }


    protected void initData() {
        String url = "https://h5.jiadianxi.com/taskapi/getlist?pageindex=1&pageSize=34&year=false";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {


                List<Product> productList = JSON.parseArray(content, Product.class);
                productAdapter = new ProductAdapter(context, productList);
            /*    lvProductListSuper.setAdapter(productAdapter);//显示列表
                viewPager.calculate(type, lvProductListSuper.getRealHeight());
                Log.d("lvProductListSuper超级加息高", "onSuccess: " + lvProductListSuper.getRealHeight());*/
            }

            @Override
            public void onFailure(Throwable error, String content) {

            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
