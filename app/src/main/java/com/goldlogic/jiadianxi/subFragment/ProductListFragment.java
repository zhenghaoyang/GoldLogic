/*
package com.goldlogic.jiadianxi.subFragment;

import android.os.Bundle;
import android.util.Log;
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

*/
/**
 * Created by Administrator on 2018/3/22.
 *//*

/*/
/* ListView的使用：①ListView ②BaseAdapter ③Item Layout ④集合数据 (联网获取数据）
public class ProductListFragment extends BaseFragment {


    @Bind(R.id.lv_product_list_all)
    ListView lvProductListAll;
    //装后台传过来的数据
//    List<Product> productList = new ArrayList<>();
//    ArrayList<String> imagesUrl = new ArrayList<>(6);
//    Product product = null;
    private ProductAdapter productAdapter;

    @Override
    protected void initData() {
        //解析Json数据
        praseJson();
    }

    private void praseJson() {

        String url = "https://h5.jiadianxi.com/taskapi/getlist";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {


                //List<User> users2 = JSON.parseArray(jsonString2, User.class);
                List<Product> productList = JSON.parseArray(content, Product.class);

//                Log.d("Howy", "onSuccess: " + productList);
//                for (int index = 0; index < productList.size(); index++) {
//                    product = productList.get(index);
//                    productList.add(product);
//                    Log.d("Howy", "---------------------------------" + index + product.toString());
//                }

                productAdapter = new ProductAdapter(context, productList);
                lvProductListAll.setAdapter(productAdapter);//显示列表
                Log.d("Howy", "onSuccess: " + productList + productList.size());
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

    @Override
    protected String getUrl() {
        return null;
    }


}
*/
