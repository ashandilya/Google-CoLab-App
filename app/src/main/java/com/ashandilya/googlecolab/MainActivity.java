package com.ashandilya.googlecolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

public class MainActivity extends AppCompatActivity {

    CircularRevealCardView cardViewSuggest, cardViewRate, cardViewShare, cardViewKudos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewSuggest = findViewById(R.id.suggestion);
        cardViewRate = findViewById(R.id.rate);
        cardViewShare = findViewById(R.id.share);
        cardViewKudos = findViewById(R.id.kudos);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,colab_webView.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public void suggestion(View view) {
    }

    public void rate(View view) {
    }

    public void share(View view) {
    }

    public void kudos(View view) {
    }
}
