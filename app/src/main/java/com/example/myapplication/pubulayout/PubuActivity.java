package com.example.myapplication.pubulayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.R;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class PubuActivity extends Activity {

    private RecyclerView recyclerView;
    private String TAG ="PubuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu);
        ListView listView;
        recyclerView = findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.addItemDecoration(new PubuItemDecoration());
        recyclerView.setAdapter(new PubuAdapter(this,recyclerView.getLayoutManager()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int info[] = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
                int firstInfo[] = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);

                View view = staggeredGridLayoutManager.findViewByPosition(0);
                Log.i(TAG, "onScrollStateChanged: info="+ Arrays.toString(info));
                Log.i(TAG, "onScrollStateChanged: firstInfo="+ Arrays.toString(firstInfo));

            }
        });
    }
}
