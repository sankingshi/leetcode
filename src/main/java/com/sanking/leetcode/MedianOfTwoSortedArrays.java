package com.sanking.leetcode;

/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {


    public static  double  findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         * 找到长度大的数组
         */
        int[] a = nums1;
        int[] b = nums2;
        if( a.length < b.length ){
            int[] temp = a;
            a = b;
            b = temp;
        }
        int m = a.length;
        int n = b.length;

        int iLeft = 0;
        int iRight = m;
        /**
         * 如果 m+n 是偶数，(m+n+1)/2 == (m+n)/2
         * 如果 m+n 是奇数，(m+n+1)/2 - 如果只有一个元素，可以保证定位到那个元素。
         */
        int halfLength = (m+n+1)/2;
        while( true ){

            int i = (iLeft+iRight) / 2;
            int j = halfLength - i;

            if( i < iRight && b[j-1] > a[i] ){
                iLeft = i +1; // i is too small
            } else if( i > iLeft && a[i-1] > b[j]){
                iRight = i -1; // i is too big
            } else {

                int maxLeft = 0 ;
                if( i == 0 ) { maxLeft = b[j-1];}
                else if(j==0) { maxLeft = a[i-1];}
                else { maxLeft = Math.max(a[i-1], b[j-1]);}
                if( (m+n)%2==1 ){
                    return maxLeft;
                }
                int minRight = 0 ;
                if( i == m) {minRight = b[j];}
                else if ( j== n) {minRight = a[i];}
                else {minRight = Math.min(a[i],b[j]);}
                return (maxLeft+minRight)/2.0;
            }

            break;
        }
        return 0d;
    }

    public static  double  findMedianSortedArrays_Brute(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length == 0 ){
            if(nums2.length == 1){
                return nums2[0];
            }
            int middle = nums2.length/2;
            return nums2.length%2 == 0 ? (nums2[middle-1]+nums2[middle])/2d : nums2[middle]*1d;
        }
        if(nums2 == null || nums2.length == 0 ){
            if(nums1.length == 1){
                return nums1[0];
            }
            int middle = nums1.length/2;
            return nums1.length%2 == 0 ? (nums1[middle-1]+nums1[middle])/2d : nums1[middle]*1d;
        }

        int[] nums = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(true){
            if( i == nums1.length && j == nums2.length){
                break;
            }
            if(j == nums2.length){
                nums[k] = nums1[i];
                i++;
            } else if( i >= nums1.length ) {
                nums[k] = nums2[j];
                j++;
            } else if(nums1[i]<=nums2[j] ){
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        int middle = nums.length/2;
        return nums.length%2 == 0 ? (nums[middle-1]+nums[middle])/2d : nums[middle]*1d;
    }

    public static void main(String[] args) {
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
    }
}
