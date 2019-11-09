package com.ashandilya.googlecolab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class suggestion extends AppCompatActivity {

    EditText editTextAdd, editTextSubject, editTextMessage;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        editTextAdd = findViewById(R.id.emailAdd);
        editTextSubject = findViewById(R.id.emailSub);
        editTextMessage = findViewById(R.id.emailMessage);

        buttonSubmit = findViewById(R.id.SubmitBtn);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
