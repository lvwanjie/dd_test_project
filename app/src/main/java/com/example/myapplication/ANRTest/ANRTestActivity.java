package com.example.myapplication.ANRTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
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

    }


    public void btSleep(View view){
        try {
//            Thread.sleep(30000);
            ProxyTest.getMySingleProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
