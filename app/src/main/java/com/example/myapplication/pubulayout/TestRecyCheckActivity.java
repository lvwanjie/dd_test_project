package com.example.myapplication.pubulayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class TestRecyCheckActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout lyContent;
    private String TAG ="TestRecyCheckActivity.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recy_check);
        recyclerView = findViewById(R.id.recycler_view);
        lyContent = findViewById(R.id.ly_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestRecyCheckAdapter adapter =  new TestRecyCheckAdapter(this);
        View addressView = LayoutInflater.from(this).inflate(R.layout.dd_update_receiver,recyclerView,false);
        EditText editText = addressView.findViewById(R.id.receiver_location);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i(TAG, "onEditorAction: "+actionId);
                return false;
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(TAG, "onKey: ");
                return false;
            }
        });
        
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.i(TAG, "onFocusChange: ");
            }
        });
        InputMethodManager inputMethodManager;
      
        
        adapter.setHeadView(addressView);
        adapter.setData(TestRecyCheckAdapter.getFackeData());
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                lyContent.requestFocus();
                return false;

            }
        });

//        listenerSoftInput();

    }

    private SoftKeyListener softKeyListener;

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }



    private View rootView;
    private int rootVisHeight;
    private void listenerSoftInput() {
        rootView = this.getWindow().getDecorView();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                rootView.getWindowVisibleDisplayFrame(rect);
                int visHeight = rect.height();
                Log.i(TAG, "onGlobalLayout: visHeight = "+visHeight);
                if(rootVisHeight == 0){
                    rootVisHeight = visHeight;
                    return;
                }

                if(rootVisHeight == visHeight){
                    return;
                }

                if(rootVisHeight - visHeight >200){
                    Log.i(TAG, "onGlobalLayout: show");
                    rootVisHeight = visHeight;
                }

                if(visHeight - rootVisHeight>200){
                    Log.i(TAG, "onGlobalLayout: hide");
                    lyContent.requestFocus();
                    rootVisHeight = visHeight;
                }
            }
        });

    }
}
