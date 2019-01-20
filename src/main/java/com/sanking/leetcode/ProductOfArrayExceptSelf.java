package com.sanking.leetcode;

/**
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Note: Please solve it without division and in O(n).

 Follow up:
 Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;

        for(int i = 1; i < length; i ++){
            res[i] = res[i-1]*nums[i-1];
        }

        int product = 1;
        for(int i = length-2; i >=0 ; i--){
            product *= nums[i+1];
            res[i] *= product;
        }

        return res;
    }
}
