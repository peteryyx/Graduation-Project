package com.example.administrator.graduationproject.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.graduationproject.R;
import com.example.administrator.graduationproject.universal.Gloabl;
import com.orhanobut.logger.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class HomeFragment extends Fragment {

    private int isClientLServer = 0;

    private Button lianjie;
    private Button put;
    private EditText editText;
    private LinearLayout linearLayout;
    private TextView textView;
    private Socket socket;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            while (true)
                socket = new Socket("10.80.1.155", 9050);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return initView(inflater);
    }

    private View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.h_fragment, null, false);
        lianjie = view.findViewById(R.id.client_socket);
        linearLayout = view.findViewById(R.id.linearLayout);
        editText = view.findViewById(R.id.ed_put);
        put = view.findViewById(R.id.btn_put);
        textView = view.findViewById(R.id.client_get);//显示文本
        if (isClientLServer != 0) {
            lianjie.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            lianjie.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        }
        lianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gloabl.showProgressDialog(getContext(), "", "正在加载......");
                try {
                    socketClientConnectionServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString();
                if (content.trim() == "") {
                    Toast.makeText(getContext(), "未输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        while (true) {
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            out.writeUTF(content);
                            DataInputStream input = new DataInputStream(socket.getInputStream());
                            textView.setText(input.readUTF());
                            socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return view;
    }

    private void socketClientConnectionServer() throws IOException {
        Logger.d("正在连接中");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("客户端请求连接");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        if (input.read() == 1) {
            Toast.makeText(getContext(), "连接成功", Toast.LENGTH_SHORT).show();
            isClientLServer = 1;
        }
        Gloabl.hideProgressDialog();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {super.onViewCreated(view, savedInstanceState);}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
