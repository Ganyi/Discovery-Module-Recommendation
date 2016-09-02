package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    String Usertype;
    public static String Username;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rg = (RadioGroup) findViewById(R.id.radioGroup11);
        rg.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radioButton4:
                Usertype = "Lecturer";
                break;
            case R.id.radioButton3:
                Usertype = "Student";
                break;
        }

    }

    public void onButtonClick(View view){

        if(view.getId() == R.id.email_sign_in_button){

            EditText email = (EditText) findViewById(R.id.email);
            String emailstr = email.getText().toString();

            EditText pass = (EditText) findViewById(R.id.password);
            String passwordstr = pass.getText().toString();


            String password = helper.SearchPassword(emailstr);
            String Usertypestr = helper.searchUT(emailstr);

            if (passwordstr.equals(password)){
                if (Usertypestr.equals(Usertype)) {
                    Username = emailstr;
                    Intent i = new Intent(LoginActivity.this, StuMainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast p = Toast.makeText(LoginActivity.this, "Usertype incorrect", Toast.LENGTH_SHORT);
                    p.show();
                }
            }
            else{
                Toast p = Toast.makeText(LoginActivity.this, "Password or Username incorrect", Toast.LENGTH_SHORT);
                p.show();
            }
        }

        if (view.getId() == R.id.Register){

            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        }
    }


}

