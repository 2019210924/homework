package com.example.sunny.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sunny.R;


public class RecordActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView note_back;
    TextView note_time;
    EditText content;
    ImageView delete,note_save;
    SQLiteHelper mSQLiteHelper;
    TextView noteName;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        note_back = findViewById(R.id.note_back);
        note_time = findViewById(R.id.tv_time);
        content = findViewById(R.id.note_content);
        delete = findViewById(R.id.delete);
        note_save = findViewById(R.id.note_save);
        noteName = findViewById(R.id.note_name);
        note_back.setOnClickListener(this);
        delete.setOnClickListener(this);
        note_save.setOnClickListener(this);
        initData();



    }
    protected void initData(){
        mSQLiteHelper = new SQLiteHelper(this);
        noteName.setText("添加记录");
        Intent intent = getIntent();
        if (intent!=null){
            id=intent.getStringExtra("id");
            if (id!=null){
                noteName.setText("修改记录");
                content.setText(intent.getStringExtra("content"));
                note_time.setText(intent.getStringExtra("time"));
                note_time.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onClick (View v){
        switch (v.getId()) {
            case R.id.note_back:
                finish();
                break;
            case R.id.delete:
                content.setText("");
                break;
            case R.id.note_save:
                String noteContent=content.getText().toString().trim();
                if (id!=null){
                    if (noteContent.length()>0){
                        if(mSQLiteHelper.updateData(id,noteContent,DBUtils.getTime())){
                            showToast("修改成功");
                            setResult(2);
                            finish();
                        }else{
                            showToast("修改失败");
                        }
                    }else{
                        showToast("修改内容不能为空！");
                    }
                }else{
                    if (noteContent.length()>0){
                        if(mSQLiteHelper.insertDate(noteContent,DBUtils.getTime())){
                            showToast("保存成功");
                            setResult(2);
                            finish();
                        }else{
                            showToast("保存失败");
                        }
                    }else{
                        showToast("修改内容不能为空！");
                    }
                }
                break;
        }
    }
    public void showToast(String message){
        Toast.makeText(RecordActivity.this,message,Toast.LENGTH_SHORT).show();
    }
}
