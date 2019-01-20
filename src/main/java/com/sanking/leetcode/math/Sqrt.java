package com.sanking.leetcode.math;

/**
 Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.
 */
public class Sqrt {

    public int mySqrt(int x) {
        if ( x < 1 ){
            return 0;
        } else if ( x < 4 ){
            return 1;
        }
        int left = 0;
        int right = x;

        while ( left <= right ){
            int m = left + ( right-left )/2;
            if ( m == x/m ){
                return m;
            } else if ( m < x/m ){
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left - 1;
    }

    public int mySqrt_x(int x) {
        if(x==0) return 0;
        else if (x<4) return 1;

        int l = 1;
        int r = x;
        while(l<r){
            int m = (r-l)/2 + l;
            int v = m*m;
            if( v == x ){
                return m;
            } else if( v > x ) {
                r = m -1;
            } else {
                l = m;
            }
        }
        return l-1;
    }

    public static void main(String[] args){
        System.out.println((new Sqrt()).mySqrt(8));
        System.out.println((new Sqrt()).mySqrt(1));
    }


    public int mySqrt_1(int x) {
        long z=x;
        while (z*z>x)
            z=(z+x/z)>>1;
        return (int)z;
    }
}
