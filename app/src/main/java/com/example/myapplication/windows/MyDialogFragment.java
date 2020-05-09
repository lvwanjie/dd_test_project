package com.example.myapplication.windows;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

public class MyDialogFragment extends BaseFullScreenDialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.popup_window_layout,container,false);
////        Window window = getDialog().getWindow();
////        window.setGravity(Gravity.BOTTOM);
////        window.setWindowAnimations(R.style.pup_animation);
////        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
////
////        WindowManager.LayoutParams params = window.getAttributes();
////        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
////        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
//
//        return view;
//    }

    @Override
    protected int getLayoutID() {
        Dialog dialog;
        return R.layout.popup_window_layout;
    }

    @Override
    protected void init() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        Dialog dialog = new Dialog(getContext());
//        Window window = dialog.getWindow();
//        window.setGravity(Gravity.BOTTOM);
//        window.setWindowAnimations(R.style.pup_animation);
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        return dialog;
//    }
}
