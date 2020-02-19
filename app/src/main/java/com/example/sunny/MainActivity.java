package com.example.sunny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sunny.chat.chatFragment;
import com.example.sunny.music.musicFragment;
import com.example.sunny.note.NoteFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv1,tv2,tv3,tv4;
    private musicFragment musicFragment;
    private chatFragment chatFragment;
    private NoteFragment noteFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager=getSupportFragmentManager();
        intID();
        tv1.performClick();

    }

    private void setSelected(){
        tv1.setSelected(false);
        tv2.setSelected(false);
        tv3.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(chatFragment!=null)fragmentTransaction.hide(chatFragment);
        if(musicFragment!=null)fragmentTransaction.hide(musicFragment);
        if(noteFragment!=null)fragmentTransaction.hide(noteFragment);
    }


    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        //设置每个fragment   点击事件
        switch (v.getId()) {
            case R.id.tv1:
                tv1.setSelected(true);
                tv1.setTextColor(Color.BLUE);
                tv2.setTextColor(Color.BLACK);
                tv3.setTextColor(Color.BLACK);
                if (chatFragment == null){
                    chatFragment = new chatFragment();
                    fragmentTransaction.add(R.id.ly_content,chatFragment);
                }else {
                    fragmentTransaction.show(chatFragment);
                }
                    break;

            case R.id.tv2:
                tv2.setSelected(true);
                tv1.setTextColor(Color.BLACK);
                tv3.setTextColor(Color.BLACK);
                tv2.setTextColor(Color.BLUE);
                if (musicFragment == null){
                    musicFragment = new musicFragment();
                    fragmentTransaction.add(R.id.ly_content,musicFragment);
                }else {
                    fragmentTransaction.show(musicFragment);
                }
                break;

            case R.id.tv3:
                tv3.setSelected(true);

                tv3.setTextColor(Color.BLUE);
                tv2.setTextColor(Color.BLACK);
                tv1.setTextColor(Color.BLACK);
                if (noteFragment == null){
                    noteFragment = new NoteFragment();
                    fragmentTransaction.add(R.id.ly_content,noteFragment);
                }else {
                    fragmentTransaction.show(noteFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void intID() {


        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

    }
}
