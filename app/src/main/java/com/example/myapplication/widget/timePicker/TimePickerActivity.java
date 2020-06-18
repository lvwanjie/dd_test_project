package com.example.myapplication.widget.timePicker;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;

public class TimePickerActivity extends FragmentActivity {


    DatePickerDialogFragment datePickerDialogFragment;
    private String TAG ="TimePickerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
//        dialog = new DatePickerDialog(this);
        datePickerDialogFragment = new DatePickerDialogFragment();
        datePickerDialogFragment.setOnSubmitClickListener(new DatePickerDialogFragment.OnSubmitClickListener() {

            @Override
            public void onSubmitClick(int y, int m, int d) {
                Log.i(TAG, "onSubmitClick: "+y+m+d);
            }
        });

    }

    public void show(View view){
        try {
            if(!datePickerDialogFragment.isAdded()){
                datePickerDialogFragment.showNow(getSupportFragmentManager(),"");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        if(getSupportFragmentManager().executePendingTransactions()&&!datePickerDialogFragment.isAdded()){
//            boolean isadd = datePickerDialogFragment.isAdded();
//        }
    }




}
