package com.example.myapplication.windows;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.myapplication.R;

public class TestWindowActivity extends Activity {

    private WindowManager windowManager;
    private String TAG = "TestWindowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_window);
        windowManager = getWindowManager();
        View view = View.inflate(this,R.layout.window_view_layout,null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.flags = WindowManager.LayoutParams.Flagtouc
//        windowManager.addView(view,);
        testWindowManagerAdd();
        getEntity();
    }
    
    public void getEntity(){
        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            Entity entity = (Entity) bundle.getSerializable("entity");
            Log.i(TAG, "getEntity: ");
        }
    }

    public void testWindowManagerAdd(){
        //windowManager 和 windowManager1 是同一个对象
        WindowManager windowManager = getWindowManager();
        WindowManager windowManager1 = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Log.i(TAG, "testWindowManagerAdd: ");


        DialogFragment dialogFragment;

    }
}
