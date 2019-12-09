package com.example.myapplication.LiveList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 直播列表item对象
 */
public class LiveListItemEntity {

    public String liveTitle;
    public String liveBgImageUrl;
    public String anchorName;
    public String anchorImgUrl;
    public int liveState;
    public String startTimeStr;
    public int spectatorNum;
    public String jumpUrl;


    public String getLiveStateStr(){
        String str = "";
        switch (liveState){
            case 1:
                str = "直播中";
                break;
            case 2:
                str = "直播结束";
                break;
            case 3:
                str = startTimeStr;
                break;
            default:break;
        }
        return str;
    }


    public static List getFakeData(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(str);
            JSONObject dataObject = jsonObject.optJSONObject("data");
            String jsonStr = dataObject.toString();
            Gson gson = new Gson();
            LiveListEntity data = gson.fromJson(jsonStr,LiveListEntity.class);
           return data.liveList;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for(int i=0;i<10;i++){
            LiveListItemEntity entity = new LiveListItemEntity();
            list.add(entity);
        }
        return list;
    }


    public static String str = "{\n" +
            "  \"errorCode\": 0,\n" +
            "  \"errorMsg\": \"成功\",\n" +
            "  \"data\": {\n" +
            "    \"currentPage\": 1,\n" +
            "    \"hasNextPage\": true,\n" +
            "    \"liveList\": [{\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\",\n" +
            "        \"liveBgImageUrl\": \"http://img1.imgtn.bdimg.com/it/u=1690728803,2100828734&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https:www.baidu.com\",\n" +
            "        \"liveState\": 1,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"dierchang zhibo \",\n" +
            "        \"liveBgImageUrl\": \"https:www.baidu.com\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https://b-ssl.duitang.com/uploads/item/201208/30/20120830173930_PBfJE.jpeg\",\n" +
            "        \"liveState\": 3,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\",\n" +
            "        \"liveBgImageUrl\": \"http://img1.imgtn.bdimg.com/it/u=1690728803,2100828734&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"http://5b0988e595225.cdn.sohucs.com/images/20181121/73d787c0bda14f728b54e53794c045ad.jpeg\",\n" +
            "        \"liveState\": 1,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"dierchang zhibo \",\n" +
            "        \"liveBgImageUrl\": \"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2000674628,227281144&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https://b-ssl.duitang.com/uploads/item/201208/30/20120830173930_PBfJE.jpeg\",\n" +
            "        \"liveState\": 3,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\",\n" +
            "        \"liveBgImageUrl\": \"http://img1.imgtn.bdimg.com/it/u=1690728803,2100828734&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https:www.baidu.com\",\n" +
            "        \"liveState\": 1,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"dierchang zhibo \",\n" +
            "        \"liveBgImageUrl\": \"https:www.baidu.com\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https://b-ssl.duitang.com/uploads/item/201208/30/20120830173930_PBfJE.jpeg\",\n" +
            "        \"liveState\": 3,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"诵读经典新概念，养成纯正伦敦腔\",\n" +
            "        \"liveBgImageUrl\": \"http://img1.imgtn.bdimg.com/it/u=1690728803,2100828734&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"http://5b0988e595225.cdn.sohucs.com/images/20181121/73d787c0bda14f728b54e53794c045ad.jpeg\",\n" +
            "        \"liveState\": 1,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"liveTitle\": \"dierchang zhibo \",\n" +
            "        \"liveBgImageUrl\": \"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2000674628,227281144&fm=26&gp=0.jpg\",\n" +
            "        \"anchorName\": \"白马时光书店\",\n" +
            "        \"anchorImgUrl\": \"https://b-ssl.duitang.com/uploads/item/201208/30/20120830173930_PBfJE.jpeg\",\n" +
            "        \"liveState\": 3,\n" +
            "        \"startTimeStr\": \"本周一20：30开播\",\n" +
            "        \"spectatorNum\": 4260,\n" +
            "        \"jumpUrl\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

}
