package com.sanking.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 4){
            return res;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length -3 ; i++){
            if( nums[i] << 2 > target) break;
            for(int j = nums.length -1; j> i+2; j --){
                if( nums[j] << 2 < target) break;
                int lo = i+1, hi = j-1, sum = nums[i]+nums[j] - target;
                while(lo<hi){
                    if( sum + nums[lo] +nums[hi] == 0 ){
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while( lo+1 < j && nums[lo] == nums[lo+1] ) lo++;
                        while( hi-1 > i && nums[hi] == nums[hi-1] ) hi--;
                        lo++;
                        hi--;
                    } else if( sum + nums[lo] +nums[hi] > 0  ){
                        hi--;
                    }  else {
                        lo++;
                    }
                }
                while(j>i+3 && nums[j] == nums[j-1]) j--;
            }
            while(i <nums.length-4 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }


}
