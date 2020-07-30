package com.example.myapplication.fitTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.lang.reflect.Field;

public class reflexTest extends AppCompatActivity implements View.OnClickListener{


    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex_test);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }



    public void reflexEntity(){
        Class clz = Entity.class;
        Field dField[] = clz.getDeclaredFields();
        String entityClz =  "";
        try {
             entityClz = (String) dField[2].get(clz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        reflexEntity();
    }
}
