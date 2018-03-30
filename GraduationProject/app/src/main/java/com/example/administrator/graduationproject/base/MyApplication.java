package com.example.administrator.graduationproject.base;

import android.app.Application;

import com.orhanobut.logger.Logger;


/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("测试的TAG");    //LOG TAG默认是PRETTYLOGGER

    }
}
