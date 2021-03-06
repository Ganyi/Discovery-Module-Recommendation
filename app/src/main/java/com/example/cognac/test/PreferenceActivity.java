package com.example.cognac.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class PreferenceActivity extends AppCompatActivity {
    private Button bt;
    private CheckBox level1, level2, level3, courseworkonly, examonly, hybrid, c10;
    private CheckBox c15, c30, s1, s2;
    private ArrayList<CheckBox> preference;
    private ArrayList<CheckBox> Level;
    private ArrayList<CheckBox> AssessmentType;
    private ArrayList<CheckBox> Credits;
    private ArrayList<CheckBox> Semester;

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

    }

    public void prefSubmit(View view) {
        if (view.getId() == R.id.PreSbBt) {


            preference = new ArrayList<>();
            Level = new ArrayList<>();
            AssessmentType = new ArrayList<>();
            Credits = new ArrayList<>();
            Semester = new ArrayList<>();

            if (level1.isChecked()) {
                Level.add(level1);
            }
            if (level2.isChecked()) {
                Level.add(level2);
            }
            if (level3.isChecked()) {
                Level.add(level3);
            }
            if (courseworkonly.isChecked()) {
                AssessmentType.add(courseworkonly);
            }
            if (examonly.isChecked()) {
                AssessmentType.add(examonly);
            }
            if (hybrid.isChecked()) {
                AssessmentType.add(hybrid);
            }
            if (c10.isChecked()) {
                Credits.add(c10);
            }
            if (c15.isChecked()) {
                Credits.add(c15);
            }
            if (c30.isChecked()) {
                Credits.add(c30);
            }
            if (s1.isChecked()) {
                Semester.add(s1);
            }
            if (s2.isChecked()) {
                Semester.add(s2);
            }


            if (Level.size()==0 ||AssessmentType.size()==0 ||Credits.size()==0|| Semester.size()==0)
            {
                Toast p = Toast.makeText(PreferenceActivity.this, "For every menu please select at " +
                        "least one item", Toast.LENGTH_SHORT);
                p.show();

            }
            else {

                String[] preferenceStrings = new String[preference.size()];
                for (int i = 0; i < preference.size(); i++) {
                    preferenceStrings[i] = preference.get(i).getText().toString();
                }

                final String[] LevelStrings = new String[Level.size()];
                for (int i = 0; i < Level.size(); i++) {
                    LevelStrings[i] = Level.get(i).getText().toString();
                }

                String Lvor = "";
                for (int i = 0;i<LevelStrings.length;i++){

                    Lvor = Lvor + LevelStrings[i] + " or ";
                }

                final String[] AssessmentTypeStrings = new String[AssessmentType.size()];
                for (int i = 0; i < AssessmentType.size(); i++) {
                    AssessmentTypeStrings[i] = AssessmentType.get(i).getText().toString();
                }

                for (int i = 0;i<AssessmentTypeStrings.length;i++){
                    Lvor = Lvor + AssessmentTypeStrings[i] + " or ";
                }

                final String[] CreditsStrings = new String[Credits.size()];
                for (int i = 0; i < Credits.size(); i++) {
                    CreditsStrings[i] = Credits.get(i).getText().toString();
                }

                for (int i = 0;i<CreditsStrings.length;i++){
                    Lvor = Lvor + CreditsStrings[i] + " or ";
                }

                final String[] SemesterStrings = new String[Semester.size()];
                for (int i = 0; i < Semester.size(); i++) {
                    SemesterStrings[i] = Semester.get(i).getText().toString();
                }

                for (int i = 0;i<SemesterStrings.length;i++){
                    Lvor = Lvor + SemesterStrings[i] + " or ";
                }

                String a = Lvor.substring(0, Lvor.length() - 4);

                new AlertDialog.Builder(PreferenceActivity.this).setTitle("Attention")

                        .setMessage("You selected " + a + ". Do you want to submit?")

                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog, int which) {

                                // TODO Auto-generated method stub
                                Intent intent = new Intent();
                                intent.setClass(PreferenceActivity.this, RecommendActivity.class);
                                intent.putExtra("level", LevelStrings);
                                intent.putExtra("AssessmentType", AssessmentTypeStrings);
                                intent.putExtra("Credits", CreditsStrings);
                                intent.putExtra("Semester", SemesterStrings);

                                startActivity(intent);

                                finish();

                            }

                        }).setNegativeButton("No",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                }).show();

            }
        }
    }
}