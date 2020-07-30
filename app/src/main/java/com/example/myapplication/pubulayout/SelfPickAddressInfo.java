package com.example.myapplication.pubulayout;

import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * 自提地点信息
 */
public class SelfPickAddressInfo {

    public boolean isDefault;  //订单中默认选中的

    public boolean isOtherFirst; //其他自提柜第一个

    public boolean isChecked; // 是否选中(本地参数)

    public String cabinetName;  //自提柜名称

    public String cabinetAddress;  //自提柜详细地址

    public String cabinetCode; //自提柜编码

    public String cabinetType; //自提柜类型

    public String latitude;   //经度

    public String longitude;   //维度

    public double distance;   //距离

    public String distanceStr;

    public void parse(JSONObject jsonObject){
        if(jsonObject != null){
            cabinetCode = jsonObject.optString("cabinetCode");
            cabinetName = jsonObject.optString("cabinetName");
            cabinetAddress = jsonObject.optString("cabinetAddress");
            cabinetType = jsonObject.optString("cabinetType");
            latitude = jsonObject.optString("latitude");
            longitude = jsonObject.optString("longitude");
            distance = jsonObject.optDouble("distance");
            distanceStr = new BigDecimal(distance).
                    setScale(2,BigDecimal.ROUND_HALF_UP).
                    stripTrailingZeros().
                    toString();
        }
    }


}
