package com.goldlogic.jiadianxi.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.adapter.ProductAdapter;
import com.goldlogic.jiadianxi.bean.Product;
import com.goldlogic.jiadianxi.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/22.
 */
//* ListView的使用：①ListView ②BaseAdapter ③Item Layout ④集合数据 (联网获取数据）
public class ProductListFragment extends BaseFragment {


    @Bind(R.id.lv_product_list_all)
    ListView lvProductListAll;
    //装后台传过来的数据
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void initData() {

        //数据
        Product product = new Product();
        productList.add(product);
        productList.add(product);
        productList.add(product);
        //适配器
        ProductAdapter productAdapter = new ProductAdapter(context, productList);
        lvProductListAll.setAdapter(productAdapter);//显示列表

    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product_all;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
