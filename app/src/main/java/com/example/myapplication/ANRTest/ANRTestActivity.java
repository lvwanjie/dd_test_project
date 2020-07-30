package com.example.myapplication.ANRTest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.binder.aidl_create.Proxy;
import com.example.myapplication.designpattern.proxy.ProxyTest;
import com.example.myapplication.testGson.TestDouble;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ANRTestActivity extends Activity {

    private Timer timer;
    public static String json = "{\n" +
            "  \"isSupport\": \"11ssf3.325327\",\n" +
            "  \"data\": {\n" +
            "    \"pageSize\": 10,\n" +
            "    \"content\": [\n" +
            "      {\n" +
            "        \"cabinetCode\": \"FC02012255\",\n" +
            "        \"cabinetName\": \"体育西横街小区华润万家旁入口右侧丰巢智能柜\",\n" +
            "        \"cabinetAddress\": \"广东省广州市天河区天河南街道体育西横街115号\",\n" +
            "        \"cabinetType\": \"FC\",\n" +
            "        \"latitude\": \"23.128937\",\n" +
            "        \"longitude\": \"113.325327\",\n" +
            "        \"distance\": 1\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"errorCode\": 0,\n" +
            "  \"errorMsg\": \"成功\"\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anrtest);


//        try {
//            Thread.sleep(30*1000);
//            Toast.makeText(this,"wake",Toast.LENGTH_SHORT).show();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ArrayList arrayList = new ArrayList();
        arrayList.add(null);


    }


    public  JSONObject my(String str){
        JSONObject jsonObject = null;
        try {
            jsonObject =  new JSONObject(json);

            if(jsonObject != null){
                int isSupport = jsonObject.optInt("isSupport",10);
                JSONArray contentArray = jsonObject.optJSONArray("content");
                if(contentArray != null){
                    ArrayList addressList = new ArrayList<>();
                    for (int i = 0; i < contentArray.length(); i++) {
                        try {
                            JSONObject object = contentArray.getJSONObject(i);
                            TestDouble.SelfPickAddressInfo info = new TestDouble.SelfPickAddressInfo();
                            info.parse(object);
                            addressList.add(info);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(addressList.toString()+"");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public class inner{
        public String s;
    }



    public void btSleep(View view){
        final Handler handler = new Handler();
        Intent intent = new Intent(this,AnrService.class);
        startService(intent);
//        try {
//            Thread.sleep(30000);
//            Toast.makeText(this,"bt_wake",Toast.LENGTH_SHORT).show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
