package com.example.administrator.graduation.base;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;

/**
 * @Auther 于亿鑫
 * @CreateTime 2018/4/23  15:54
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
        EMClient.getInstance().setDebugMode(true);
    }
}
