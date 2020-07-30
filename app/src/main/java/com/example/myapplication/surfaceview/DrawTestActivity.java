package com.example.myapplication.surfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class DrawTestActivity extends Activity {

    private Button button;
    private DrawView drawView;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap hashMap;
        Hashtable hashtable;
        HashSet hashSet;
        setContentView(R.layout.activity_draw_test);
        drawView = findViewById(R.id.draw_view);
        button = findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 0){
                    button.invalidate();
                    i = 1;
                }else {
                    i = 0;
                    drawView.invalidate();
                }
            }
        });
    }
}
