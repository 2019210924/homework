package com.example.robotkarry;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.robotkarry.MainFragment.DemoFragment;
import com.example.robotkarry.MainFragment.KarryFragment;
import com.example.robotkarry.MainFragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;
    private TextView textView_top_bar;
    private FrameLayout ly_content;
    private MyFragment f1;
    private DemoFragment fDemo;
    private KarryFragment f2;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.ly_content);
        //找到你要设透明背景layout的id
        v.getBackground().setAlpha(220);//0~255透明度值

        fragmentManager=getSupportFragmentManager();
        bindView();
        textView_1.performClick();
    }


    //UI组件初始化与事件绑定
    private void bindView() {
        textView_1= findViewById(R.id.text_1);
        textView_2=findViewById(R.id.text_2);
        textView_3=findViewById(R.id.text_3);
        textView_top_bar=findViewById(R.id.text_top_bar);
        ly_content=findViewById(R.id.ly_content);

        textView_1.setOnClickListener(this);
        textView_2.setOnClickListener(this);
        textView_3.setOnClickListener(this);
        textView_top_bar.setOnClickListener(this);
    }
    //重置所有文本的选中状态
    private void setSelected(){
        textView_1.setSelected(false);
        textView_2.setSelected(false);
        textView_3.setSelected(false);
        textView_top_bar.setSelected(false);
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(f1!=null)fragmentTransaction.hide(f1);
        if(f2!=null)fragmentTransaction.hide(f2);
        if(fDemo!=null)fragmentTransaction.hide(fDemo);
    }


    @Override
    //设置每个fragment
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.text_1:

                textView_1.setSelected(true);
                textView_top_bar.setText("About Karry ☀");

                if(f1==null){

                    f1=new MyFragment("王俊凯，1999年9月21日生于中国重庆，中国内地男歌手、演员、TFBOYS队长。 \n" +
                            "\n" +
                            "2010年底，被TF家族挖掘成为练习生。2012年2月，翻唱《囚鸟》被搜狐、优酷等网站首页推荐走进大众视野、9月，翻唱《我的歌声里》积累了人气。2013年8月6日，TF家族官方发布TFBOYS形象宣传片《十年》，由王俊凯、王源、易烊千玺三人组成的中国内地组合TFBOYS正式出道，陆续发行单曲《魔法城堡》、《青春修炼手册》、《幸运符号》、《信仰之名》、《宠爱》、《恋西游》、《剩下的盛夏》等单曲。2015年，王俊凯参拍张艺谋导演的电影《长城》、参演电视剧《小别离》、出演《诛仙青云志》。2016年12月21日，在公开的“2016年中国90后十大富豪榜”中排名第6，身价已达人民币2.48亿元。2017年1月登央视鸡年春晚。2018年2月，王俊凯成为Dolce&Gabbana亚太区品牌大使。2018年4月18日，任命为“联合国环境署亲善大使”。2018年7月6日，参演的电影《爵迹2》全国公映。2019年2月4日，王俊凯登央视猪年春晚。4月10日，APEC未来之声中国区组委会宣布王俊凯成为“2019年APEC未来之声青年大使”。9月7日，王俊凯荣获“第17届中国电影表演艺术学会奖”新人奖。");
                    fragmentTransaction.add(R.id.ly_content,f1);
                }else {
                    fragmentTransaction.show(f1);
                }


                break;
            case R.id.text_2:
                setSelected();
                textView_2.setSelected(true);
                textView_top_bar.setText("Karry ♡");
                if(f2==null){
                    f2=new KarryFragment();
                    fragmentTransaction.add(R.id.ly_content,f2);
                }else {
                    fragmentTransaction.show(f2);
                }
                break;
            case R.id.text_3:
                setSelected();
                textView_3.setSelected(true);
                textView_top_bar.setText("重要的时刻 ☁");
                if(fDemo==null){
                    fDemo=new DemoFragment();
                    fragmentTransaction.add(R.id.ly_content,fDemo);
                }else {
                    fragmentTransaction.show(fDemo);
                }
                break;
        }

        fragmentTransaction.commit();

    }
}
