package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class getstartedActivity extends AppCompatActivity {

    Button googlelogin,phonelogin;
    TextView signuptext,signintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);

        googlelogin=findViewById(R.id.googlelogin);
        phonelogin=findViewById(R.id.phonelogin);
        signintext=findViewById(R.id.signintext);
        signuptext=findViewById(R.id.signuptext);

        googlelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        phonelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
