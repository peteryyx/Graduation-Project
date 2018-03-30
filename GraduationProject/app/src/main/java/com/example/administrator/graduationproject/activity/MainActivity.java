package com.example.administrator.graduationproject.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.graduationproject.R;
import com.example.administrator.graduationproject.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image);
        Glide.with(this).load("http://img0.imgtn.bdimg.com/it/u=1983968240,1065183412&fm=27&gp=0.jpg").into(imageView);

    }
}
