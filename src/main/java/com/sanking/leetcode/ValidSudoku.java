package com.sanking.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true
 Example 2:

 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.
 */
public class ValidSudoku {

    public boolean isValidSudoku_good(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < 9; i++){
            set.clear();
            for(int j = 0 ; j<9 ; j++){
                if( board[i][j] !='.'  ){
                    if( set.contains(board[i][j]) ) return false;
                    else set.add(board[i][j]);
                }
            }
            set.clear();
            for(int j = 0 ; j<9 ; j++){
                if( board[j][i] !='.'  ){
                    if( set.contains(board[j][i]) ) return false;
                    else set.add(board[j][i]);
                }
            }
        }

        for(int i = 0; i <3; i ++){
            for(int j = 0 ; j < 3 ; j ++){
                set.clear();
                for(int m = i*3 ; m < (i+1)*3 ; m ++){
                    for(int n = j*3; n < (j+1)*3; n++){
                        if( board[m][n] !='.'  ){
                            if( set.contains(board[m][n]) ) return false;
                            else set.add(board[m][n]);
                        }
                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println((new ValidSudoku()).isValidSudoku(new char[][]
                {       {'.','.','.','.','.','.','5','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'9','3','.','.','2','.','4','.','.'},
                        {'.','.','7','.','.','.','3','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','3','4','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','.'},
                        {'.','.','.','.','.','5','2','.','.'}}));
    }

}
