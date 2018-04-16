package com.goldlogic.jiadianxi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.subFragment.ProductSuperFragment;
import com.goldlogic.jiadianxi.subFragment.ProductVIPFragment;
import com.goldlogic.jiadianxi.subFragment.ProductYearFragment;
import com.goldlogic.jiadianxi.util.AppNetConfig;
import com.goldlogic.jiadianxi.util.UIUtils;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.TabPageIndicator;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/21.
 */

public class InvestFragment extends BaseFragment {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_search)
    EditText tvSearch;
    @Bind(R.id.iv_serach)
    ImageView ivSerach;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.tv_news)
    TextView tvNews;
    @Bind(R.id.news_srouce_company)
    ImageView newsSrouceCompany;
    @Bind(R.id.tabpage_invest)
    TabPageIndicator tabpageInvest;
    @Bind(R.id.vp_invest)
    ViewPager vpInvest;


    @Override
    protected void initData() {


    }

    @Override
    protected void initTitle() {

    }

    private List<Fragment> fragmentList = new ArrayList<>();

    private MyAdapter adapter;

    private void initFragments() {
        //1.加载4个不同的Fragment
//        ProductListFragment productListFragment = new ProductListFragment();
        ProductSuperFragment productRecommondFragment = new ProductSuperFragment();
        ProductYearFragment productHotFragment = new ProductYearFragment();
        ProductVIPFragment productVIPFragment = new ProductVIPFragment();
        //添加到集合中
//        fragmentList.add(productListFragment);
        fragmentList.add(productRecommondFragment);
        fragmentList.add(productHotFragment);
        fragmentList.add(productVIPFragment);

        //2.ViewPager设置三个Fragment的显示
        adapter = new MyAdapter(getFragmentManager());
        vpInvest.setAdapter(adapter);
        //将TabPagerIndicator与ViewPager关联
        tabpageInvest.setViewPager(vpInvest);

    }

    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }

        //提供TabPageIndicator的显示内容
        @Override
        public CharSequence getPageTitle(int position) {
            return UIUtils.getStringArr(R.array.invest_tab)[position];
        }
    }

    ArrayList<String> imagesUrl = new ArrayList<>(3);

    @Override
    public int getLayoutId() {
        return R.layout.fragment_invest;
    }

    private void setBanner() {


        //-------------------------------------------------------------------------

        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());


        //设置网络图片地址构成的集合




//        本地图片
//        Uri uri = Uri.parse("android.resource://" + MyApplication.context.getPackageName() + "/" + R.mipmap.banner);
//        ArrayList<Uri> imagesUrl = new ArrayList<Uri>(3);
//        //三张一样的图片
//        imagesUrl.add(uri);
//        imagesUrl.add(uri);
//        imagesUrl.add(uri);

        banner.setImages(imagesUrl);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        String[] titles = new String[]{"banner1", "banner2", "banner3"};
        banner.setBannerTitles(Arrays.asList(titles));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Picasso 加载图片简单用法
            Picasso.with(context).load((String) path).into(imageView);
//            Picasso.with(context).load((Uri) path).into(imageView);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        setBanner();
        initFragments();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected String getUrl() {
        return AppNetConfig.BASE_URL;
    }
}
