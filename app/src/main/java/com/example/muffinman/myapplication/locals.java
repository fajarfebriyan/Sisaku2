package com.example.muffinman.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ervina on 2/16/2016.
 */
public class locals {
    private static String filename="com.example.muffinman.myapplication.pref";


    //methods
    private static SharedPreferences _shared_preferences(Activity activity)
    {
        return activity.getSharedPreferences(filename, Context.MODE_PRIVATE);
    }

    public static void write(Activity activity,String key, String value)
    {
        _shared_preferences(activity).edit().putString(key,value).commit();
    }
    public static String read(Activity activity,String key)
    {
        return _shared_preferences(activity).getString(key,"");
    }

}
