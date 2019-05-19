package com.tjedit.finaltest_201904_android;

import android.databinding.DataBindingUtil;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tjedit.finaltest_201904_android.databinding.ActivityLoginBinding;
import com.tjedit.finaltest_201904_android.databinding.ActivityMainBinding;
import com.tjedit.finaltest_201904_android.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends  BaseActivity{
ActivityMainBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        act.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void setValues() {
        act.tabLayout.addTab(act.tabLayout.newTab().setText("내 프로필"));
        act.tabLayout.addTab(act.tabLayout.newTab().setText("공지사항"));


    String token = getIntent().getStringExtra("token");
        ServerUtil.getRequestMeInfo(mContext, token, new ServerUtil.JsonResponseHandler() {

            @Override
            public void onResponse(JSONObject json) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            int code  = json.getInt("code");
                            if(code == 200){
                                JSONObject data = json.getJSONObject("data");
                                JSONObject user = data.getJSONObject("user");

                                String profile_image = user.getString("profile_image");
                                String name  = user.getString("name");
                                String billingAccount = user.getString("billing_account");

                                Glide.with(mContext).load(profile_image).into(act.profileImg);
                                act.profileName.setText(name);
                                act.profileBankTxt.setText(billingAccount);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }
}
