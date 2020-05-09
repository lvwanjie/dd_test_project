package com.example.myapplication.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class HPTestAnimActivity extends Activity {

    private XDAnimView xdAnimView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hptest_anim);
        xdAnimView = findViewById(R.id.xd_anim_view);
    }

    public void start(View view){
        xdAnimView.startAnim();
    }
}
