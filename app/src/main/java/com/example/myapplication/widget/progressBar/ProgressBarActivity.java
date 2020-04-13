package com.example.myapplication.widget.progressBar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.example.myapplication.R;

public class ProgressBarActivity extends Activity {

    private Button button1;
    private Button button2;
    private Button button3;
    private ProgressBar progressBar;
    private RatingBar ratingBar;
    private int progress;
    private int secProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.rating_bar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress>100){
                    progress = 0;
                }
                progress+=10;
                progressBar.setProgress(progress);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secProgress+=10;
                progressBar.setSecondaryProgress(secProgress);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setRating(3.5f);
            }
        });
    }


}
