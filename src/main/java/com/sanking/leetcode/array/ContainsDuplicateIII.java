package com.sanking.leetcode.array;

import java.util.*;

/**
 Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3, t = 0
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1, t = 2
 Output: true
 Example 3:

 Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 Output: false
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final Integer floor = set.floor(x);
            final Integer ceiling = set.ceiling(x);

            if ((floor != null && x <= floor + t)
                    || (ceiling != null && x >= ceiling -t))
                return true;

            set.add(x);
            if (i >= k) set.remove(nums[i - k]);
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if( nums==null || nums.length < 1 || k < 1 || t<0) return false;
        if( t == 0) return true;

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length ; i ++){
            int x = nums[i];
            Integer lower = set.floor(x);
            Integer higher = set.ceiling(x);

            if(( lower != null && x <= lower + t ) || ( higher != null && x >= higher - t ))return true;

            set.add(x);
            if( i >= k ){
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println((new ContainsDuplicateIII()).containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println((new ContainsDuplicateIII()).containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println((new ContainsDuplicateIII()).containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
//        System.out.println((new ContainsDuplicateIII()).containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));

//        System.out.println(-1-2147483647);
//        System.out.println(1+2147483647);
//        System.out.println(Math.abs(1+2147483647));
//        System.out.println(Integer.MAX_VALUE);

        //int i = 2147483648;
    }
}
