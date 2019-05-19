package com.tjedit.finaltest_201904_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

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
                ContextUtil.setUserInputId(mContext, inputId);
                ServerUtil.postRequestSignIn(mContext, inputId, inputPwd, new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(final JSONObject json) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    int code = json.getInt("code");
                                    if (code == 200) {
                                        JSONObject data = json.getJSONObject("data");
                                        String token = data.getString("token");

                                        Intent intent = new Intent(mContext,MainActivity.class);
                                        intent.putExtra("userToken",token);
                                        startActivity(intent);
                                        finish();
                                    } else {

                                        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                                        alert.setTitle("로그인 실패 알림");
                                        alert.setMessage(json.getString("message"));
                                        alert.setPositiveButton("확인", null);
                                        alert.show();
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
        String savedUserId = ContextUtil.getUserInputId(mContext);
        act.idEdt.setText(savedUserId);

        String savedToken = ContextUtil.getUserToekn(mContext);
        Log.d("저장된 토큰값", String.format("토큰값 : %s",savedToken));
    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this,R.layout.activity_login);
    }
}
