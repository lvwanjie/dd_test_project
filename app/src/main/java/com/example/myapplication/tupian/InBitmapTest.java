package com.example.myapplication.tupian;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.lang.ref.WeakReference;

public class InBitmapTest extends AppCompatActivity {

    private static String[] imgs = {
            "http://dmimg.5054399.com/allimg/pkm/pk/22.jpg",
            "http://file02.16sucai.com/d/file/2015/0408/779334da99e40adb587d0ba715eca102.jpg",
            "http://file02.16sucai.com/d/file/2014/0704/e53c868ee9e8e7b28c424b56afe2066d.jpg",
            "http://file02.16sucai.com/d/file/2014/0829/372edfeb74c3119b666237bd4af92be5.jpg",
            "http://g.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3d6e7bf85db8a1cd11738b29c0.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=b57187fbbf3eb13544c7b7b3961fa8cb/a826bd003af33a87dc2bab09c55c10385343b57a.jpg"
    };

    private int bitmaps[]={
        R.mipmap.out_bitmap_1,
        R.mipmap.out_bitmap_2,
        R.mipmap.out_bitmap_3,
        R.mipmap.out_bitmap_4,
        R.mipmap.out_bitmap_5,
        R.mipmap.out_bitmap_6
    };
    private int i=0;

    private Bitmap bitmap;

    private ImageView imageView;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private String TAG ="InBitmapTest";
    
    private WeakReference<Thread> myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_bitmap_test);
        imageView = findViewById(R.id.image_view);
        bt1= findViewById(R.id.bt1);
        bt2= findViewById(R.id.bt2);
        bt3= findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        final Thread thread = new Thread(){
            @Override
            public void run() {
                Log.i(TAG, "run: 线程运行~~~~~~~~~");

                while (true){
                    try {
                        Log.i(TAG, "run: sleep前~~~~~~~~~");

                        Thread.sleep(10000);

                        Log.i(TAG, "run: 线程运行~~~~~~~~~");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        myThread = new WeakReference<Thread>(thread);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myThread.get() != null){
                    Log.i(TAG, "onClick: Thread 不为空");
                }else {
                    Log.i(TAG,"null");
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myThread.get() != null){
                    myThread.get().interrupt();
                }
            }
        });
        thread.start();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testNormal();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInBitmap(true);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                testInBitmap2();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                testNormal();
                testInBitmap(true);
            }
        });
    }

    private void testNormal(){
        if(i>5){
            i=0;
        }
        imageView.setImageResource(bitmaps[i]);
        i++;
    }

    private void testInBitmap(boolean inMutable){
//        if(i>5){
//            i=0;
//        }
        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inMutable = inMutable;
//        options.inSampleSize =1;
        if(bitmap != null){
            options.inBitmap = bitmap;
        }
        bitmap = BitmapFactory.decodeResource(getResources(),bitmaps[0],options);
//        Glide.with(this).load(bitmaps[0]);

//        String s[] = new String[1000000];

//        i++;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void testInBitmap2(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        options.inDensity = 320;
        options.inTargetDensity = 320;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.out_bitmap_1, options);
        Log.i(TAG, "bitmap = " + bitmap);
        Log.i(TAG, "bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());

        // 使用inBitmap属性，这个属性必须设置；
        options.inBitmap = bitmap;
        options.inDensity = 320;
        // 设置缩放宽高为原始宽高一半；
        options.inTargetDensity = 160;
        options.inMutable = true;
        Bitmap bitmapReuse = BitmapFactory.decodeResource(getResources(), R.mipmap.out_bitmap_6, options);
        // 复用对象的内存地址
        Log.i(TAG, "bitmapReuse = " + bitmapReuse);
        Log.i(TAG, "bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());
        Log.i(TAG, "bitmapReuse：ByteCount = " + bitmapReuse.getByteCount() + ":::bitmapReuse：AllocationByteCount = " + bitmapReuse.getAllocationByteCount());
    }


    public void test3(){

        LruCache<String,Bitmap> lruCache = new LruCache<String,Bitmap>(20){
            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }
        };
    }

}
