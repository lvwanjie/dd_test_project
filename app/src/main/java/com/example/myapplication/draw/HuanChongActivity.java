package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class HuanChongActivity extends Activity {

    private HuanChongDrawView hcView;
    private TextView bt1;
    private TextView bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huan_chong);
        hcView = findViewById(R.id.hc_view);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hcView.setF(1);
                hcView.invalidate();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hcView.setF(10000);
                hcView.invalidate();
            }
        });

    }
}
