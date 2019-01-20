package com.sanking.leetcode;

/**
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long y = x;
        long result = 0;
        while(true){
            long m = y%10;
            result = result*10 + m;
            y = y/10;
            if(y == 0){
                break;
            }
        }

        if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int)result;
        }
    }

    public static void main(String[] args){
//        System.out.println( -11%10 );
//        System.out.println( -1/10 );
//
        System.out.println(ReverseInteger.reverse(123));
        System.out.println(ReverseInteger.reverse(1));
        System.out.println(ReverseInteger.reverse(-123));
        System.out.println(ReverseInteger.reverse(-100));
        System.out.println(ReverseInteger.reverse(-1001));

        System.out.println("  r ".trim());
        System.out.println('9'-'0');
    }
}
