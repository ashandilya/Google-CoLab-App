package com.ashandilya.googlecolab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

public class MainActivity extends AppCompatActivity {

    CircularRevealCardView cardViewSuggest, cardViewRate, cardViewShare, cardViewKudos;
    Dialog dialog;
    ImageView imageViewCloseBtn,imageViewLove;
    TextView textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewSuggest = findViewById(R.id.suggestion);
        cardViewRate = findViewById(R.id.rate);
        cardViewShare = findViewById(R.id.share);
        cardViewKudos = findViewById(R.id.kudos);

        dialog = new Dialog(this);

        cardViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/Plain text");
                String shareBody = "https://play.google.com/store/apps/details?id=com.ashandilya.googlecolab";
                String shareSubject = "Try Google Colab in your phone!";

                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                startActivity(Intent.createChooser(shareIntent,"Share Using"));
            }
        });

        cardViewKudos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kudos();
            }
        });

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

        try{
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "com.ashandilya.googlecolab")));
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.ashandilya.googlecolab" + getPackageName())));
        }

    }

    public void kudos() {
        dialog.setContentView(R.layout.kudos_layout);
        imageViewCloseBtn = findViewById(R.id.close);
        textView1 = findViewById(R.id.codeEditor);
        textView2 = findViewById(R.id.teamSource);
        textView4 = findViewById(R.id.iconKudos);
        textView3 = findViewById(R.id.iconSource);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void close(View view) {
        dialog.dismiss();
    }
}
