package com.goldlogic.jiadianxi.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.adapter.ProductAdapter;
import com.goldlogic.jiadianxi.bean.Product;
import com.goldlogic.jiadianxi.fragment.BaseFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/22.
 */

public class ProductSuperFragment extends BaseFragment {


    @Bind(R.id.lv_product_list_super)
    ListView lvProductListSuper;
    private ProductAdapter productAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    @Override
    protected void initData() {
        String url = "https://h5.jiadianxi.com/taskapi/getlist?pageindex=1&pageSize=34&year=false";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                List<Product> productList = JSON.parseArray(content, Product.class);
                productAdapter = new ProductAdapter(context, productList);
                lvProductListSuper.setAdapter(productAdapter);//显示列表
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
        return R.layout.fragment_product_super;
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
