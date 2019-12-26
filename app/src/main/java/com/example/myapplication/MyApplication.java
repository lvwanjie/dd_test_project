package com.example.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyApplication extends Application {

    public static String TAG = "ActivityLifecycleCallbacks";

    private static MyApplication myApplication;
    public static MyApplication getInstance(){
        return  myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log.i(TAG, "onActivityCreated: "+activity.getClass().getName());
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log.i(TAG, "onActivityStarted: "+Activity.class.getName());
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.i(TAG, "onActivityResumed: "+Activity.class.getName());
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Log.i(TAG, "onActivityPaused: "+Activity.class.getName());

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                Log.i(TAG, "onActivityStopped: "+Activity.class.getName());

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
                Log.i(TAG, "onActivitySaveInstanceState: "+Activity.class.getName());

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.i(TAG, "onActivityDestroyed: "+Activity.class.getName());
            }


        });
    }
}
