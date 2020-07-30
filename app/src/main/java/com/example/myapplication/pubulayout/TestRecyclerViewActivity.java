package com.example.myapplication.pubulayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class TestRecyclerViewActivity extends Activity {

    private RecyclerView recyclerView;
    private Button btDelete;
    private LinearLayout ly;
    private TestRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TestRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        btDelete = findViewById(R.id.bt_delete);
        ly = findViewById(R.id.ly);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ly.setVisibility(View.GONE);
                adapter.remove(0);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.setAdapter(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private int i = 9;
    public void reset(View view){
        List list = TestRecyclerAdapter.getFakeData(i--);
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }
}
