package com.goldlogic.jiadianxi;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goldlogic.jiadianxi.activity.BaseActivity;
import com.goldlogic.jiadianxi.fragment.InvestFragment;
import com.goldlogic.jiadianxi.fragment.MeFragment;
import com.goldlogic.jiadianxi.fragment.MoreFragment;
import com.goldlogic.jiadianxi.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.iv_main_invest)
    ImageView ivMainInvest;
    @Bind(R.id.tv_main_invest)
    TextView tvMainInvest;
    @Bind(R.id.ll_main_invest)
    LinearLayout llMainInvest;
    @Bind(R.id.iv_main_me)
    ImageView ivMainMe;
    @Bind(R.id.tv_main_me)
    TextView tvMainMe;
    @Bind(R.id.ll_main_me)
    LinearLayout llMainMe;
    @Bind(R.id.iv_main_more)
    ImageView ivMainMore;
    @Bind(R.id.tv_main_more)
    TextView tvMainMore;
    @Bind(R.id.ll_main_more)
    LinearLayout llMainMore;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //默认选择第一个页面
        setSelect(0);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //判断选择那个底部导航按钮
    @OnClick({R.id.ll_main_invest, R.id.ll_main_me, R.id.ll_main_more})
    public void showTab(View view) {
        switch (view.getId()) {
            case R.id.ll_main_invest://投资
                setSelect(0);
                Toast.makeText(MainActivity.this, "这里是投资页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_main_me://我的资产
                setSelect(1);
                Toast.makeText(MainActivity.this, "这里是我的资产页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_main_more://更多
                setSelect(2);
                Toast.makeText(MainActivity.this, "这里是更多页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private InvestFragment investFragment;
    private MeFragment meFragment;
    private MoreFragment moreFragment;

    //提供选择的按钮显示fragment
    private void setSelect(int i) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        //隐藏所有Fragment的显示
        hideFragments();
        //重置ImageView和TextView的显示状态
        resetTab();

        switch (i) {
            case 0:
                if (investFragment == null) {
                    investFragment = new InvestFragment();
                    transaction.add(R.id.fl_main, investFragment);
                }
                transaction.show(investFragment);

                //改变选中项的图片和文本颜色的变化
                ivMainInvest.setImageResource(R.mipmap.invest_press);
                tvMainInvest.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor_press));

                break;
            case 1:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.fl_main, meFragment);
                }
                transaction.show(meFragment);

                //改变选中项的图片和文本颜色的变化
                ivMainMe.setImageResource(R.mipmap.me_press);
                tvMainMe.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor_press));

                break;
            case 2:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    transaction.add(R.id.fl_main, moreFragment);
                }
                transaction.show(moreFragment);
                //改变选中项的图片和文本颜色的变化
                ivMainMore.setImageResource(R.mipmap.more_press);
                tvMainMore.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor_press));
                break;
        }
        transaction.commit();//提交事务

    }

    //切换Fragment时，隐藏其他的Fragment
    private void hideFragments() {
        if (investFragment != null) {
            transaction.hide(investFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
    }

    private void resetTab() {

        ivMainInvest.setImageResource(R.mipmap.invest_deafult);
        ivMainMe.setImageResource(R.mipmap.me_default);
        ivMainMore.setImageResource(R.mipmap.more_default);

        tvMainInvest.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor));
        tvMainMe.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor));
        tvMainMore.setTextColor(UIUtils.getColor(R.color.main_bottom_textColor));
        //这种方式也可以
        // tvMainMore.setTextColor(ContextCompat.getColor(this, R.color.home_back_unselected));
    }
}
