package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {

        final int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < length ; i ++){
            List<List<Integer>> newRes = new ArrayList<>();
            for(List<Integer> l: res){
                for(int j = 0 ; j < length ; j ++){
                    if( !l.contains(j) && !set.contains(nums[j]) ){
                        newRes.add( new ArrayList<>(l));
                        newRes.get(newRes.size()-1).add(j);
                        set.add(nums[j]);
                    }
                }
                set.clear();
            }
            res = newRes;
        }

        for(List<Integer> l: res){
            for(int i = 0 ; i < length; i++){
                l.set(i, nums[l.get(i)]);
            }
        }
        return res;
    }
}
