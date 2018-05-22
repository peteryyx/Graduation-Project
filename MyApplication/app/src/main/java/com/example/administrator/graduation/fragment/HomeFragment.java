package com.example.administrator.graduation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.activity.ChatActivity;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.p_chat_user_id)
    EditText userId;
    Unbinder unbinder;
    @BindView(R.id.start_chat)
    Button startChat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.h_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void startChat() {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra(EaseConstant.EXTRA_USER_ID, userId.getText().toString().trim());
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
        startActivity(intent);
    }

    @OnClick(R.id.start_chat)
    public void onViewClicked() {
        startChat();
    }
}
