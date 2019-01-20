package com.sanking.leetcode;

/**
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {


    public static int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0 , nums.length-1);
    }


    /**
     https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
     1) Divide the given array in two halves
     2) Return the maximum of following three
     ….a) Maximum subarray sum in left half (Make a recursive call)
     ….b) Maximum subarray sum in right half (Make a recursive call)
     ….c) Maximum subarray sum such that the subarray crosses the midpoint

     The lines 2.a and 2.b are simple recursive calls. How to find maximum subarray sum such that the subarray crosses the midpoint? We can easily find the crossing sum in linear time. The idea is simple, find the maximum sum starting from mid point and ending at some point on left of mid, then find the maximum sum starting from mid + 1 and ending with sum point on right of mid + 1. Finally, combine the two and return.
     */

    private static int maxSubArraySum(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        int m = (left+right)/2;
        return Math.max(
                Math.max(maxSubArraySum(nums, left, m),
                        maxSubArraySum(nums, m+1, right)),
                maxCrossingSum(nums, left, m, right));
    }

    private static int maxCrossingSum(int[] nums, int left, int m, int right){
        int sum = 0 ;
        int left_sum = Integer.MIN_VALUE;
        for(int i = m; i >=left ; i--){
            sum += nums[i];
            if(sum>left_sum){
                left_sum = sum;
            }
        }
        sum = 0 ;
        int right_sum = Integer.MIN_VALUE;
        for(int i = m+1; i <=right; i++){
            sum += nums[i];
            if(sum>right_sum){
                right_sum = sum;
            }
        }
        return left_sum + right_sum;
    }




    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{1,2,3,4,5}));
        System.out.println(maxSubArray(new int[]{-1,-2,-3,-4,-5}));
        System.out.println(maxSubArray(new int[]{-2,-3,-4,-5}));
//
//        System.out.println(Kadane.maxSubArraySum(new int[]{1,2,3,4,5}));
//        System.out.println(Kadane.maxSubArraySum(new int[]{-1,-2,-3,-4,-5}));
//        System.out.println(Kadane.maxSubArraySum(new int[]{-2,-3,-4,-5}));
    }

}


/**

 这个问题给BestTimeToBuyAndSellStock是类似的。
 对于每个负数，计算就可以停止，从下一个开始

 */

class Kadane
{
    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +  maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
