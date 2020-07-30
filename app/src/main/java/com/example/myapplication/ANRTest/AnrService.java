package com.example.myapplication.ANRTest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class AnrService extends Service {
    public AnrService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("");
        Handler handler = new Handler();
        handler.sendEmptyMessage(0);
        LinkedList linkedList= new LinkedList();
        linkedList.add(null);
        try {
            Thread.sleep(25*1000);
            Toast.makeText(this,"service_weak",Toast.LENGTH_SHORT).show();

        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
