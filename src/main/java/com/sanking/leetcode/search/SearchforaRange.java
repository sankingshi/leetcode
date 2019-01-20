package com.sanking.leetcode.search;

import java.util.Arrays;

/**
 Given a sorted array of integers, find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1]. For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

 */
public class SearchforaRange {

    public static int[] searchRange(int[] nums, int target) {
        final int length = nums.length;
        int l = 0;
        int r = length;
        int i = -1;
        while( l<=r ){
            int m = (r-l)/2 + l;
            if(nums[m] == target){
                i = m;
                break;
            } else if( nums[m] < target ){
                l = m+1;
            } else {
                r = m;
            }
        }

        if(i == -1){
            return new int[]{-1, -1};
        } else {

            int r1 = i;
            for(int j = i-1 ; j >= 0 ; j --){
                if( nums[j] == target ){
                    r1 = j;
                } else {
                    break;
                }
            }
            int r2 = i;
            for(int j = i+1 ; j <length ; j ++){
                if( nums[j] == target ){
                    r2 = j;
                } else {
                    break;
                }
            }

            return new int[]{r1, r2};
        }
    }

    public static void main(String[] args){

//        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{5}, 5)));
//        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{5,5}, 5)));
//
//        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{0,1,2,3,4,5,6}, 5)));
        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{0,5,5,5,5,6}, 5)));
        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{0,2,3,4,4,4,5}, 5)));
//        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//
//        System.out.println(Arrays.toString(SearchforaRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));

    }

}
