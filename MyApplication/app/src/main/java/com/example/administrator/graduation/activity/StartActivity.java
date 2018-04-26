package com.example.administrator.graduation.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.base.BaseActivity;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
                    Thread.sleep(3000);
                    if (sp.getInt("islogin",0)==0) {//判断是否已经登录0为未登录
                        startActivity(new Intent(StartActivity.this,LoginPageActivity.class));
                        finish();
                    }else {//1为已登录
                        startActivity(new Intent(StartActivity.this,MainActivity.class));
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(StartActivity.this,"异常错误",Toast.LENGTH_SHORT).show();
                }
            }
        }).start();
    }
}
