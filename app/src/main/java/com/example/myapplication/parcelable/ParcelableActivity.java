package com.example.myapplication.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class ParcelableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

    }

    public void jump(View view){
        goPage();
    }

    public void goPage(){
        Bundle bundle = new Bundle();
        TestEntity entity = new TestEntity();
        bundle.putSerializable("a",entity);
        Intent intent = new Intent(this,JumpPageActivity.class);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}
