package com.sanking.leetcode.search;

/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 Example 2:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 Output: false
 */
public class Searcha2DMatrix {

    /**
     * m * n
     * O(m + logn)
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        for( int i = 0 ; i < matrix.length ; i ++ ){
            final int length = matrix[i].length;

            if(length == 0){
                return false;
            }

            if( matrix[i][0] <= target && matrix[i][length-1] >= target ){

                int first = 0 ;
                int last = length;
                while(first < last){

                    int m = (last-first)/2 + first;
                    if( matrix[i][m] == target ){
                        return true;
                    } else if( matrix[i][m] > target ){
                        last = m;
                    } else {
                        first = m+1;
                    }
                }
                break;
            }

        }
        return false;
    }

    /**
     *
        整个一起找，也是一个方法。
        O( log(m*n))
     */
    public boolean searchMatrix_1(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        final int  m = matrix.length;
        final int n = matrix[0].length;

        int first = 0;
        int last = m * n;

        while (first < last) {
            int mid = first + (last - first) / 2;
            int value = matrix[mid / n][mid % n];

            if (value == target)
                return true;
            else if (value < target)
                first = mid + 1;
            else
                last = mid;
        }

        return false;
    }
}
