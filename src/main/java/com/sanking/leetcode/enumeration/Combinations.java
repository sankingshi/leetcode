package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i = 1; i <= k; i ++){
            List<List<Integer>> newRes = new ArrayList<>();
            for(List<Integer> l : res){
                for( int j = (l.size() == 0 ? 1 : l.get(l.size()-1) +1); j <= n ; j++ ){
                    newRes.add(new ArrayList<>(l));
                    newRes.get(newRes.size()-1).add(j);
                }
            }
            res = newRes;
        }
        return res;
    }
}
