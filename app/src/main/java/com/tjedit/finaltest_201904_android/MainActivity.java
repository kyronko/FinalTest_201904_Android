package com.tjedit.finaltest_201904_android;

import android.databinding.DataBindingUtil;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tjedit.finaltest_201904_android.adapters.MainViewPagerAdapter;
import com.tjedit.finaltest_201904_android.databinding.ActivityLoginBinding;
import com.tjedit.finaltest_201904_android.databinding.ActivityMainBinding;
import com.tjedit.finaltest_201904_android.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends  BaseActivity{
ActivityMainBinding act;
    MainViewPagerAdapter mvpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        act.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(act.tabLayout));
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

        mvpa = new MainViewPagerAdapter(getSupportFragmentManager(),2);
        act.viewPager.setAdapter(mvpa);


    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }
}
