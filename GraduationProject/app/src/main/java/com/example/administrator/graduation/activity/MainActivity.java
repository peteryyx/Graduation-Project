package com.example.administrator.graduation.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.adapter.FmPagerAdapter;
import com.example.administrator.graduation.base.BaseActivity;
import com.example.administrator.graduation.fragment.HomeFragment;
import com.example.administrator.graduation.fragment.PlayFragment;
import com.example.administrator.graduation.fragment.VedioFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ViewPager vpPager;
    TabLayout tlFoot;
    private FmPagerAdapter mfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPager = findViewById(R.id.vp_fragment);
        tlFoot = findViewById(R.id.tl_foot);

        initTabLayout();
    }

    private void initTabLayout() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new VedioFragment());
        fragments.add(new PlayFragment());

        mfa = new FmPagerAdapter(getSupportFragmentManager(),fragments,this);
        vpPager.setAdapter(mfa);
        tlFoot.setupWithViewPager(vpPager);

        tlFoot.getTabAt(0).setIcon(R.drawable.chat);
        tlFoot.getTabAt(1).setIcon(R.drawable.vedio);
        tlFoot.getTabAt(2).setIcon(R.drawable.play);
    }
}
