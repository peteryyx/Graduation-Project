package com.example.administrator.graduationproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/3/30 0030.
 * Author:于亿鑫
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(getClass().getName()+"测试"+"onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(getClass().getName()+"测试"+"onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d(getClass().getName()+"测试"+"onReStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(getClass().getName()+"测试"+"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(getClass().getName()+"测试"+"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(getClass().getName()+"测试"+"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(getClass().getName()+"测试"+"onDestroy()");
    }
}
