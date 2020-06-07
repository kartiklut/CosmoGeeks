package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VerifyPhoneNumberActivity extends AppCompatActivity {

    EditText editTextPhone;
    Button verifybutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);

        editTextPhone=findViewById(R.id.editTextPhone);
        verifybutton=findViewById(R.id.verifybutton);

        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
