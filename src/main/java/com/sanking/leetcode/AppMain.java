package com.sanking.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanking on 12/9/2018.
 */
public class AppMain {

    public static void main(String[] args){
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(100000000);

        BigDecimal b = new BigDecimal(1);
        BigDecimal t = new BigDecimal(2);
        BigDecimal r = new BigDecimal(0);
        int res = 1;
        for(int i = 1; i <=64; i ++){
            r = r.add(b);
            System.out.println( i + "\t:" + b.toString());
            b = b.multiply(t);
        }
        System.out.println( "Total:" + r.toString());

        Map<String,String> s = new HashMap<>();
        s.keySet();

    }
}
