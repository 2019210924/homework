package com.example.robotkarry;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.os.Bundle;

public class KaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ka);
        //设置网站
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://weibo.com/tfwangjunkai?c=spr_qdhz_bd_360ss_weibo_mr&is_hot=1");
    }
}
