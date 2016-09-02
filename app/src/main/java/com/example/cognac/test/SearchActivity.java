package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private WebView webView;
    GestureDetector myGesturedetector;

    class myGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()-e2.getX() > 60){
                Intent intent = new Intent(SearchActivity.this, StuMainActivity.class);
                startActivity(intent);
            }else if (e2.getX()-e1.getX()>60){
                Toast p = Toast.makeText(SearchActivity.this, "Slide from left to right", Toast.LENGTH_SHORT);
                p.show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        myGesturedetector = new GestureDetector(new myGestureListener());



    }

    private void init(){
        webView = (WebView) findViewById(R.id.webView);


        Animation loadAnimation;
        loadAnimation = AnimationUtils.loadAnimation(this,R.anim.anim);
        webView.startAnimation(loadAnimation);


        webView.loadUrl("https://leedsforlife.leeds.ac.uk/Broadening");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                myGesturedetector.onTouchEvent(motionEvent);
                return true;
            }
        });



    }
}
