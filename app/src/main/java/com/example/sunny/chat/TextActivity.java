package com.example.sunny.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sunny.R;

public class TextActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        textView = findViewById(R.id.txt);
        textView.setText("图灵机器人 是以语义技术为核心驱动力的人工智能公司 ，致力于\"让机器理解世界\"，产品服务包括机器人开放平台、机器人OS和场景方案。通过图灵机器人，开发者和厂商能够以高效的方式创建专属的聊天机器人、客服机器人、领域对话问答机器人、儿童/服务机器人等。\n" +
                "\n" +
                "截至目前，图灵机器人对中文语义的理解准确率高达90%以上 ，累计开发者及合作伙伴超60万 。" +"\n"+
                "图灵机器人开放平台分为四大功能，分别是Chat Bot，场景对话，NLP知识库和能力商城。\n" +
                "\n" +
                "1、中文聊天对话:基于图灵大脑中文语义与认知计算技术以及多年中文自然语言交互研发经验，图灵机器人具备准确、流畅、自然的中文聊天对话能力\n" +
                "\n" +
                "2、自定义身份属性:图灵机器人平台所提供的ChatBot支持充分的机器人一体化身份属性自定义，开发者通过平台页面对机器人的20多个常见属性进行快捷设置，打造具备个性化身份属性的ChatBot。\n" +
                "\n" +
                "3、情感识别引擎:图灵机器人独创情感识别与表达引擎，能够有效识别用户在聊天过程中所表现出的正-负向及显-隐性情绪，并进行有情感的回应。\n" +
                "\n" +
                "4、多领域智能问答:图灵机器人具备强大的中文问答能力，在满足基础聊天对话的同时，满足用户100多个垂直领域的问答需求\n" +
                "\n" +
                "5、场景对话的功能介绍:通过场景对话模块，开发者可快速搭建满足于不同场景下业务需求的多轮上下文对话，并实现对话式交互同自有产品业务、数据库以及第三方数据源的对接，实现产品服务体验升级。\n" +
                "\n" +
                "6、NLP知识库的功能介绍:\n" +
                "\n" +
                "NLP知识库是基于图灵中文语义认知计算技术的智能知识库模块，具有准确率高，操作简单的特点，通过该模块，平台用户及开发者可批量导入垂直领域的业务问答知识，让机器人快速实现垂直领域的问答能力。\n" +
                "\n" +
                "7、能力商城的功能介绍:\n" +
                "\n" +
                "能力商城是针对平台用户的一个云端服务商城，汇聚了大量免费的且具有良好体验的聊天机器人实用功能，平台用户与开发者可通过能力商城快速获取各种实用性、趣味性功能，满足用户需求。\n" +
                "\n" +
                "图灵机器人提供API、SDK及前端组件 用户可快速的选择适用的方式 ，为产品接入图灵机器人大脑 ，实现产品人工智能交互升级。 图灵机器人平台具备灵活的多场景整体解决方案 ，满足各场景产品的多样化需求 。");
    }
}
