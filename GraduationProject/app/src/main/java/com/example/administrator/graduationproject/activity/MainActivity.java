package com.example.administrator.graduationproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.graduationproject.R;
import com.example.administrator.graduationproject.adapter.MainFragmentAdapter;
import com.example.administrator.graduationproject.base.BaseActivity;
import com.example.administrator.graduationproject.fragment.HomeFragment;
import com.example.administrator.graduationproject.fragment.PlayFragment;
import com.example.administrator.graduationproject.fragment.VedioFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_fragment)
    ViewPager vpPager;
    @BindView(R.id.tl_foot)
    TabLayout tlFoot;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    private String[] tabs = {"聊天","影音","娱乐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Glide.with(this).load("http://img0.imgtn.bdimg.com/it/u=1983968240,1065183412&fm=27&gp=0.jpg").into(imageView);

        initTabLayout();

    }

    private void initTabLayout() {
//        tabs = getApplicationContext().getResources().getStringArray(R.array.tabs);
        tlFoot.addTab(tlFoot.newTab().setText(tabs[0]).setIcon(R.drawable.select_chat));
        tlFoot.addTab(tlFoot.newTab().setText(tabs[1]).setIcon(R.drawable.select_vedio));
        tlFoot.addTab(tlFoot.newTab().setText(tabs[2]).setIcon(R.drawable.unselect_paly));

//        one = tlFoot.getTabAt(0);
//        two = tlFoot.getTabAt(1);
//        three = tlFoot.getTabAt(2);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(VedioFragment.newInstance());
        fragments.add(PlayFragment.newInstance());

        MainFragmentAdapter mfa = new MainFragmentAdapter(getSupportFragmentManager(),fragments,tabs);
        vpPager.setAdapter(mfa);

        tlFoot.setupWithViewPager(vpPager);

        tlFoot.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO 可抽出来独立判断
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 滑动中执行
            }

            @Override
            public void onPageSelected(int position) {
                // 选中position后执行
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
