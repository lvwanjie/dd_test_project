package com.example.myapplication.fitTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.File;

public class TestPermissionActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_permission);
        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv);
        bt.setOnClickListener(this);
        ImageDecoder imageDecoder ;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ImageDecoder.createSource(new File(""));
        }

        BitmapRegionDecoder bitmapRegionDecoder ;
    }

    @Override
    public void onClick(View v) {
//        checkOverlayPermission();
        getMac();
    }

    public boolean checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                return true;
            } else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" +getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return false;
            }
        } else {
            return true;
        }
    }



    public void getMac(){
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String str = info.getMacAddress();
        tv.setText("这是mac"+str);
    }
}
