package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PreferenceActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;
    private CheckBox checkBox8,checkBox9,checkBox10,checkBox11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        //Back Button
        bt = (Button) findViewById(R.id.PreBackBt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferenceActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        //Submit Button
        bt2 = (Button) findViewById(R.id.PreSbBt);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferenceActivity.this,StuMain.class);
                startActivity(intent);
            }
        });


        checkBox1 = (CheckBox)findViewById(R.id.CheckBox1);
        checkBox2 = (CheckBox)findViewById(R.id.CheckBox2);
        checkBox3 = (CheckBox)findViewById(R.id.CheckBox3);
        checkBox4 = (CheckBox)findViewById(R.id.CheckBox4);
        checkBox5 = (CheckBox)findViewById(R.id.CheckBox5);
        checkBox6 = (CheckBox)findViewById(R.id.CheckBox6);
        checkBox7 = (CheckBox)findViewById(R.id.CheckBox7);
        checkBox8 = (CheckBox)findViewById(R.id.CheckBox8);
        checkBox9 = (CheckBox)findViewById(R.id.CheckBox9);
        checkBox10 = (CheckBox)findViewById(R.id.CheckBox10);
        checkBox11 = (CheckBox)findViewById(R.id.CheckBox11);

        if (checkBox1.isChecked()) {
            String Level1 = "Level1";
        }
        if (checkBox2.isChecked()) {
            String Level2 = "Level2";
        }
        if (checkBox3.isChecked()) {
            String Level3 = "Level3";
        }
        if (checkBox4.isChecked()) {
            String Coursework_only = "Coursework_only";
        }
        if (checkBox5.isChecked()) {
            String Exam_only = "Exam_only";
        }
        if (checkBox6.isChecked()) {
            String Hybrid = "Hybrid";
        }
        if (checkBox7.isChecked()) {
            String Credit10 = "Credit10";
        }
        if (checkBox8.isChecked()) {
            String Credit15 = "Credit15";
        }
        if (checkBox9.isChecked()) {
            String Credit30 = "Credit30";
        }
        if (checkBox10.isChecked()) {
            String Semester1 = "Semester1";
        }
        if (checkBox11.isChecked()) {
            String Semester2 = "Semester2";
        }

    }
}
