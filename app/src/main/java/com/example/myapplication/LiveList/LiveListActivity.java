package com.example.myapplication.LiveList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HeaderViewListAdapter;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;


public class LiveListActivity extends Activity {

    private RecyclerView mRecyclerView;
    private LiveListRcAdapter mAdapter;
    private static  String TAG = "LiveListActivity";
    private View statusBarBg;
    private View mTitleBg;
    private View skinBg;
    private int titleBgtransRange;
    private PtrClassicFrameLayout mPtrFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_live_list);
        statusBarBg =findViewById(R.id.status_bar_bg);
        mTitleBg = findViewById(R.id.title_bg);
        skinBg = findViewById(R.id.view_skin_bg);
        mPtrFrameLayout = findViewById (R.id.silver_refresh_frame);
        mPtrFrameLayout.addPtrUIHandler(new PtrUIHandler() {
            @Override
            public void onUIReset(PtrFrameLayout frame) {
                Log.i(TAG, "onUIReset: ");
            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {
                Log.i(TAG, "onUIRefreshPrepare: ");
            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {
                Log.i(TAG, "onUIRefreshBegin: ");
            }

            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {
                Log.i(TAG, "onUIRefreshComplete: ");
            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
                Log.i(TAG, "onUIPositionChange: ");
            }
        });
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                Log.i(TAG, "checkCanDoRefresh: ");
                return PtrDefaultHandler.checkContentCanBePulledDown (frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.i(TAG, "onRefreshBegin: ");

            }
        });

        statusBarBg.getLayoutParams().height = MyUtils.getStatusBarHeight(this);
        setChenjin();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new LiveListRcAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(LiveListItemEntity.getFakeData());

//        setData();
//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                Log.i(TAG, "onScrollStateChanged: newState="+newState);
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                Log.i(TAG, "onScrolled: dx= "+dx+";dy="+dy);
//                super.onScrolled(recyclerView, dx, dy);
//                if(mRecyclerView.computeVerticalScrollOffset() < MyUtils.dp2Px(LiveListActivity.this,180)){
//                    skinBg.setTranslationY(-recyclerView.computeVerticalScrollOffset ());
//                    float alpha = (float) (recyclerView.computeVerticalScrollOffset () / (double) MyUtils.dp2Px (LiveListActivity.this, 60));
//                    mTitleBg.setAlpha (alpha);
//                    statusBarBg.setAlpha(alpha);
//                }
//
//            }
//        });
    }


    public void setData(){
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONObject jsonObject1 = jsonObject.optJSONObject("data");
            String jsonStr = jsonObject1.toString();
            Gson gson = new Gson();
            LiveListEntity liveList = gson.fromJson(jsonStr, LiveListEntity.class);
            if(liveList != null){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void setChenjin(){
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static String jsonStr = "{\n" +
            "   \"errorCode\": 0,\n" +
            "   \"errorMsg\": \"成功\",\n" +
            "   \"data\": {\n" +
            "      \"liveList\": [\n" +
            "      {\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\", //直播标题\n" +
            "        \"liveBgImageUrl\": \"https:www.baidu.com\",  //直播背景图\n" +
            "        \"anchorName\": \"白马时光书店\", //主播名\n" +
            "        \"anchorImgUrl\": \"https:www.baidu.com\", //主播头像\n" +
            "        \"liveState\": 0,   //0:直播预告，1：直播开始，2：直播结束\n" +
            "        \"startTimeStr\": \"本周一20：30开播\", //预告开播时间liveState为0 时下发\n" +
            "        \"spectatorNum\":4260, //观众人数 liveState为1、2 时下发\n" +
            "        \"jumpUrl\":\"\" //跳转字典\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\",\n" +
            "        \"liveBgImageUrl\": \"https:www.baidu.com\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https:www.baidu.com\",\n" +
            "        \"liveState\": 0,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\":4260,\n" +
            "        \"jumpUrl\":\"\"\n" +
            "      }\n" +
            "    ]\n" +
            "      }\n" +
            "   }\n" +
            "}";
}
