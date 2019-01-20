package com.sanking.leetcode;

/**
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]
 */
public class RotateImage {


    /**
     * i,j -> j,n-1-i
     * |--> n-1-i, n-1-j
     * |--> n-1-j, i
     */
    public void rotate_1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++){
            int l = 0, h = n-1;
            while( l < h){
                swap(matrix, i, l, i, h);
                l ++;
                h --;
            }
        }

        for(int i = 0 ; i < n-1; i ++){
            for(int j = 0 ; j < n-1-i; j++){
                swap(matrix, i, j, (n-j-1),(n-i-1));
            }
        }

    }

    private void swap(int[][] matrix, int si, int sj, int ti, int tj){
        int tmp = matrix[si][sj];
        matrix[si][sj] = matrix[ti][tj];
        matrix[ti][tj] = tmp;
    }
}
