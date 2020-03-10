package com.example.myapplication.testGson;

import android.util.Log;

import com.google.gson.Gson;


import org.json.JSONObject;

import java.util.List;

public class TestGson {

    private static final String TAG = "TestGson" ;

    public static void main(String args[]){
        Gson gson = new Gson();
        MainModel mainModel =  gson.fromJson(str,MainModel.class);
        testJSONObject(str);
        Log.i(TAG, "main: ");
    }


    public static void testJSONObject(String str){
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.optString("l");
            List list = (List) jsonObject.opt("list");
            Log.i(TAG, "testJSONObject: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String str1 = "{\n" +
            "  \"list\": [{\"viewType\": 1,\"a\": 2},{\"viewType\": 2,\"b\": 2}]\n" +
            "}";

    public static String str = "{\n" +
            "  \"list\": [{\"viewType\": 1,\"a\": 2},{\"viewType\": 2,\"b\": 2}]\n" +
            "}";


    public static String str3 ="{\"a\":\"b\"}";
}
