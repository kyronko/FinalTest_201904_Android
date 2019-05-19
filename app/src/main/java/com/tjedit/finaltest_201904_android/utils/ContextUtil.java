package com.tjedit.finaltest_201904_android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {
    private  static  final  String prefName = "LoginServerPracticePref";

    private  static  final  String USER_INPUT_ID = "USER_INPUT_ID";
    private  static  final  String USER_TOEKN= "USER_TOKEN";

    public  static  void  setUserInputId(Context context, String inputID){
        SharedPreferences pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);


        pref.edit().putString(USER_INPUT_ID, inputID).apply();
    }
    public  static  String getUserInputId(Context context){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return pref.getString(USER_INPUT_ID,"");
    }
    public  static  void  setUserToken(Context context,String toekn){
        SharedPreferences pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);


        pref.edit().putString(USER_TOEKN, toekn).apply();
    }
    public  static  String getUserToekn(Context context){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return pref.getString(USER_TOEKN,"");
    }


}
