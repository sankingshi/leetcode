package com.sanking.leetcode;

import java.util.Arrays;

/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if(s == null || s.length()==0 || numRows <= 1){
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0 ; i < sbs.length ; i ++){
            sbs[i] = new StringBuilder();
        }
        char[] source = s.toCharArray();

        int index = 0 ;
        int m = 2*numRows-2;
        for(int i = 0 ; i < source.length ; i++){
            int n = i%m;
            if( n >= numRows ){
                sbs[m-n].append(source[i]);
            } else {
                sbs[n].append(source[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb: sbs){
            result.append( sb );
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(ZigZagConversion.convert("PAYPALISHIRING", 3));

        final int i;
        i=0;
//        i=2;
    }
}
