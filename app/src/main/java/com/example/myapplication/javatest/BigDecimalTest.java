package com.example.myapplication.javatest;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("2.1900000000");
        BigDecimal noZeros = value.stripTrailingZeros();
        String result = noZeros.toPlainString();
        System.out.println("result: " + result);
    }
}
