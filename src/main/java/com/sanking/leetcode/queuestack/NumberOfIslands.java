package com.sanking.leetcode.queuestack;

import java.util.*;

/**
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid){
        return numIslands_BFS(grid);
//        return numIslands_DFS(grid);
    }

    public static final int[] d = {0, 1, 0, -1, 0};

    public int numIslands_BFS(char[][] grid) {

        if( grid == null || grid.length == 0){
            return 0;
        }
        int x_size = grid.length;
        if( grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int y_size = grid[0].length;
        int result = 0;

        for(int i = 0 ; i < x_size; i ++){
            for(int j = 0 ; j < y_size ; j ++){
                if( grid[i][j] == '1'){
                    result ++;
                    grid[i][j] = '0';
                    Queue<Integer> processing = new LinkedList<>();
                    processing.offer( i*y_size+j );
                    while(!processing.isEmpty() ){
                        int c = processing.poll();
                        int m = c/y_size;
                        int n = c%y_size;

                        for(int k = 0 ; k < 4 ; k ++){
                            int x = m + d[k];
                            int y = n + d[k+1];
                            if( x >= 0 && x < x_size && y >= 0 && y < y_size && grid[x][y] == '1'){
                                processing.offer(x*y_size+y);
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * 从1开始，把1和这个1相连的所有1都给变成0， 然后岛屿数量增加一。
     * 这个不是BFS,应该是DFS.
     */
    public int numIslands_DFS(char[][] grid) {
        int result = 0;
        for(int i = 0 ; i < grid.length; i++){
            for( int j = 0 ; j < grid[i].length; j++ )
            {
                if( grid[i][j] == '1' ){
                    explore(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void explore(char[][] grid, int x, int y){
        if( x < 0 || y < 0 || x >= grid.length || y>= grid[x].length || grid[x][y] == '0' ){
            return;
        } else {
            grid[x][y] = '0';
            explore(grid, x-1, y);
            explore(grid, x, y-1);
            explore(grid, x+1, y);
            explore(grid, x, y+1);
        }
    }

    public static void main(String[] args) {

//        System.out.println( (new NumberOfIslands()).numIslands(new char[][]{
//                {'1','1','1','1','0'},{'1','1','0','1','0'},
//                {'1','1','0','0','0'},{'0','0','0','0','0'}
//        }) );

        System.out.println( (new NumberOfIslands()).numIslands(new char[][]
                        {
                                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
                        }
                ) );

    }

}
