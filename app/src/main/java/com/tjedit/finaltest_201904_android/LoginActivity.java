package com.tjedit.finaltest_201904_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tjedit.finaltest_201904_android.databinding.ActivityLoginBinding;
import com.tjedit.finaltest_201904_android.utils.ServerUtil;
import com.tjedit.finaltest_201904_android.utils.ContextUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
   ActivityLoginBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         bindViews();
         setupEvents();
         setValues();
    }

    @Override
    public void setupEvents() {
        act.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = act.idEdt.getText().toString();
                String inputPwd = act.pwdEdt.getText().toString();
                ServerUtil.postRequestSignIn(mContext, inputId, inputPwd, new ServerUtil.JsonResponseHandler() {
                     @Override
                     public void onResponse(JSONObject json)                         {
                         runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 try {
                                     int code = json.getInt("code");
                                     if(code==200){
                                         JSONObject data = json.getJSONObject("data");
                                         String token = data.getString("token");

                                         ContextUtil.setUserToken(mContext,token);

                                         Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                         intent.putExtra("token",token);

                                         startActivity(intent);
                                         finish();
                                     }
                                     else{
                                         Toast.makeText(mContext, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                     }
                                 } catch (JSONException e) {
                                     e.printStackTrace();
                                 }

                             }
                         });

                     }
                 });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this,R.layout.activity_login);
    }
}
