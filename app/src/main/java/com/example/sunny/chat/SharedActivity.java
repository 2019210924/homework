package com.example.sunny.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunny.R;

public class SharedActivity extends AppCompatActivity {


    public static final String SP_NAME = "sp_name";
    public static final String KEY_INTER_DATA_NAME = "input_data_name";
    public SharedPreferences mSharedPreferences;


    private EditText et_name,et_text;
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        et_name = findViewById(R.id.et_name);
        et_text = findViewById(R.id.et_text);

        mSharedPreferences = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    private void save(String key,String data){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, data);
        editor.commit();
    }

    public String get(String key){
        return mSharedPreferences.getString(key, null);
    }

    public void saveClick(View view) {
        String inputData = et_name.getText().toString().trim();
        if(TextUtils.isEmpty(inputData)){
            ToastUtil.showToast(this, "请填写内容");
            return;
        }
        save(KEY_INTER_DATA_NAME, inputData);
        ToastUtil.showToast(this, "已保存");
    }






}
