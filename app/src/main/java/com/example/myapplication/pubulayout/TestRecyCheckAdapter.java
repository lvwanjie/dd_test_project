package com.example.myapplication.pubulayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.MyUtils;
import com.example.myapplication.R;
import com.example.myapplication.widget.editText.ShapeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 自提信息列表
 */

public class TestRecyCheckAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private List<SelfPickAddressInfo> list;

    private SelfPickAddressInfo checkedInfo;

    private View headView;

    private final int TYPE_NORMAL = 0;
    private final int TYPE_HEAD = 1;

    public TestRecyCheckAdapter(Context context){
        this.context = context;
    }


    public void setHeadView(View view){
        this.headView = view;

    }

    public void setData(List list){
        this.list = list;
    }

    public static List getFackeData(){
        List list = new ArrayList();
        for(int i= 0;i<10;i++){

            SelfPickAddressInfo selfPickAddressInfo = new SelfPickAddressInfo();
            if(i == 0){
                selfPickAddressInfo.isDefault = true;
            }
            if(i == 1){
                selfPickAddressInfo.isOtherFirst = true;
            }
            selfPickAddressInfo.cabinetAddress = i+"北京市丰台区方庄南路12号底商北京市丰台";
            selfPickAddressInfo.cabinetName = i+"锦怡家园5号楼景豪超市";
            list.add(selfPickAddressInfo);
        }
        return list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEAD && headView != null){
            return new HeadVH(headView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_test_recy_check,parent,false);
        return new ReceiverVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
//        String[] s = new String[10000];
//        Bitmap bitmap;

        if(headView != null){
            if(position ==0){
                return;
            }else {
                position -= 1;
            }
        }
        if (holder instanceof ReceiverVH) {

            ReceiverVH receiverVH = (ReceiverVH) holder;

            final SelfPickAddressInfo info = list.get(position);
            receiverVH.bindData(info);
            receiverVH.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkedInfo == info) {
                        return;
                    }
                    if (checkedInfo != null) {
                        checkedInfo.isChecked = false;
                    }
                    checkedInfo = info;
                    checkedInfo.isChecked = true;
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if(headView != null){
            count = 1;
        }
        if(list != null){
            count += list.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_NORMAL;
        if(headView != null){
            if(position == 0){
                type = TYPE_HEAD;
            }
        }
        return type;
    }

    static class ReceiverVH extends RecyclerView.ViewHolder{

        public TextView tvListTitle;  //自提点标题
        public TextView etvCheckBox;
        public TextView tvSelfPickName;
        public TextView tvSelfPickAddress;
        public TextView tvDistance;
        private RelativeLayout rlSelfPickContent;

        public ReceiverVH(@NonNull View itemView) {
            super(itemView);
            tvListTitle = itemView.findViewById(R.id.tv_list_title);
            etvCheckBox = itemView.findViewById(R.id.etv_check_box);
            tvSelfPickName = itemView.findViewById(R.id.tv_self_pick_name);
            tvSelfPickAddress = itemView.findViewById(R.id.tv_self_pick_address);
            tvDistance = itemView.findViewById(R.id.tv_distance);
            rlSelfPickContent = itemView.findViewById(R.id.rl_self_pick_content);
            ShapeBuilder.create().Radius(MyUtils.dp2Px(rlSelfPickContent.getContext(),9)).
                    Soild (Color.parseColor("#ffffff")).build(rlSelfPickContent);
        }

        public void bindData(SelfPickAddressInfo info){
            if(info == null){
                return;
            }
            if(info.isChecked || info.isDefault){
                etvCheckBox.setText("选中");
                etvCheckBox.setTextColor(Color.parseColor("#ff463c"));
            }else {
                etvCheckBox.setText("未选中");
                etvCheckBox.setTextColor(Color.parseColor("#d5d5d5"));
            }

            if(info.isDefault){
                rlSelfPickContent.setBackgroundColor(Color.parseColor("#ffe2e2"));
                tvListTitle.setVisibility(View.VISIBLE);
                tvListTitle.setText("已选自提点");
            }else {
                rlSelfPickContent.setBackgroundColor(Color.parseColor("#ffffff"));
                if(info.isOtherFirst){
                    tvListTitle.setVisibility(View.VISIBLE);
                    tvListTitle.setText("其他自提点");
                }else {
                    tvListTitle.setVisibility(View.GONE);
                }
            }
            tvSelfPickName.setText(info.cabinetName);
            tvSelfPickAddress.setText(info.cabinetAddress);
            tvDistance.setText(info.distanceStr+"m");
        }
    }


    static class HeadVH extends RecyclerView.ViewHolder{

        public HeadVH(@NonNull View itemView) {
            super(itemView);
        }
    }


    public SelfPickAddressInfo getCheckInfo(){
        return checkedInfo;
    }
}
