package com.sanking.leetcode.bitwise;

/**
 * Created by Sanking on 1/6/2019.
 */
public class BitwiseTest {

    public static void main(String[] args){

        int s = 5;

        System.out.println(Integer.toBinaryString(5));


//        //Integer i = new Integer();
//        System.out.println(0b101);//二进制:5  （0b开头的）
//        System.out.println(0e1011);//0.0
//        System.out.println(011);//八进制:9   (0开头的)
//        System.out.println(11);//十进制:11
//        System.out.println(0x11C);//十六进制:284   （0x开头的）



        System.out.println("12:" + Integer.toBinaryString(12));
        System.out.println("25:" + Integer.toBinaryString(25));
        System.out.println("12 | 25 :"  + (12 | 25) + " --> "+  Integer.toBinaryString(12 | 25 ));
        System.out.println("12 & 25 :"  + (12 & 25) + " --> "+  Integer.toBinaryString(12 & 25 ));
        System.out.println("~12 :" + (~12) + " --> " +  Integer.toBinaryString(~12 ));
        System.out.println("-12:" + Integer.toBinaryString(-12));
        System.out.println("~-12 :" + (~-12) + " --> " +  Integer.toBinaryString(~-12 ));
        //For any integer n, 2's complement of n will be -(n+1).
        // XOR
        System.out.println("12 ^ 25 :"  + (12 ^ 25) + " --> "+  Integer.toBinaryString(12 ^ 25 ));

        /**
         * Signed Left Shift
         The left shift operator << shifts a bit pattern to the left by certain number of specified bits, and zero bits are shifted into the low-order positions.

         n << 1 == n * 2

         */
        System.out.println("12 << 1: "  + (12 << 1) + " --> "+  Integer.toBinaryString(12 << 1 ));

        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        // 1111111111111111111111111111111
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE-1));

        System.out.println("Integer.MAX_VALUE << 1: "  + (Integer.MAX_VALUE << 1) + " --> "+  Integer.toBinaryString(Integer.MAX_VALUE << 1 ));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(-1) + " -1<<1 " + (-1<<1) + " --> " + Integer.toBinaryString(-1 << 1 ));
        System.out.println(Integer.toBinaryString(-13) + " -13<<1 " + (-13<<1) + " --> " + Integer.toBinaryString(-13 << 1 ));
        System.out.println(Integer.toBinaryString(13) + " 13<<1 " + (13<<1) + " --> " + Integer.toBinaryString(13 << 1 ));

        System.out.println(Integer.toBinaryString( 13&-13));

        /**
         Signed Right Shift
         The right shift operator >> shifts a bit pattern to the right by certain number of specified bits.
         */
        System.out.println("Integer.MAX_VALUE >> 1: "  + (Integer.MAX_VALUE >> 1) + " --> "+  Integer.toBinaryString(Integer.MAX_VALUE >> 1 ));
        // 111111111111111111111111111111
        System.out.println("Integer.MIN_VALUE >> 1: "  + (Integer.MIN_VALUE >> 1) + " --> "+  Integer.toBinaryString(Integer.MIN_VALUE >> 1 ));

        System.out.println(Integer.toBinaryString(25 ) + " 25 >> 1: "  + (25 >> 1) + " --> "+  Integer.toBinaryString(25 >> 1 ));
        System.out.println(Integer.toBinaryString(-25 ) + " -25 >> 1: "  + (-25 >> 1) + " --> "+  Integer.toBinaryString(-25 >> 1 ));

        //System.out.println(-25/2); // -12

        /**
         Unsigned Right Shift
         The unsigned right shift operator >>> shifts zero into the leftmost position.
         */
        System.out.println("Integer.MAX_VALUE >>> 1: "  + (Integer.MAX_VALUE >>> 1) + " --> "+  Integer.toBinaryString(Integer.MAX_VALUE >>> 1 ));
        // 111111111111111111111111111111
        System.out.println("Integer.MIN_VALUE >>> 1: "  + (Integer.MIN_VALUE >>> 1) + " --> "+  Integer.toBinaryString(Integer.MIN_VALUE >>> 1 ));

        System.out.println(Integer.toBinaryString(25 ) + " 25 >>> 1: "  + (25 >>> 1) + " --> "+  Integer.toBinaryString(25 >>> 1 ));
        System.out.println(Integer.toBinaryString(-25 ) + " -25 >>> 1: "  + (-25 >>> 1) + " --> "+  Integer.toBinaryString(-25 >>> 1 ));


        /**
         * Why no <<<
         */

        System.out.println(Integer.toBinaryString(1 << 2 ));

    }

}
