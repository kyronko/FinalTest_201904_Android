package com.tjedit.finaltest_201904_android;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tjedit.finaltest_201904_android.databinding.ActivityLoginBinding;

public class MainActivity extends  BaseActivity{
ActivityLoginBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }
}
