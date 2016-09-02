package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;

public class StuMainActivity extends AppCompatActivity {
    private ImageButton MR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Animation loadAnimation;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stumain);
       /* MR = (ImageButton) findViewById(R.id.moduleRecommendations);
        loadAnimation = AnimationUtils.loadAnimation(this,R.anim.anim);
        MR.startAnimation(loadAnimation);*/
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

        if(view.getId() == R.id.SelectedModule){
            Intent i = new Intent(StuMainActivity.this, SelectedActivity.class);
            startActivity(i);
        }

    }
}
