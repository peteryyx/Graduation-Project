package com.example.administrator.graduationproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.graduationproject.R;
import com.example.administrator.graduationproject.adapter.FmPagerAdapter;
import com.example.administrator.graduationproject.fragment.HomeFragment;
import com.example.administrator.graduationproject.fragment.PlayFragment;
import com.example.administrator.graduationproject.fragment.VedioFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager vpPager;
    TabLayout tlFoot;
    private FmPagerAdapter mfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPager = (ViewPager) findViewById(R.id.vp_fragment);
        tlFoot = (TabLayout) findViewById(R.id.tl_foot);

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
