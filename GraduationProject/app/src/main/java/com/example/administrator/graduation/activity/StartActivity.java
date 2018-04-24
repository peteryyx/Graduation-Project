package com.example.administrator.graduation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.graduation.GlobalVariable;
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
                    Thread.sleep(3000);
//                    Intent intent = new Intent(StartActivity.this,);
                    if (GlobalVariable.login==0) {
                        startActivity(new Intent(StartActivity.this,LoginPageActivity.class));
                    }else {
                        startActivity(new Intent(StartActivity.this,MainActivity.class));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(StartActivity.this,"异常错误",Toast.LENGTH_SHORT).show();
                }
            }
        }).start();
    }
}
