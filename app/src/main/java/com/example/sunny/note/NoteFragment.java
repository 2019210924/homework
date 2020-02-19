package com.example.sunny.note;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sunny.R;

import java.util.List;


public class NoteFragment extends Fragment{

    ListView listView;
    List<NotepadBean> list;
    SQLiteHelper mSQLiteHelper;
    NotepadAdapter adapter;
    Button add1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note, container, false);


        listView = view.findViewById(R.id.lv2);//绑定
        add1 = view.findViewById(R.id.add);
        //设置监听事件
        add1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),RecordActivity.class);
                startActivityForResult(intent,1);
            }
        });
        initData();


        return view;
    }

    protected void initData(){
        mSQLiteHelper = new SQLiteHelper(getContext());
        showQueryDate();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NotepadBean notepadBean = list.get(position);
                Intent intent=new Intent(getActivity(),RecordActivity.class);
                intent.putExtra("id",notepadBean.getId());
                intent.putExtra("time",notepadBean.getNotepadTime());
                intent.putExtra("content",notepadBean.getNotepadContent());
                getActivity().startActivityForResult(intent,1);
            }
        });
        //长按删除笔记
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog;
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity()).setMessage("是否删除此记录?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        NotepadBean notepadBean = list.get(position);
                        if(mSQLiteHelper.deleteData(notepadBean.getId())){
                            list.remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(),"删除成功",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }

    //展示
    private void showQueryDate(){
        if (list!=null){
            list.clear();
        }
        list=mSQLiteHelper.query();
        adapter=new NotepadAdapter(getContext(),list);
        listView.setAdapter(adapter);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
            showQueryDate();
        }
    }


}
