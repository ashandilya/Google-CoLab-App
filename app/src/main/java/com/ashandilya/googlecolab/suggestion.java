package com.ashandilya.googlecolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class suggestion extends AppCompatActivity {

    private AdView mAdView;
    EditText editTextAdd, editTextSubject, editTextMessage;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        MobileAds.initialize(this, "ca-app-pub-3202873213580151~3628854679");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        editTextAdd = findViewById(R.id.emailAdd);
        editTextSubject = findViewById(R.id.emailSub);
        editTextMessage = findViewById(R.id.emailMessage);

        buttonSubmit = findViewById(R.id.SubmitBtn);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAdd = editTextAdd.getText().toString().trim();
                String emailSub = editTextSubject.getText().toString().trim();
                String emailMessage = editTextMessage.getText().toString().trim();

                sendEmail(emailAdd, emailSub, emailMessage);
            }
        });
    }

    private void sendEmail(String emailAdd, String emailSub, String emailMessage) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("Mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAdd});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSub);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailMessage);

        try{
            startActivity(Intent.createChooser(emailIntent, "Choose your favourite Email client:"));
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
