package com.sanking.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if(nums==null || nums.length == 0 ) return 0;
        Map<Integer, Map<Integer, Integer>> subMap = new HashMap<>();
        Map<Integer,Integer> newSub = new HashMap<>();
        newSub.put(Integer.MIN_VALUE,1);
        subMap.put(0,newSub);
        int longest = 0;
        for(int i = 0; i < nums.length; i ++){
            int v = nums[i];
            int j = longest;
            boolean f = false;
            int c = 0;
            while(j>=0) {
                Map<Integer,Integer> subseq = subMap.get(j);
                for(Integer lastNum: subseq.keySet()){
                    if ( v > lastNum ){
                        c+=subseq.get(lastNum);
                        f = true;
                    }
                }
                if(f){
                    int l = j+1;
                    if(l>longest) longest = l;
                    newSub = subMap.get(l);
                    if(newSub == null){
                        newSub = new HashMap<>();
                        newSub.put(v, c);
                        subMap.put(l, newSub);
                    } else {
                        if(newSub.get(v) == null){
                            newSub.put(v,c);
                        } else {
                            newSub.put(v, newSub.get(v)+c);
                        }
                    }
                    break;
                } else {
                    j--;
                }
            }
        }

        int res = 0;
        newSub = subMap.get(longest);
        for(Integer lastNum: newSub.keySet()){
            res += newSub.get(lastNum);
        }
        return res;
    }
}
