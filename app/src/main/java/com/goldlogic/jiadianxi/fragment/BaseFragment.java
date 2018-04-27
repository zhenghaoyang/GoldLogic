package com.goldlogic.jiadianxi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldlogic.jiadianxi.bean.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/21.
 */
public abstract class BaseFragment extends Fragment {

    public Context context;
    //装后台传过来的数据
    public List<Product> productList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = View.inflate(getActivity(), getLayoutId(), null);
        ButterKnife.bind(BaseFragment.this, view);
        return view;
    }


    //初始化界面的数据
    protected abstract void initData();

    //初始化title
    protected abstract void initTitle();

    //提供布局
    public abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    protected abstract String getUrl();


}
