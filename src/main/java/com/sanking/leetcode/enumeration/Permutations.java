package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        final int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0 ; i < length ; i++){
            List<List<Integer>> newRes = new ArrayList<>();
            for( List<Integer> l : res ){
                for( int j = 0 ; j < length ; j ++ ){
                    if( l.contains(nums[j]) ) continue;
                    newRes.add( new ArrayList<>(l));
                    newRes.get(newRes.size()-1).add(nums[j]);
                }
            }
            res = newRes;
        }
        return res;
    }
}
