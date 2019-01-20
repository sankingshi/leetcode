package com.sanking.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanking on 12/29/2018.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {

        if( nums == null || nums.length == 0 ){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0 ;

        Integer n = null;
        Integer pre = null;
        Integer post = null;
        int c;
        int l;
        int h;
        for(int i = 0 ; i < nums.length ; i ++){
            n = map.get(nums[i]);
            if( n == null ){
                c = 0;

                pre = map.get(nums[i]-1);
                post = map.get(nums[i]+1);
                l = nums[i];
                h = nums[i];

                if( pre != null ){
                    c += pre;
                    l = nums[i] - pre;
                }
                if( post != null){
                    c += post;
                    h = nums[i] + post;
                }
                map.put(nums[i], c+1);
                if( pre != null ) map.put(l, c+1);
                if( post != null) map.put(h, c+1);

                if( c+1> res){
                    res = c+1;
                }
            }
        }

        return res;

    }

    public static void main(String[] args){

        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));

    }
}
