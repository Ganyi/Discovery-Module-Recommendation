package com.example.cognac.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class SelectedActivity extends AppCompatActivity {
    LoginActivity loginActivity = new LoginActivity();
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        TextView textView = (TextView) findViewById(R.id.SelectedModule);
        //textView.setText("Username:");

        ListView listView = (ListView) findViewById(R.id.SelectedlistView);

        String SelectedModuleStr = helper.searchSelectedModule(loginActivity.Username);








    }
}
