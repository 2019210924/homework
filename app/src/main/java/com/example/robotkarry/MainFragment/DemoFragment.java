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

import com.example.robotkarry.Note.NotepadActivity;
import com.example.robotkarry.R;

import java.util.Date;

public class DemoFragment extends Fragment implements View.OnClickListener {

    private Button karry,roy,button_3,button_4;

    public DemoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        karry=view.findViewById(R.id.karry);

        karry.setOnClickListener(this);

        roy=view.findViewById(R.id.roy);

        roy.setOnClickListener(this);

        button_3=view.findViewById(R.id.jackson);

        button_3.setOnClickListener(this);

        button_4=view.findViewById(R.id.tf);

        button_4.setOnClickListener(this);



        return view;

    }


    @Override
    public void onClick(View view) {
        Date date = new Date(System.currentTimeMillis());


        switch (view.getId()) {
            case R.id.karry:
                Toast.makeText(getContext(),"1999.09.21",Toast.LENGTH_LONG).show();
                break;

            case R.id.roy:
                Toast.makeText(getContext(),"2000.11.08",Toast.LENGTH_LONG).show();
                break;
            case R.id.jackson:
                Toast.makeText(getContext(),"2000.11.28",Toast.LENGTH_LONG).show();
                break;
            case R.id.tf:
                Toast.makeText(getContext(),"2013.08.06",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
