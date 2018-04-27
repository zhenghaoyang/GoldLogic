package com.goldlogic.jiadianxi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.fragment.BaseFragment;
import com.goldlogic.jiadianxi.subFragment.ProductSuperFragment;
import com.goldlogic.jiadianxi.subFragment.ProductVIPFragment;
import com.goldlogic.jiadianxi.ui.WrapContentViewPager;
import com.goldlogic.jiadianxi.util.UIUtils;
import com.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public class ListFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();

    public ListFragmentAdapter(WrapContentViewPager viewPager, FragmentManager fm) {
        super(fm);


        fragments.add(new ProductSuperFragment(viewPager, 1));

        fragments.add(new ProductVIPFragment(viewPager, 1));

        fragments.add(new ProductVIPFragment(viewPager, 1));

//        fragments.add(new ListFragment(viewPager, 3));


    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getIconResId(int index) {

        switch (index) {
            case 0:
                return R.drawable.tab_indicator0;
            case 1:
                return R.drawable.tab_indicator1;
            case 2:
                return R.drawable.tab_indicator2;
        }

        return R.drawable.selector_tabtext;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return UIUtils.getStringArr(R.array.invest_tab)[position];
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
