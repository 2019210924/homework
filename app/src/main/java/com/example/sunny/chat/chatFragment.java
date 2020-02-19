package com.example.sunny.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sunny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.sunny.chat.SharedActivity.KEY_INTER_DATA_NAME;

public class chatFragment extends Fragment{
    private ListView lv;

    public TextView tv4;
    public TextView name;
    public TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        lv = view.findViewById(R.id.lv);
        tv4 = view.findViewById(R.id.tv4);
        name = view.findViewById(R.id.tv_name);
        text = view.findViewById(R.id.tv_note);



        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map map1 = new HashMap<String, Object>();
        map1.put("name", "聊天");
        map1.put("image", R.drawable.liaotian);
        data.add(map1);
        Map map2 = new HashMap<String, Object>();
        map2.put("name", "关于图灵机器人");
        map2.put("image", R.drawable.robot);
        data.add(map2);
        Map map3 = new HashMap<String, Object>();
        map3.put("name", "图灵官网");
        map3.put("image", R.drawable.web);
        data.add(map3);


        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                data,
                R.layout.chat_lv,
                new String[]{"name", "image"},
                new int[]{R.id.tv4, R.id.iv_icon});
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent1 = new Intent(getActivity(), ChatActivity.class);
                    startActivity(intent1);
                }
                if (position == 1) {
                    Intent intent2 = new Intent(getActivity(), TextActivity.class);
                    startActivity(intent2);
                }
                if (position == 2) {
                    Intent intent3 = new Intent(getActivity(), WebActivity.class);
                    startActivity(intent3);
                }
            }
        });


        return view;
    }


}