package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText editTextName,editTextPass;
    TextView forgetpassTextView,signupText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName=findViewById(R.id.editTextName);
        editTextPass=findViewById(R.id.editTextPass);
        forgetpassTextView=findViewById(R.id.forgetpasstextView);
        signupText=findViewById(R.id.signuptext);
        loginButton=findViewById(R.id.loginbutton);


        forgetpassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
