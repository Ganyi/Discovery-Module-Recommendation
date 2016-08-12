package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;
    private ArrayList<String> result;
    private ArrayList<String> test;


    private CheckBox Easy;
    private CheckBox AttractiveLecturer;
    private CheckBox Popular;
    private CheckBox Challenged;
    private CheckBox MultipleLecturer;
    private CheckBox VeryUseful;
    private CheckBox Theoretical;
    private CheckBox NoPreRequisite;
    private CheckBox GoodForCV;
    private CheckBox Practical;
    private CheckBox IncludeTutorial;
    private CheckBox SmallClass;

    private ArrayList<CheckBox> interests;


    final ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);


        final ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        Easy = (CheckBox) findViewById(R.id.Easy);
        checkBoxes.add(Easy);
        AttractiveLecturer = (CheckBox) findViewById(R.id.AttractiveLecturer);
        checkBoxes.add(AttractiveLecturer);
        Popular = (CheckBox) findViewById(R.id.Popular);
        checkBoxes.add(Popular);
        Challenged = (CheckBox) findViewById(R.id.Challenged);
        checkBoxes.add(Challenged);
        MultipleLecturer = (CheckBox) findViewById(R.id.MultipleLecturer);
        checkBoxes.add(MultipleLecturer);
        VeryUseful = (CheckBox) findViewById(R.id.VeryUseful);
        checkBoxes.add(VeryUseful);
        Theoretical = (CheckBox) findViewById(R.id.Theoretical);
        checkBoxes.add(Theoretical);
        NoPreRequisite = (CheckBox) findViewById(R.id.NoPreRequisite);
        checkBoxes.add(NoPreRequisite);
        GoodForCV = (CheckBox) findViewById(R.id.GoodForCV);
        checkBoxes.add(GoodForCV);
        Practical = (CheckBox) findViewById(R.id.Practical);
        checkBoxes.add(Practical);
        IncludeTutorial = (CheckBox) findViewById(R.id.IncludeTutorial);
        checkBoxes.add(IncludeTutorial);
        SmallClass = (CheckBox) findViewById(R.id.SmallClass);
        checkBoxes.add(SmallClass);

        //Function of selectAll
        ImageButton selectAll = (ImageButton) findViewById(R.id.selectAll);
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox box : checkBoxes) {
                    box.setChecked(true);
                }
            }
        });

        //Function of clearAll
        ImageButton clearAll = (ImageButton) findViewById(R.id.clearAll);
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox box : checkBoxes) {
                    box.setChecked(false);
                }
            }
        });
    }

    public String FormatPre(String[] OriPre) {
        String msg = "";
        for (int i = 0; i < OriPre.length; i++) {
            String as = String.valueOf(OriPre[i]);
            msg = msg + "\'" + as + "\'" + ",";
        }
        String a = msg.substring(0, msg.length() - 1);
        return a;
    }


    public String FormatInterests(String[] OriIn) {
        String msg = "";
        for (int i = 0; i < OriIn.length; i++) {
            String as = String.valueOf(OriIn[i]);
            msg = msg + " Tag like '%" + as + "%' and";

        }
        String a = msg.substring(0, msg.length() - 3);
        return a;
    }


    private List<Map<String, Object>> getData() {
        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.mipmap.ic_launcher);
            map.put("txt", result.get(i));
            dataList.add(map);
        }
        return dataList;
    }

    public void onClickRecommed(View view) {
        if (view.getId() == R.id.searchButton) {
            listView = (ListView) findViewById(R.id.moduleScroll);


            interests = new ArrayList<>();

            if (Easy.isChecked()) {
                interests.add(Easy);
            }
            if (AttractiveLecturer.isChecked()) {
                interests.add(AttractiveLecturer);
            }
            if (Popular.isChecked()) {
                interests.add(Popular);
            }

            if (Challenged.isChecked()) {
                interests.add(Challenged);
            }
            if (MultipleLecturer.isChecked()) {
                interests.add(MultipleLecturer);
            }
            if (VeryUseful.isChecked()) {
                interests.add(VeryUseful);
            }

            if (Theoretical.isChecked()) {
                interests.add(Theoretical);
            }
            if (NoPreRequisite.isChecked()) {
                interests.add(NoPreRequisite);
            }
            if (GoodForCV.isChecked()) {
                interests.add(GoodForCV);
            }

            if (Practical.isChecked()) {
                interests.add(Practical);
            }
            if (IncludeTutorial.isChecked()) {
                interests.add(IncludeTutorial);
            }
            if (SmallClass.isChecked()) {
                interests.add(SmallClass);
            }

            if (interests.size() == 0) {

                Toast p = Toast.makeText(RecommendActivity.this, "You need to selcet at" +
                        " least one interest", Toast.LENGTH_SHORT);
                p.show();

            } else {


                String[] InterestsString = new String[interests.size()];
                for (int i = 0; i < interests.size(); i++) {
                    InterestsString[i] = interests.get(i).getText().toString();
                }


                String a = FormatInterests(InterestsString);
                Log.i("a", a);

                //Get preference from last activity
                Intent intent = getIntent();
                String[] Level = intent.getStringArrayExtra("level");
                String[] AssessmentType = intent.getStringArrayExtra("AssessmentType");
                String[] Credit = intent.getStringArrayExtra("Credits");
                String[] Semester = intent.getStringArrayExtra("Semester");

                result = helper.searchModule(FormatPre(Level), FormatPre(AssessmentType),
                        FormatPre(Credit), FormatPre(Semester), FormatInterests(InterestsString));


                //ArrayAdapter(上下文,当前listview加载的每一个列表项所对应的布局文件,数据源)
                //适配器加载数据源
                dataList = new ArrayList<Map<String, Object>>();
        /*SimpleAdapter 参数:
        1. context 上下文
        2. data 数据源(List<? extends Map<String, ?>>data) 一个map所组成的List的集合
        每一个Map都回去对应ListView列表中的一行,每一个Map(键值对)中的key,必须包含所有在from中所指定的键
        3. resource:列表项的布局文件ID
        4. From: Map中的键名
        5. to 绑定数据视图中的ID
        */
                simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic", "txt"}, new int[]{R.id.pic, R.id.txt});
                //使用视图(listview)加载适配器
                //listView.setAdapter(arrayAdapter);
                listView.setAdapter(simpleAdapter);
            }
        }
    }
}
