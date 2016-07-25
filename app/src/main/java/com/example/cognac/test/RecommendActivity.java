package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String>arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        //Get preference from last activity
        Intent intent=getIntent();

        String [] Level = intent.getStringArrayExtra("level");
        String [] AssessmentType = intent.getStringArrayExtra("AssessmentType");
        String [] Credits = intent.getStringArrayExtra("Credits");
        String [] Semester = intent.getStringArrayExtra("Semester");

        String msg = "";
        for (int i = 0;i < AssessmentType.length;i++){

            String as = String.valueOf(AssessmentType[i]);
            msg = msg + "\'"+as+"\'"+",";

        }

        String a = msg.substring(0,msg.length()-1);

        Log.i("info",a);

        listView = (ListView)findViewById(R.id.moduleScroll);
        //ArrayAdapter(上下文,当前listview加载的每一个列表项所对应的布局文件,数据源)
        //适配器加载数据源
        String[]arrayData = {"周杰伦","蔡依林","王力宏","林俊杰"};
        dataList = new ArrayList<Map<String,Object>>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayData);
        /*SimpleAdapter 参数:
        1. context 上下文
        2. data 数据源(List<? extends Map<String, ?>>data) 一个map所组成的List的集合
        每一个Map都回去对应ListView列表中的一行,每一个Map(键值对)中的key,必须包含所有在from中所指定的键
        3. resource:列表项的布局文件ID
        4. From: Map中的键名
        5. to 绑定数据视图中的ID
        */
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","txt"},new int[]{R.id.pic,R.id.txt});
        //使用视图(listview)加载适配器
        //listView.setAdapter(arrayAdapter);
        listView.setAdapter(simpleAdapter);
    }
    private List<Map<String,Object>> getData(){
        for (int i=1;i<20;i++){

            Map<String,Object> map = new HashMap<String, Object>();
            map.put("pic",R.drawable.ic_local_movies_black_48dp);
            map.put("txt","张学友"+i);
            dataList.add(map);

        }

        return dataList;
    }

    private void onClickRecommed(){





    }




}
