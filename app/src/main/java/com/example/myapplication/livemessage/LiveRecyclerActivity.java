package com.example.myapplication.livemessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//测试直播评论互动区的样式

public class LiveRecyclerActivity extends Activity {

    private RecyclerView recyclerView;
    private LiveRecyAdapter mAdapter;
    private Button btAddLast;
    private Button btAddFirst;
    private Button btGetInfo;
    private Button btPopupMenu;
    private List<String> list;
    private int firstIndex= 0;
    private int lastIndex= 0;
    private String TAG = "LiveRecyclerActivity";
    private TextView textView;
    private PopupMenu popupMenu;
    private PopupWindow mDefinitionPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_recycler);
        recyclerView = findViewById(R.id.recycler_view);
        btAddFirst = findViewById(R.id.bt_add_first);
        btAddLast = findViewById(R.id.bt_add_last);
        btGetInfo = findViewById(R.id.bt_get_function_info);
        btPopupMenu = findViewById(R.id.bt_popup_menu);
        textView =findViewById(R.id.text);
//        textView.setText(i);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,true));
        list = getData();
        mAdapter = new LiveRecyAdapter(this,list);
        recyclerView.setAdapter(mAdapter);
        btAddFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int  preFirstItemPostion =  layoutManager.findFirstVisibleItemPosition() ;
                ++firstIndex;
                list.add(0,"这是新加对首的item"+firstIndex);
                mAdapter.notifyItemInserted(0);
                if(preFirstItemPostion ==0){
                    recyclerView.scrollToPosition(0);
                }
            }
        });

        btAddLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++lastIndex;
                list.add("这是新加的队尾item"+lastIndex);
                mAdapter.notifyItemInserted(list.size()-1);
                recyclerView.scrollToPosition(list.size()-1);
            }
        });

        btGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cvso = recyclerView.computeVerticalScrollOffset();
                int cvse = recyclerView.computeVerticalScrollExtent();
                int cvsr = recyclerView.computeVerticalScrollRange();
                int chso = recyclerView.computeHorizontalScrollOffset();
                int chse = recyclerView.computeHorizontalScrollExtent();
                int chsr = recyclerView.computeHorizontalScrollRange();
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int fcvip = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int fvip = linearLayoutManager.findFirstVisibleItemPosition();
                int lcvip = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int lvip = linearLayoutManager.findLastVisibleItemPosition();
//                Log.i(TAG, "onClick: " +
//                        "\ncomputeVerticalScrollOffset="+cvso+
//                        ";\ncomputeVerticalScrollExtent="+cvse+
//                        ";\ncomputeVerticalScrollRange="+cvsr+
//                        ";\ncomputeHorizontalScrollOffset="+chso+
//                        ";\ncomputeHorizontalScrollExtent="+chse+
//                        ";\ncomputeHorizontalScrollRange="+chsr
//                );

//                Log.i(TAG, "onClick: " +
//                        "\nfindFirstCompletelyVisibleItemPosition="+fcvip+
//                        "\nfindFirstVisibleItemPosition="+fvip+
//                        "\nfindLastCompletelyVisibleItemPosition="+lcvip+
//                        "\nfindLastVisibleItemPosition="+lvip);

                File dexOutputDir = LiveRecyclerActivity.this.getDir("dex", 0);
                final String dexOutputPath = dexOutputDir.getAbsolutePath();
                Log.i(TAG, "onClick: dexOutputPath="+dexOutputPath);

                Class<?> localClass ;
//                localClass.getConstructor()
            }
        });

        btPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDefinitionPop();
            }
        });

    }

    public void showDefinitionPop(){
        if(mDefinitionPop == null){
            mDefinitionPop = new PopupWindow(this);
            mDefinitionPop.setWidth(MyUtils.dp2Px(this,72));
            View contentView = LayoutInflater.from(this).inflate(R.layout.pop_definition_menu,null,false);
            TextView tvSd = contentView.findViewById(R.id.tv_sd);
            TextView tvHd = contentView.findViewById(R.id.tv_hd);
            TextView tvFhd = contentView.findViewById(R.id.tv_fhd);
            mDefinitionPop.setContentView(contentView);
            mDefinitionPop.setBackgroundDrawable(null);
            mDefinitionPop.setOutsideTouchable(true);
            mDefinitionPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    btPopupMenu.setEnabled(true);
                }
            });
        }
        if(!mDefinitionPop.isShowing()){
            mDefinitionPop.showAsDropDown(btPopupMenu,0,0);
            btPopupMenu.setEnabled(false);
        }else {
            mDefinitionPop.dismiss();
        }

    }


    public void initPopupMenu(){

    }


    public List<String> getData(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("this is num ----" +i +"----");
        }
        return list;
    }
}
