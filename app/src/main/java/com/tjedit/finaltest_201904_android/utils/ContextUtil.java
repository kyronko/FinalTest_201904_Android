package com.tjedit.finaltest_201904_android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {
    private  static  final  String prefName = "fianlTestPref";


    private  static  final  String USER_TOEKN= "USER_TOKEN";



    public  static  void  setUserToken(Context context,String toekn){
        SharedPreferences pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);


        pref.edit().putString(USER_TOEKN, toekn).apply();
    }
    public  static  String getUserToekn(Context context){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return pref.getString(USER_TOEKN,"");
    }


}
