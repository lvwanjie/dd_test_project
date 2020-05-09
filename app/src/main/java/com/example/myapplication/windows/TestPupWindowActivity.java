package com.example.myapplication.windows;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myapplication.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class TestPupWindowActivity extends FragmentActivity {

    PopupWindow popupWindow;
    private MyDialogFragment myDialogFragment;
    private MyDialogFragment1 myDialogFragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pup_window);
        popupWindow = new PopupWindow();
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#78c5f2"));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.aaa);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setHeight(400);
        popupWindow.setWidth(300);
        View view = View.inflate(this,R.layout.popup_window_layout,null);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2,500));
        popupWindow.setContentView(view);
        myDialogFragment = new MyDialogFragment();
        myDialogFragment1 = new MyDialogFragment1();


    }

    public void show(View view){
//        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY,100,100);
//        popupWindow.showAtLocation(view,Gravity.BOTTOM,0,0);
//        DialogFragment dialogFragment;
//        FragmentTransaction transaction;
//
//        Log.i(TAG, "show: ");

//        myDialogFragment.show(getSupportFragmentManager(),"");
        myDialogFragment1.show(getSupportFragmentManager(),"");

//        showDialog();
    }

    public void showDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.popup_window_layout,null,false);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Drawable drawable = window.getDecorView().getBackground();
//        window.getDecorView().setPadding(0,0,0,0);
        window.setWindowAnimations(R.style.pup_animation);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new BitmapDrawable());
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.show();
    }


    public void addWindow(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Dialog dialog = new Dialog(this);
//        Window window = new PhoneWindow();
    }
}
