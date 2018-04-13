package com.goldlogic.jiadianxi.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/22.
 */

public class ProductSuperFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }
    @Override
    protected void initData() {

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
}
