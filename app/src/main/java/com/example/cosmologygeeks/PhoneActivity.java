package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    EditText editTextphone;
    Button getOTPbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

       editTextphone=findViewById(R.id.editTextMobile);
       getOTPbutton=findViewById(R.id.getOTPbutton);

       getOTPbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String mobile = editTextphone.getText().toString().trim();

               if(mobile.isEmpty() || mobile.length() < 10){
                   editTextphone.setError("Enter a valid mobile");
                   editTextphone.requestFocus();
                   return;
               }
               Intent intent=new Intent(PhoneActivity.this, VerifyPhoneNumberActivity.class);
               intent.putExtra("mobile", mobile);
               startActivity(intent);
           }
       });

    }
}
