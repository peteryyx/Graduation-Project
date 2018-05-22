package com.example.administrator.graduation.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends BaseActivity {

    @BindView(R.id.back_up)
    ImageButton backUp;
    @BindView(R.id.chat_for_name)
    TextView chatForName;
    @BindView(R.id.more_setting)
    ImageButton moreSetting;
    @BindView(R.id.im_message)
    RecyclerView imMessage;
    @BindView(R.id.voice)
    ImageButton voice;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.send)
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        imMessage.setLayoutManager(new LinearLayoutManager(this));
//        imMessage.setAdapter();


//        EaseChatFragment chatFragment = new EaseChatFragment();
//        chatFragment.setArguments(getIntent().getExtras());
//        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container,chatFragment).commit();

    }

    @OnClick({R.id.back_up, R.id.more_setting, R.id.voice, R.id.send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_up:
                break;
            case R.id.more_setting:
                break;
            case R.id.voice:
                break;
            case R.id.send:
                break;
        }
    }
}
