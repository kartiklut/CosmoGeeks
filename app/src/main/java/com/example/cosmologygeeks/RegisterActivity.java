package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {


    EditText editTextName,editTextemail,editTextpass;
    Button signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName=findViewById(R.id.editTextName);
        editTextemail=findViewById(R.id.editTextemail);
        editTextpass=findViewById(R.id.editTextpass);
        signupbutton=findViewById(R.id.signupbutton);


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
