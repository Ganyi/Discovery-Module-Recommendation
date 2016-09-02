package com.example.cognac.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    DatabaseHelper helper = new DatabaseHelper(this);
    private RadioGroup rg;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rg = (RadioGroup) findViewById(R.id.radioGroup10);
        rg.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radioButton:
                a = "Lecturer";
                break;
            case R.id.radioButton2:
                a = "Student";
                break;
        }
    }
    public void submitClick(View v) {

        if (v.getId() == R.id.register_submit) {

            EditText email = (EditText) findViewById(R.id.register_username);
            EditText password = (EditText) findViewById(R.id.register_passwd);
            EditText password2 = (EditText) findViewById(R.id.reregister_passwd);


            String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String password2str = password2.getText().toString();
            String Usertypestr = a;

            if (!emailstr.contains("@")) {
                Toast pass = Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT);
                pass.show();

            } else {

                if (!passwordstr.equals(password2str)) {

                    Toast pass = Toast.makeText(RegisterActivity.this, "Password do not match", Toast.LENGTH_SHORT);
                    pass.show();

                } else {
                    String emailInDB = helper.searchEmail(emailstr);

                    if (!emailInDB.equals(emailstr)) {
                        User user = new User();
                        user.setEmail(emailstr);
                        user.setPassword(passwordstr);
                        user.setUsertype(Usertypestr);
                        helper.insertUser(user);

                        Toast pass = Toast.makeText(RegisterActivity.this, "Register successfully", Toast.LENGTH_SHORT);
                        pass.show();

                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(i);
                    } else {
                        Toast pass = Toast.makeText(RegisterActivity.this, "Email exists", Toast.LENGTH_SHORT);
                        pass.show();
                    }
                }
            }
        }
    }
}


