package com.sanking.leetcode.sort.bucket;

/**
 Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 Note:

 Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        for(int i = 0 ; i < n ; i ++){
            while(nums[i] != i+1){
                if( nums[i] < 1 || nums[i] > n || nums[i] == nums[ nums[i] -1 ]) break;
                int temp = nums[i];
                nums[i] = nums[temp -1];
                nums[temp - 1] = temp;
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if( nums[i] != i+1 ) return i+1;
        }
        return nums.length+1;
    }

}
