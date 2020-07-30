package com.example.myapplication.testGson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDouble {

    public static String json = "{\n" +
            "  \"isSupport\": 0,\n" +
            "  \"data\": {\n" +
            "    \"pageSize\": 10,\n" +
            "    \"content\": [\n" +
            "      {\n" +
            "        \"cabinetCode\": \"FC02012255\",\n" +
            "        \"cabinetName\": \"体育西横街小区华润万家旁入口右侧丰巢智能柜\",\n" +
            "        \"cabinetAddress\": \"广东省广州市天河区天河南街道体育西横街115号\",\n" +
            "        \"cabinetType\": \"FC\",\n" +
            "        \"latitude\": \"23.128937\",\n" +
            "        \"longitude\": \"113.325327\",\n" +
            "        \"distance\": 1\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"errorCode\": 0,\n" +
            "  \"errorMsg\": \"成功\"\n" +
            "}";

    public static String json1 = "{}";

    public  JSONObject my(String str){
        JSONObject jsonObject = null;
        try {
            jsonObject =  new JSONObject(json);

            if(jsonObject != null){
                String isSupport = jsonObject.optString("isSupport");
                JSONArray contentArray = jsonObject.optJSONArray("content");
                if(contentArray != null){
                     ArrayList addressList = new ArrayList<>();
                    for (int i = 0; i < contentArray.length(); i++) {
                        try {
                            JSONObject object = contentArray.getJSONObject(i);
                            SelfPickAddressInfo info = new SelfPickAddressInfo();
                            info.parse(object);
                            addressList.add(info);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(addressList.toString()+"");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }









public static class SelfPickAddressInfo {

    public boolean isChecked; // 是否选中(本地参数)

    public String cabinetName;  //自提柜名称

    public String cabinetAddress;  //自提柜详细地址

    public String cabinetCode; //自提柜编码

    public String cabinetType; //自提柜类型

    public String latitude;   //经度

    public String longitude;   //维度

    public double distance;   //距离

    public void parse(JSONObject jsonObject) {
        if (jsonObject != null) {
            cabinetCode = jsonObject.optString("cabinetCode");
            cabinetName = jsonObject.optString("cabinetName");
            cabinetAddress = jsonObject.optString("cabinetAddress");
            cabinetType = jsonObject.optString("cabinetType");
            latitude = jsonObject.optString("latitude");
            longitude = jsonObject.optString("longitude");
            distance = jsonObject.optDouble("distance");
        }
    }
}
}