package com.sanking.leetcode;

/**
 Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Note:

 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;

        int flag = -1;
        if( (dividend>0 && divisor >0 )|| (dividend<0 && divisor < 0)){
            flag = 1;
        }
        long dividendlong = Math.abs((long) dividend);
        long divisorlong = Math.abs((long) divisor);
        long result = 0 ;
        if(divisorlong == 1)  {
            result = dividendlong;
        } else {
            while( dividendlong >= divisorlong ){
                result ++;
                dividendlong -=divisorlong;
            }
        }
        return (int)((flag==1) ? Math.min(result, Integer.MAX_VALUE) : Math.max(-result, Integer.MIN_VALUE));
    }

}
