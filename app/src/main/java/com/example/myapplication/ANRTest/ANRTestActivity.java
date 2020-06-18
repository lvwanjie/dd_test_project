package com.example.myapplication.ANRTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.binder.aidl_create.Proxy;
import com.example.myapplication.designpattern.proxy.ProxyTest;

public class ANRTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anrtest);

//        startService()
    }



    public void btSleep(View view){
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Handler handler;
    }
}
