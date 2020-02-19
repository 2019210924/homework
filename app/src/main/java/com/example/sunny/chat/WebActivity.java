package com.example.sunny.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.sunny.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //设置网站
        WebView myWebView = findViewById(R.id.web);
        myWebView.loadUrl("https://www.tuling123.com/products/pro_turing_robot.jhtml?nav=prod");
    }
}
