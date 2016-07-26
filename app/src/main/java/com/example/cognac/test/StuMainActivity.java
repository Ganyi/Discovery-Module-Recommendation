package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stumain);

    }

    public void onReClcik(View view){
        if(view.getId() == R.id.moduleRecommendations){
            Intent i = new Intent(StuMainActivity.this, PreferenceActivity.class);
            startActivity(i);
        }

        if(view.getId() == R.id.searchFormodule){
            Intent i = new Intent(StuMainActivity.this, SearchActivity.class);
            startActivity(i);
        }





    }
}
