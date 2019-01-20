package com.sanking.leetcode;

/**
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

 Example 1:

 Input:
 [
 [1,1,1],
 [1,0,1],
 [1,1,1]
 ]
 Output:
 [
 [1,0,1],
 [0,0,0],
 [1,0,1]
 ]
 Example 2:

 Input:
 [
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
 ]
 Output:
 [
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
 ]
 Follow up:

 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        boolean columnZero = false;
        boolean rowZero = false;
        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix[0].length; j ++){
                if( matrix[i][j] == 0 ){
                    if( i == 0  ){
                        rowZero = true;
                    }
                    if( j == 0 ) {
                        columnZero = true;
                    }
                    if(i!=0&&j!=0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }

        for(int i = 1; i < matrix.length ; i ++){
            for(int j = 1; j<matrix[0].length ; j++){
                if( matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j]=0;
                }
            }
        }

//        for(int i = 1 ; i < matrix.length; i ++){
//            if( matrix[i][0] == 0 ){
//                for(int j=1; j< matrix[0].length; j++){
//                    matrix[i][j]=0;
//                }
//            }
//        }
//
//        for(int i = 1 ; i < matrix[0].length; i ++){
//            if( matrix[0][i] == 0 ){
//                for(int j=1; j< matrix.length; j++){
//                    matrix[j][i]=0;
//                }
//            }
//        }

        if(columnZero) {
            for(int j=0; j< matrix.length; j++){
                matrix[j][0]=0;
            }
        }

        if(rowZero) {
            for(int j=0; j< matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }

    }

    public static void main(String[] args){

        (new SetMatrixZeroes()).setZeroes(new int[][]
                {{1,1,1},{1,0,1},{1,1,1}});
//        (new SetMatrixZeroes()).setZeroes(new int[][]{{1,1,1},{0,1,2}});
    }

}
