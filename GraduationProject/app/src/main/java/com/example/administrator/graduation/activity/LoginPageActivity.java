package com.example.administrator.graduation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.base.BaseActivity;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginPageActivity extends BaseActivity {

    @BindView(R.id.account)
    EditText account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.regiest)
    Button regiest;
    @BindView(R.id.denglu)
    Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.regiest, R.id.denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regiest:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(account.getText().toString().trim(), password.getText().toString().trim());
                            Log.e("LoginPageActivity", "注册成功");
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            Log.e("LoginPageActivity", "注册失败");
                        }
                    }
                }).start();
                break;
            case R.id.denglu:
                EMClient.getInstance().login(account.getText().toString().trim(), password.getText().toString().trim(), new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(LoginPageActivity.this, MainActivity.class));
                        Log.d("LoginPageActivity", "onSuccess:登录成功 ");
                        finish();
                    }

                    @Override
                    public void onError(int i, String s) {
                        Log.d("LoginPageActivity", "onSuccess:登录失败 ");

                    }

                    @Override
                    public void onProgress(int i, String s) {
                        Log.d("LoginPageActivity", "onSuccess:登录。。。 ");

                    }
                });
                break;
        }
    }
}
