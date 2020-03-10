package com.example.myapplication.pubulayout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PubuAdapter extends RecyclerView.Adapter<PubuViewHolder> {

    private static String[] imgs = {
            "http://dmimg.5054399.com/allimg/pkm/pk/22.jpg",
            "http://file02.16sucai.com/d/file/2015/0408/779334da99e40adb587d0ba715eca102.jpg",
            "http://file02.16sucai.com/d/file/2014/0704/e53c868ee9e8e7b28c424b56afe2066d.jpg",
            "http://file02.16sucai.com/d/file/2014/0829/372edfeb74c3119b666237bd4af92be5.jpg",
            "http://g.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3d6e7bf85db8a1cd11738b29c0.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=b57187fbbf3eb13544c7b7b3961fa8cb/a826bd003af33a87dc2bab09c55c10385343b57a.jpg"
    };

    private Context context;

    private List<PubuItemEntity> list;
    private String TAG = "PubuAdapter";
    private RecyclerView.LayoutManager manager;



    public PubuAdapter(Context context, RecyclerView.LayoutManager manager){
        this.context = context;
        list = getFakeData();
        this.manager = manager;
        new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

    }
    @NonNull
    @Override
    public PubuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.pubu_item_layout,parent,false);
        PubuViewHolder viewHolder = new PubuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PubuViewHolder holder, int position) {

//        Log.i(TAG, "onBindViewHolder: itemMeasureWidth="+ holder.imageView.getMeasuredWidth());
//        Log.i(TAG, "onBindViewHolder: itemWidth="+ holder.imageView.getWidth());
//        Log.i(TAG, "onBindViewHolder: itemParamsWidth="+ holder.itemView.getLayoutParams().width);
//        Log.i(TAG, "onBindViewHolder: itemLeftDecorationWidth="+  manager.getLeftDecorationWidth(holder.itemView));
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();

        Log.i(TAG, "onBindViewHolder: spanIndex = " + params.getSpanIndex() +"; position = "+position);
        int type = position%imgs.length;
        if(position == 0 || position == 1 ){
            params.setFullSpan(true);
        }

        holder.setData(list.get(position),type);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 1;
        }
        return 2;
    }

    public List getFakeData(){
        List<PubuItemEntity> list = new ArrayList<>();
        for( int i = 0;i<100;i++){
            PubuItemEntity entity = new PubuItemEntity();
            entity.text = "item"+i;
            if(i%3 == 0){
                entity.text = "item"+i + "多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行多行";

            }
            entity.imgUrl = imgs[i%imgs.length];
            list.add(entity);
        }
        return list;
    }
}
