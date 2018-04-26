package com.example.administrator.graduation.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.graduation.R;
import com.example.administrator.graduation.adapter.FmPagerAdapter;
import com.example.administrator.graduation.base.BaseActivity;
import com.example.administrator.graduation.fragment.HomeFragment;
import com.example.administrator.graduation.fragment.PlayFragment;
import com.example.administrator.graduation.fragment.VedioFragment;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    //    ViewPager vpPager;
//    TabLayout tlFoot;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.tl_foot)
    TabLayout tlFoot;
    @BindView(R.id.log_out)
    Button logOut;
    private FmPagerAdapter mfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        vpFragment = findViewById(R.id.vp_fragment);
//        tlFoot = findViewById(R.id.tl_foot);


        /**
         * 退出把持久化登录清除
         */
//        SharedPreferences s = getSharedPreferences("user", MODE_PRIVATE);
//        SharedPreferences.Editor ed = s.edit();
//        ed.putString("name", "");
//        ed.putString("password", "");
//        ed.putInt("islogin", 0);
//        ed.commit();

        initTabLayout();
    }

    private void initTabLayout() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new VedioFragment());
        fragments.add(new PlayFragment());

        mfa = new FmPagerAdapter(getSupportFragmentManager(), fragments, this);
        vpFragment.setAdapter(mfa);
        tlFoot.setupWithViewPager(vpFragment);

        tlFoot.getTabAt(0).setIcon(R.drawable.chat);
        tlFoot.getTabAt(1).setIcon(R.drawable.vedio);
        tlFoot.getTabAt(2).setIcon(R.drawable.play);
    }

    @OnClick(R.id.log_out)
    public void onViewClicked() {

        EMClient.getInstance().logout(true, new EMCallBack() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                EMClient.getInstance().logout(true);
//                Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                Log.d(getClass().getName(), "onSuccess: 退出成功");
                /**
                 * 退出把持久化登录清除
                 */
                SharedPreferences s = getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor ed = s.edit();
                ed.putString("name", "");
                ed.putString("password", "");
                ed.putInt("islogin", 0);
                ed.commit();
                startActivity(new Intent(MainActivity.this,LoginPageActivity.class));
                finish();
            }

            @Override
            public void onProgress(int progress, String status) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onError(int code, String message) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "异常错误-退出失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
