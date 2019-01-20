package com.sanking.leetcode.search;

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.

 Example 1:

 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 Follow up:

 This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 Would this affect the run-time complexity? How and why?
 */
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int first = 0;
        int last = nums.length;
        while( first < last ){
            int m = (last-first)/2 + first;
            if( nums[m] == target ){
                return true;
            }

            while( first < m && nums[first] == nums[m]) {first++;}
            while( last-1 > m && nums[last-1] == nums[m]) {last--;}

            if( first == m && m == (last-1)){
                return false;
            } else if( first != m && nums[first] <= nums[m]){
                if( m==last || (nums[first] <= target && target < nums[m]) ){
                    last = m;
                } else {
                    first = m+1;
                }
            } else {
                if( first == m || target <= nums[last -1 ] && nums[m] < target){
                    first = m+1;
                } else {
                    last = m;
                }
            }
        }
        return false;
    }

}
