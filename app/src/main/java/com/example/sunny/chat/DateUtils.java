package com.example.sunny.chat;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;


public  class DateUtils {


    @SuppressLint("SimpleDateFormat")
    public static String dateToString(Date date) {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        datestr = df.format(date);
        return datestr;
    }

}