package com.example.administrator.graduation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.graduation.GlobalVariable;
import com.example.administrator.graduation.R;
import com.example.administrator.graduation.base.BaseActivity;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hyphenate.EMError.USER_ALREADY_EXIST;
import static com.hyphenate.EMError.USER_ALREADY_LOGIN;
import static com.hyphenate.EMError.USER_NOT_FOUND;
import static com.hyphenate.EMError.USER_REG_FAILED;


public class LoginPageActivity extends BaseActivity {

    @BindView(R.id.account)
    EditText account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.regiest)
    Button regiest;
    @BindView(R.id.denglu)
    Button denglu;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
            }else if (msg.what == USER_ALREADY_EXIST){//203已经注册过
            }else if (msg.what == USER_REG_FAILED){//208注册失败
            }else if (msg.what == 200){
                denglu.setText("登录");
                denglu.setEnabled(true);
            }

            switch(msg.what){
                case 0:
                    Toast.makeText(LoginPageActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    break;
                case USER_ALREADY_EXIST:
                    Toast.makeText(LoginPageActivity.this, "该用户已注册，请登录！", Toast.LENGTH_SHORT).show();
                    break;
                case USER_REG_FAILED:
                    Toast.makeText(LoginPageActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    break;
                case USER_ALREADY_LOGIN://用户不存在(用户已登录)
                    Toast.makeText(LoginPageActivity.this, "用户不存在，请注册", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


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
                            handler.sendEmptyMessage(0);
                            Log.e("LoginPageActivity", "注册成功");
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            handler.sendEmptyMessage(e.getErrorCode());
                            Log.e("LoginPageActivity", "注册失败");
                        }
                    }
                }).start();
                break;
            case R.id.denglu:
                denglu.setText("登录中...");
                denglu.setEnabled(false);
                EMClient.getInstance().login(account.getText().toString().trim(), password.getText().toString().trim(), new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        GlobalVariable.login = 1;//设置成已登录
                        startActivity(new Intent(LoginPageActivity.this, MainActivity.class));
                        Log.d("LoginPageActivity", "onSuccess:登录成功 ");
                        finish();
                    }

                    @Override
                    public void onError(int i, String s) {
                        Log.d("LoginPageActivity", "onSuccess:登录失败 错误码:"+i+"    错误描述:"+s);
                        handler.sendEmptyMessage(i);

                    }

                    @Override
                    public void onProgress(int i, String s) {
                        Log.d("LoginPageActivity", "onProgress:登录中  进度:"+i+"%"+"    描述:"+s);

                    }
                });
                break;
        }
    }
}
