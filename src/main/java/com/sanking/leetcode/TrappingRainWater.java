package com.sanking.leetcode;

import java.util.Stack;

/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6

 https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {

        if(height==null || height.length <2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0 ;
        for(int i = 1 ; i < height.length; i++){

            if(height[i] == height[i-1]){
                continue;
            } else if( height[i] < height[i-1] ){
                stack.push(i-1);
            } else {

                if(stack.isEmpty()){
                    continue;
                }

                int h = height[i-1];
                while(true){
                    int pre = height[stack.peek()];
                    res += (Math.min(pre,height[i])-h)*((i-1)-stack.peek());
                    h=pre;
                    if( pre <= height[i] ){
                        stack.pop();
                    }
                    if(stack.isEmpty() || pre>=height[i]){
                        stack.push(i);
                        break;
                    }
                }

            }
        }

        return res;
    }
}
