package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class PreferenceActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    private CheckBox level1, level2, level3, courseworkonly, examonly, hybrid, c10;
    private CheckBox c15, c30, s1, s2;
    private ArrayList<CheckBox> preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        //Back Button
        bt = (Button) findViewById(R.id.PreBackBt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferenceActivity.this, StuMainActivity.class);
                startActivity(intent);
            }
        });
        //Submit Button
        bt2 = (Button) findViewById(R.id.PreSbBt);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferenceActivity.this, StuMainActivity.class);
                startActivity(intent);
            }
        });


        level1 = (CheckBox) findViewById(R.id.Level1);
        level2 = (CheckBox) findViewById(R.id.Level2);
        level3 = (CheckBox) findViewById(R.id.Level3);
        courseworkonly = (CheckBox) findViewById(R.id.Courseworkonly);
        examonly = (CheckBox) findViewById(R.id.Examonly);
        hybrid = (CheckBox) findViewById(R.id.Hybrid);
        c10 = (CheckBox) findViewById(R.id.c10);
        c15 = (CheckBox) findViewById(R.id.c15);
        c30 = (CheckBox) findViewById(R.id.c20);
        s1 = (CheckBox) findViewById(R.id.s1);
        s2 = (CheckBox) findViewById(R.id.s2);


        preference = new ArrayList<>();
        if (level1.isChecked()) {
            preference.add(level1);
        }
        if (level2.isChecked()) {
            preference.add(level2);
        }
        if (level3.isChecked()) {
            preference.add(level3);
        }
        if (courseworkonly.isChecked()) {
            preference.add(courseworkonly);
        }
        if (examonly.isChecked()) {
            preference.add(examonly);
        }
        if (hybrid.isChecked()) {
            preference.add(hybrid);
        }
        if (c10.isChecked()) {
            preference.add(c10);
        }
        if (c15.isChecked()) {
            preference.add(c15);
        }
        if (c30.isChecked()) {
            preference.add(c30);
        }
        if (s1.isChecked()) {
            preference.add(s1);
        }
        if (s2.isChecked()) {
            preference.add(s2);
        }

    }

    public void prefSubmit(View view) {
        if (view.getId() == R.id.PreSbBt) {
            ArrayList<String> preferenceStrings = new ArrayList<>();
            for(int i = 0; i < preference.size(); i++){
                preferenceStrings.add(preference.get(i).getText().toString());
            }
            Intent intent=new Intent();
            intent.setClass(PreferenceActivity.this, RecommendActivity.class);
            intent.putExtra("pre", preferenceStrings);
            startActivity(intent);
        }
    }
}