package com.goldlogic.jiadianxi.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.ui.WrapContentListView;
import com.goldlogic.jiadianxi.ui.WrapContentViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public class ListFragment extends Fragment {

    private WrapContentViewPager viewPager;
    private int type;

    public ListFragment() {
    }

    @SuppressLint("ValidFragment")
    public ListFragment(WrapContentViewPager viewPager, int type) {
        this.viewPager = viewPager;
        this.type = type;
    }

    @Override
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
    }
}