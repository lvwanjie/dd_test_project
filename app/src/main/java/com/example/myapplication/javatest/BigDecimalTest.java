package com.example.myapplication.javatest;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.math.BigDecimal;
import java.util.List;

public class BigDecimalTest {

    public static void main(String[] args) {
//        BigDecimal value = new BigDecimal("2.1900000000");
//        BigDecimal noZeros = value.stripTrailingZeros();
//        String result = noZeros.toPlainString();
//        System.out.println("result: " + result);
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/resources.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/rt.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/sunrsasign.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/jsse.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/jce.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/charsets.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/jfr.jar:
//    /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/classes
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(BigDecimalTest.class.getClassLoader());
//        ClassLoader classLoader;


        testScale(2300000000.1);


    }


    public static  void testScale(double d){
        BigDecimal bigDecimal = new BigDecimal(d+"");
        System.out.println(bigDecimal.toString());

//        bigDecimal.stripTrailingZeros();
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
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
