package com.sanking.leetcode.enumeration;

import java.util.Arrays;

/**
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2 ){
            return;
        }
        int size = nums.length;
        int l = size -1;
        while(l > 0 && nums[l] <= nums[l-1]) l--;
        int r = l+1;
        while( l > 0 && r < size && nums[r] > nums[l-1]) r++;
        if(l>0) switchChar(nums, l-1, r-1);

        r = size -1;
        while(l < r){
            switchChar(nums, l, r);
            l++;
            r--;
        }
    }

    public void switchChar(int[] nums, int i, int j){
        if(i==j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] input = new int[]{5,1,1};
//        int[] input = new int[]{1,2,3};
//        int[] input = new int[]{3,2,1};
        (new NextPermutation()).nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}
