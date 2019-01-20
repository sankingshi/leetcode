package com.sanking.leetcode.search;

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int first = 0 ;
        int last = nums.length;
        while( first < last ){
            int m = (last-first)/2 + first;

            if( nums[m] == target ){
                return m;
            } else if ( nums[first] <= nums[m] ){
                if(  nums[first] <= target && target < nums[m] ){
                    last = m;
                } else {
                    first = m+1;
                }
            } else {
                if( target <= nums[last-1] && nums[m] < target ){
                    first = m+1;
                } else {
                    last = m;
                }
            }
        }
        return -1;
    }
}
