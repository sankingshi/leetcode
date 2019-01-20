package com.sanking.leetcode.queuestack;

import java.util.Arrays;
import java.util.Stack;

/**

 Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

 For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

 Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;

        for(int  i = 0 ; i < T.length ; i ++){
            while(top>-1 && T[i] > T[stack[top]]){
                result[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        return result;
    }


    public int[] dailyTemperatures_1(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int[] res = new int[T.length], stack = new int[T.length];
        int top = -1;

        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[stack[top]] < T[i]) {
                int temp = stack[top];
                res[temp] = i - temp;
                top--;
            }
            stack[++top] = i;
        }
        return res;
    }

    public static void main(String[] args){

        System.out.println(Arrays.toString((new DailyTemperatures()).dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}) ));

    }

}
