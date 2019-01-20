package com.sanking.leetcode.queuestack;

import java.util.*;
import java.util.stream.Collectors;

/**

 You are given a m x n 2D grid initialized with these three possible values.
 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room.
 We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 */
public class WallsAndGates {

    /**
     * 一个非常好的小技巧，来处理一个坐标的四个方向, 漂亮！
     for (int k = 0; k < 4; ++k) {
     int m = i + d[k], n = j + d[k + 1];
     }
     m -> 0 1 0 -1
     n -> 1 0 -1 0
     */
    public static final int[] d = {0, 1, 0, -1, 0};

    /**
     * 如何存储二维数组的坐标
     *  存储为一个数 - i * rooms[0].length + j
     *  用的时候给分开来 - int i = x / rooms[0].length, j = x % rooms[0].length;
     *
     *  这是n进制的运用，数学功底很棒的方案。
     */

    /**
     *  BFS 解决方案
     *  从所有的gate开始遍历，
     *  第一次遍历，把所有距离为1的给找出来
     *  第二次遍历，把所有距离为2的给找出来
     *
     */
    public void wallsAndGates_BFS(int[][] rooms) {

        if( rooms == null || rooms.length == 0){
            return;
        }
        int x_size = rooms.length;
        if( rooms[0] == null || rooms[0].length == 0){
            return;
        }
        int y_size = rooms[0].length;
        Queue<Integer> q = new ArrayDeque<>();

        // 把gate放进queue
        for( int i = 0 ; i < x_size ; i ++ ){
            for(int j = 0 ; j < y_size ; j ++){
                if( rooms[i][j] == 0 ){
                    q.offer( i * y_size + j );
                }
            }
        }

        while(!q.isEmpty()){
            Integer gate = q.poll();
            int x = gate/y_size;
            int y = gate%y_size;
            for( int i = 0 ; i < 4; i ++ ){
                int m = x + d[i];
                int n = y + d[i+1];

                if( m >= 0 && m<x_size && n>=0 && n<y_size && rooms[m][n] == Integer.MAX_VALUE ){
                    rooms[m][n] = rooms[x][y]+1;
                    q.add(m*y_size+n);
                }
            }
        }
    }


    /**
     * 深度优先遍历
     *
     * 递归函数处理
     *
     * 筛检分支的条件 - rooms[p][q] > rooms[i][j] + 1
     *
     * 每个Gate都会把每个room都计算一遍，这样比广度优先要处理的节点多吗？
     *
     */

    public void wallsAndGates_DFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) dfs(rooms, i, j);
    }

    public void dfs(int[][] rooms, int i, int j) {
        for (int k = 0; k < 4; ++k) {  // process the four directions
            int p = i + d[k], q = j + d[k + 1];
            if (0<= p && p < rooms.length && 0<= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
                rooms[p][q] = rooms[i][j] + 1;
                dfs(rooms, p, q);
            }
        }
    }

    public void wallsAndGates_DP(int[][] rooms) {

        int x_size = rooms.length;
        int y_size = rooms[0].length;

        int MAX = Integer.MAX_VALUE;

        for( int i = 0 ; i < x_size ; i ++ ){
            for(int j = 0 ; j < y_size ; j++){

                if( rooms[i][j] == MAX ){



                }
            }
        }

        /**

         INF  -1  0  1
         INF INF INF  -1
         1  -1 INF  -1
         0  -1 INF INF

         INF  -1  0  1
         INF INF INF  -1
         1  -1 INF  -1
         0  -1 INF INF

         */




    }


    public static void main(String[] args) throws Exception{
        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] nums = new int[][]
                    { {Integer.MAX_VALUE, -1, 0 , Integer.MAX_VALUE},
                            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE , -1},
                            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE , -1},
                            {0, -1, Integer.MAX_VALUE , Integer.MAX_VALUE}};
        wallsAndGates.wallsAndGates_BFS(nums);
        Arrays.stream(nums).map( Arrays::toString ).forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------");

        nums = new int[][]
                { {Integer.MAX_VALUE, -1, 0 , Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE , -1},
                        {Integer.MAX_VALUE, -1, Integer.MAX_VALUE , -1},
                        {0, -1, Integer.MAX_VALUE , Integer.MAX_VALUE}};
        wallsAndGates.wallsAndGates_DFS(nums);
        Arrays.stream(nums).map( Arrays::toString ).forEach(System.out::println);



    }
}
