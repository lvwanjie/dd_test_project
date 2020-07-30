package com.example.myapplication.pubulayout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.RequiresApi;

public class SoftKeyListener implements ViewTreeObserver.OnGlobalLayoutListener{

    private static final String TAG = "SoftKeyListener";
    private Activity mActivity;
    private View rootView;
    private int lastVisHeight;
    Rect rect = new Rect();
    private OnSoftKeyChangeListener listener;


    public SoftKeyListener(Activity activity){
        this.mActivity = activity;
        rootView =  mActivity.getWindow().getDecorView();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this);

    }

    public void setChangeListener(OnSoftKeyChangeListener onSoftKeyChangeListener){
        this.listener = onSoftKeyChangeListener;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void unRegisterListener(){
        if(rootView != null){
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Override
    public void onGlobalLayout() {
        rootView.getWindowVisibleDisplayFrame(rect);
        int visHeight = rect.height();
        //首次
        if(lastVisHeight == 0){
            lastVisHeight = visHeight;
            return;
        }

        if(lastVisHeight == visHeight){
            return;
        }

        if(lastVisHeight - visHeight >200){
            Log.i(TAG, "onGlobalLayout: show");
            if(listener != null){
                listener.onSoftKeyChange(true);
            }
            return;
        }

        if(visHeight - lastVisHeight >200){
            Log.i(TAG, "onGlobalLayout: hide");
            if(listener != null){
                listener.onSoftKeyChange(false);
            }
            return;
        }

    }

    public interface OnSoftKeyChangeListener{

        void onSoftKeyChange(boolean isShow);
    }


}
