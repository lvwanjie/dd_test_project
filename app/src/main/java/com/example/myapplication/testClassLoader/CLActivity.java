package com.example.myapplication.testClassLoader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.myapplication.R;

public class CLActivity extends Activity {

    private String TAG ="CLActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl);
        Handler handler;
        ClassLoader loader = getClassLoader();
        while (loader != null){
            Log.i(TAG, "loaderName: "+loader.toString() );
            loader = loader.getParent();
        }
    }
}
