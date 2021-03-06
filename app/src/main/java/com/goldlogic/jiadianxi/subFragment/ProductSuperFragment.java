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

public class ProductSuperFragment extends BaseFragment {


    @Bind(R.id.lv_product_list_super)
    WrapContentListView lvProductListSuper;
    private ProductAdapter productAdapter;
    private WrapContentViewPager viewPager;
    private int type;

    public ProductSuperFragment() {
    }

    @SuppressLint("ValidFragment")
    public ProductSuperFragment(WrapContentViewPager viewPager, int type) {
        this.viewPager = viewPager;
        this.type = type;
    }


    /* @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, null);
        WrapContentListView listView = (WrapContentListView) view.findViewById(R.id.f_listView);
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < type * 5; i++) {
            data.add("aaa");
        }
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        viewPager.calculate(type, listView.getRealHeight());
        return view;
    }*/
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
                viewPager.calculate(type, lvProductListSuper.getRealHeight());
                Log.d("lvProductListSuper超级加息高", "onSuccess: " + lvProductListSuper.getRealHeight());
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
