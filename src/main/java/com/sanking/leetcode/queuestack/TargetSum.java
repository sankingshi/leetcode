package com.sanking.leetcode.queuestack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums== null || nums.length == 0 ){
            return 0;
        }
        int size = nums.length;
        int[] stack = new int[size+1];
        stack[0] = 0;
        return calcuation(nums, stack, 0, S,1) + calcuation(nums, stack, 0, S,-1);
    }

    public int calcuation(int[] nums, int stack[], int index, int target, int flag){
        int current = stack[index] + nums[index] * flag;
        if( index == nums.length-1  ){
            if( current==target ){
                return 1;
            } else {
                return 0;
            }
        }
        stack[index+1] = current;
        return calcuation(nums, stack, index+1, target,1) + calcuation(nums, stack, index+1, target, -1) ;
    }


    public static void main(String[] args) {
        System.out.println( (new TargetSum()).findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays_1(int[] nums, int S) {

        if(nums== null || nums.length == 0 ){
            return 0;
        }

        int size = nums.length;
        int[] stack = new int[size];
        int[] flag = new int[size];
        int top = 0;
        stack[0] = nums[0];

        int result = 0 ;

        while(true){

            // push into stack
            int current = stack[top] + (nums[top+1] * ( flag[top]==0? 1: -1) );
            if( top == size - 2 && current == S){
                result ++;
                top --;
            } else if ( current>= S ){
                if( flag[top] == 1 ){
                    top --;
                }
                flag[top] = flag[top]== 0 ? 1 : 0;
            } else {
                stack[top+1] = current;
                top ++;
            }

            break;
        }

        return result;
    }
}

class Solution_1 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}


class Solution_2 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
}


/**
 Approach #3 2D Dynamic Programming [Accepted]
 Algorithm

 The idea behind this approach is as follows. Suppose we can find out the number of times a particular sum, say sum_isum
 i
 ​
 is possible upto a particular index, say ii, in the given numsnums array, which is given by say count_icount
 i
 ​
 . Now, we can find out the number of times the sum sum_i + nums[i]sum
 i
 ​
 +nums[i] can occur easily as count_icount
 i
 ​
 . Similarly, the number of times the sum sum_i - nums[i]sum
 i
 ​
 −nums[i] occurs is also given by count_icount
 i
 ​
 .

 Thus, if we know all the sums sum_jsum
 j
 ​
 's which are possible upto the j^{th}j
 th
 index by using various assignments, along with the corresponding count of assignments, count_jcount
 j
 ​
 , leading to the same sum, we can determine all the sums possible upto the (j+1)^{th}(j+1)
 th
 index along with the corresponding count of assignments leading to the new sums.

 Based on this idea, we make use of a dpdp to determine the number of assignments which can lead to the given sum. dp[i][j]dp[i][j] refers to the number of assignments which can lead to a sum of jj upto the i^{th}i
 th
 index. To determine the number of assignments which can lead to a sum of sum + nums[i]sum+nums[i] upto the (i+1)^{th}(i+1)
 th
 index, we can use dp[i][sum + nums[i]] = dp[i][sum + nums[i]] + dp[i-1][sum]dp[i][sum+nums[i]]=dp[i][sum+nums[i]]+dp[i−1][sum]. Similarly, dp[i][sum - nums[i]] = dp[i][sum + nums[i]] + dp[i-1][sum]dp[i][sum−nums[i]]=dp[i][sum+nums[i]]+dp[i−1][sum]. We iterate over the dpdp array in a rowwise fashion i.e. Firstly we obtain all the sums which are possible upto a particular index along with the corresponding count of assignments and then proceed for the next element(index) in the numsnums array.
 */
class Solution_3 {

    public int findTargetSumWays(int[] nums, int S) {

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for( int i = 0 ; i < nums.length ; i ++ ){
            Map<Integer, Integer> currentMap = new HashMap<>();
            int n = nums[i];
            for(int preSum: sumMap.keySet()){
                int count = sumMap.get(preSum);
                for(int j = 1; j <= 2; j++){
                    n = n*(-1);
                    int sum = preSum + n;
                    if( currentMap.get(sum)!= null ){
                        currentMap.put(sum, count+currentMap.get(sum));
                    } else {
                        currentMap.put(sum, count);
                    }
                }
            }
            sumMap = currentMap;
        }

        return sumMap.get(S) == null ? 0 : sumMap.get(S);
    }

}

/**
 这里的数学等式换算可以去除对减法的处理，而且可以过滤很多无解的情况。

 */
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) return -1;
        // 方法1：
        /*
        sum(P) - sum(N) = target
        sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        2 * sum(P) = target + sum(nums)
        只需要找一个满足和为这样的子集P的个数就是方法数
        */
        int sum=0;
        for(int num:nums) sum+=num;
        return ((sum+S)%2>0 || sum<S)?0:helper(nums,(sum+S)>>1);

    }
    public int helper(int [] nums,int target){
        // 使用一个dp数组记录 ：dp[i]表示达到 数字 i 的方法有多少种;
        int [] dp=new int[target+1];
        dp[0]=1;
        for(int num:nums){
            if(target>=num){
                for(int i=target;i>=num;i--){
                    dp[i]+=dp[i-num]; // 表示 i由 (i-num) 这个数的达到方法 加上 目前由其他途径到达的方法数
                }
            }
        }
        return dp[target];
    }
    /*
    // 方法2解题思路：复杂度高
    // 每次遍历到一个数时，该数和前面的数都有两种情况，加或者减，
    // 类同树的分根，使用递归遍历到最后一个节点
    //private int res=0;
    public void helper(int [] nums,int index,int S,int sum){
        if(index==nums.length ){
            if(sum==S){
              res++;
            }
            return;
        }
        helper(nums,index+1,S,sum+nums[index]);
        helper(nums,index+1,S,sum-nums[index]);
    }
    */
}
