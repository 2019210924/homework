package com.example.robotkarry.MainFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.robotkarry.KaActivity;
import com.example.robotkarry.Note.NotepadActivity;
import com.example.robotkarry.R;
import com.example.robotkarry.chat.ChatActivity;
import com.example.robotkarry.music.KActivity;
import com.example.robotkarry.music.SplashActivity;

import java.util.Date;

public class KarryFragment extends Fragment implements View.OnClickListener {

    private Button button_1,button_2,button_3,button_4;
    private ImageView button_5;


    public KarryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_karry,container,false);
        button_1=view.findViewById(R.id.button_1);

        button_1.setOnClickListener(this);

        button_2=view.findViewById(R.id.button_2);

        button_2.setOnClickListener(this);

        button_3=view.findViewById(R.id.button_3);

        button_3.setOnClickListener(this);

        button_4=view.findViewById(R.id.button_4);

        button_4.setOnClickListener(this);

        button_5=view.findViewById(R.id.button_5);

        button_5.setOnClickListener(this);




        return view;
    }




    @Override
    public void onClick(View view) {
        Date date=new Date(System.currentTimeMillis());

        //设置每个button的点击事件
        switch (view.getId()){
            case R.id.button_1:
                Intent intent1 = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent1);
                break;

            case R.id.button_2:
                Intent intent2 = new Intent(getActivity(), SplashActivity.class);
                startActivity(intent2);
                break;

            case R.id.button_3:
                Intent intent3 = new Intent(getActivity(), KaActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_4:
                Toast.makeText(getContext(),"1999.09.21",Toast.LENGTH_LONG).show();
                break;

            case R.id.button_5:
                Intent intent5 = new Intent(getActivity(), NotepadActivity.class);
                startActivity(intent5);
        }
    }
}
