package com.sanking.leetcode;

import java.util.Arrays;

/**
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: 3
 Output: "III"
 Example 2:

 Input: 4
 Output: "IV"
 Example 3:

 Input: 9
 Output: "IX"
 Example 4:

 Input: 58
 Output: "LVIII"
 Explanation: L = 50, V = 5, III = 3.
 Example 5:

 Input: 1994
 Output: "MCMXCIV"
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if( num >= 1000 ){
            sb.append(fill('M', num/1000));
            num = num%1000;
        }
        if( num>= 100){
            toRoman(num/100, sb, 'C', 'D', 'M');
            num = num%100;
        }
        if( num>= 10){
            toRoman(num/10, sb, 'X', 'L', 'C');
            num = num%10;
        }
        toRoman(num, sb, 'I', 'V', 'X');
        return sb.toString();
    }

    private void toRoman(int n, StringBuilder sb, char one, char five, char ten){
        if(n<4){
            sb.append(fill(one, n));
        } else if (n==4){
            sb.append(one).append(five);
        } else if (n== 5){
            sb.append(five);
        } else if( n== 9){
            sb.append(one).append(ten);
        } else {
            sb.append(five).append(fill(one, n-5));
        }
    }

    private char[] fill(char c, int n){
        char[] cc = new char[n];
        Arrays.fill(cc, c);
        return cc;
    }

}
