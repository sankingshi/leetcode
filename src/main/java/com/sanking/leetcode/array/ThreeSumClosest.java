package com.sanking.leetcode.array;

import java.util.Arrays;

/**
 Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 0;
        int sum = 0 ;
        int diff = Integer.MAX_VALUE ;
        int cd = 0;
        for(int i = 0 ; i < nums.length - 2; i ++){

            if( i == 0 || (i>0 && nums[i] != nums[i-1])){
                int lo = i+1, hi = nums.length -1;
                while(lo<hi){
                    sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < target){
                        lo++;
                    } else {
                        hi--;
                    }
                    cd = Math.abs(sum - target);
                    if( cd < diff ){
                        res = sum;
                        diff = cd;

                    }
                }
            }
        }

        //StringBuilder sb = new StringBuilder();
        //sb.clone();
        return res;
    }
}
