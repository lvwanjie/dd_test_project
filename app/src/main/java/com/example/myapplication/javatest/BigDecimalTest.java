package com.example.myapplication.javatest;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.math.BigDecimal;
import java.util.List;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("2.1900000000");
        BigDecimal noZeros = value.stripTrailingZeros();
        String result = noZeros.toPlainString();
        System.out.println("result: " + result);



    }

//    public SpannableString getAwardDecString(String str, List<HighLightPositionModel> list){
//        SpannableString spanString = new SpannableString (str);
//        for(HighLightPositionModel model:list){
//            ForegroundColorSpan span = new ForegroundColorSpan (Color.parseColor ("#FF3E2E"));
//            spanString.setSpan (span,model.start,model.start+model.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        }
//        return spanString;
//    }
}
