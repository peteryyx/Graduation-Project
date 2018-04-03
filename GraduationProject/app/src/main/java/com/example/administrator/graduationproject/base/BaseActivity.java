package com.example.administrator.graduationproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/4/3.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(getClass()+"   onCreate()方法");
    }

    @Override
    protected void onStart()    {
        super.onStart();
        Logger.d(getClass()+"   onStart()方法");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(getClass()+"   onStop()方法");

    }

    @Override
    protected void onDestroy(   ) {
        super.onDestroy();
        Logger.d(getClass()+"   onDestroy()方法");

    }

    @Override
    protected void onPause()    {
        super.onPause();
        Logger.d(getClass()+"   onPause()方法");

    }

    @Override
    protected void onResume()    {
        super.onResume();
        Logger.d(getClass()+"   onResume()方法");

    }

    @Override
    protected void onRestart(   ) {
        super.onRestart();
        Logger.d(getClass()+"   onRestart()方法");

    }
}
