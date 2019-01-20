package com.sanking.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i ++){

            Integer index = map.get(nums[i]);
            if(index != null){
                if( i-index <= k ){
                    return true;
                }
            }
            map.put(nums[i], i);


        }
        return false;
    }
}
