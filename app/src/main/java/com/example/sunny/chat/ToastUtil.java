package com.example.sunny.chat;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ToastUtil {

    public static void showToast(Context context, String message){
    if(context == null) return;
    if(TextUtils.isEmpty(message)) return;
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
}


}