package com.example.myapplication.fitTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast = new Toast(this);
        View view = LayoutInflater.from(this).inflate(R.layout.cus_toast_view,null);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        Toast toast1 = Toast.makeText(this,"ssss",Toast.LENGTH_SHORT);
        View view1 = toast.getView();
        System.out.println("");
    }
}
