package com.sanking.leetcode.search;

/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 Example:

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Searcha2DMatrixII {


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;
        final int m = matrix.length;
        final int n = matrix[0].length;
        if( n == 0 ) return false;

        int i = 0 ;
        int j = n-1;
        while( i<m && j >= 0 ){
            if( matrix[i][j] == target ){
                return true;
            } else if(matrix[i][j] < target){
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public boolean searchMatrix_wrong(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        final int m = matrix.length;
        final int n = matrix[0].length;
        if( n == 0 ) return false;

        int first = 0 ;
        int last = m*n;

        while(first<last){
            int mid = (last-first)/2 + first;
            int y = mid/m;
            int x = mid%m;

            if( matrix[x][y] == target ){
                return true;
            } else if( matrix[x][y] > target){
                last = mid;
            } else {
                first = mid+1;
            }

        }

        return false;
    }

    public static void main(String[] args){
//        System.out.println((new Searcha2DMatrixII())
//                .searchMatrix(new int[][]
//                        {       {1,4,7,11,15},
//                                {2,5,8,12,19},
//                                {3,6,9,16,22},
//                                {10,13,14,17,24},
//                                {18,21,23,26,30}}, 5));

        System.out.println((new Searcha2DMatrixII())
                .searchMatrix(new int[][]
                        {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 15));
    }

}
