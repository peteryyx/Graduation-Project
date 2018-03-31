package com.example.administrator.graduationproject.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;

    public MainFragmentAdapter(FragmentManager fm,List<Fragment> fragments,String[] titles) {
        super(fm);
        mFragments =fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
