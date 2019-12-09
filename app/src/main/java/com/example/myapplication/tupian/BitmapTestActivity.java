package com.example.myapplication.tupian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

public class BitmapTestActivity extends Activity {

    private ImageView imageView;
    private Button button;
    private String TAG = "BitmapTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_test);
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
               int bitmapWidth = drawable.getBitmap().getWidth();
               int bitmapHeight = drawable.getBitmap().getHeight();
               int drawableWidth = drawable.getIntrinsicWidth();
               int drawableHeight = drawable.getIntrinsicHeight();
               int byteCount = drawable.getBitmap().getByteCount();

                Log.i(TAG, "onClick: bitmapWidth="+bitmapWidth+
                        "；bitmapHeight="+bitmapHeight+"；drawableWidth="+
                        drawableWidth+";drawableHeight="+drawableHeight+"；byteCount="+byteCount);

                samplingRateBitmap();
            }
        });

    }

    public void samplingRateBitmap(){
        int inSampleSize = 2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_live_shop_cart,options);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int byteCount = bitmap.getByteCount();
        Log.i(TAG, "samplingRateBitmap: bitmapWidth="+bitmapWidth+
                "；bitmapHeight="+bitmapHeight+"；byteCount="+byteCount);

    }
}
