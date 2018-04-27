package com.goldlogic.jiadianxi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.adapter.ListFragmentAdapter;
import com.goldlogic.jiadianxi.bean.BannerImage;
import com.goldlogic.jiadianxi.ui.WrapContentViewPager;
import com.goldlogic.jiadianxi.util.AppNetConfig;
import com.goldlogic.jiadianxi.util.UIUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
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
    WrapContentViewPager vpInvest;
    @Bind(R.id.tv_search)
    EditText tvSearch;
    @Bind(R.id.ll_tab_viewpager)
    LinearLayout llTabViewpager;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initData() {


    }

    @Override
    protected void initTitle() {

    }


    private MyAdapter adapter;

//    private WrapContentViewPager vpInvest;

    private void initFragments() {
        //2.ViewPager设置三个Fragment的显示
//        adapter = new MyAdapter(getFragmentManager());
        vpInvest.setAdapter(new ListFragmentAdapter(vpInvest, getFragmentManager()));
        vpInvest.resetHeight(0);
        //将TabPagerIndicator与ViewPager关联


        vpInvest.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                vpInvest.resetHeight(0);
                tabpageInvest.setViewPager(vpInvest);
            }

            @Override
            public void onPageSelected(int position) {
                vpInvest.resetHeight(position);
                tabpageInvest.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                vpInvest.resetHeight(0);
                tabpageInvest.setViewPager(vpInvest);
            }
        });
//        vpInvest.resetHeight(0);
        tabpageInvest.setViewPager(vpInvest);

    }

    class MyAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> fragments = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
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
        public int getCount() {
            return fragments.size();
        }

        //提供TabPageIndicator的显示内容
        @Override
        public CharSequence getPageTitle(int position) {
            return UIUtils.getStringArr(R.array.invest_tab)[position];
        }


    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_invest;
    }

    List<String> imagesUrl = new ArrayList<>();
    List<BannerImage> productList = new ArrayList<>();

    private void setBanner() {


        //-------------------------------------------------------------------------

        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        //设置网络图片地址构成的集合
        final String url = "https://h5.jiadianxi.com/static/files/slide_data.json";
        final AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {

                productList = JSON.parseArray(content, BannerImage.class);

                for (int i = 0; i < productList.size(); i++) {
                    BannerImage bannerImage = productList.get(i);
                    imagesUrl.add(bannerImage.getImgUrl());
                    Log.d("setBanner", "setBanner: " + bannerImage.getImgUrl());
                }

                banner.setImages(imagesUrl);
                //设置banner动画效果
                banner.setBannerAnimation(Transformer.Default);
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

            @Override
            public void onFailure(Throwable error, String content) {

            }
        });


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
