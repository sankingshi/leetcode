package com.sanking.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.





 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0 ;
        int j = height.length-1;
        int maxWater = 0 ;
        while(j>i){
            maxWater = Math.max(maxWater, (j-i)*Math.min(height[i], height[j]));
            if( height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }

    public int maxArea_1(int[] height) {
        int maxWater = 0 ;
        for(int i = 0 ; i < height.length ; i ++){
            for(int j = i+1; j < height.length ; j ++ ){
                maxWater = Math.max(maxWater, (j-i)*Math.min(height[i], height[j]) );
            }
        }
        return maxWater;
    }
}
