package com.sanking.leetcode;

/**
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:

 Input: [1,2,3,4,5]
 Output: true
 Example 2:

 Input: [5,4,3,2,1]
 Output: false

 https://leetcode.com/problems/increasing-triplet-subsequence/
 https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/increasing-triplet-subsequence.html
 */
public class IncreasingTripletSubsequence {

    /**
     * 扫描一遍数组，用变量x1保存当前最小的值，变量x2保存当前第二小的值。如果右面能碰到一个数大于x2，说明必然存在一个递增的三元组。
     */
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i : nums){
            if(i <= min1){
                min1 = i;
            } else if (i <= min2 ){
                min2 = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
