package com.sanking.leetcode.math;

/**
 Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {

    public double myPow(double x, int n) {
        if(n==0) return 1;
        boolean negative = n < 0;
        char[] c = Integer.toBinaryString( negative ? -n:n ).toCharArray();
        double res = 1;
        double pow = x;
        for(int i = c.length-1; i>=0; i--){
            if( c[i] == '1' ){
                res *=pow;
            }
            pow *=pow;
        }
        return negative ? 1.0/res : res;
    }


    // public double myPow(double x, int n) {
    //     if (n < 0) return 1.0 / power(x, -n);
    //     else return power(x, n);
    // }
    // private static double power(double x, int n) {
    //     if (n == 0) return 1;
    //     double v = power(x, n / 2);
    //     if (n % 2 == 0) return v * v;
    //     else return v * v * x;
    // }

}
