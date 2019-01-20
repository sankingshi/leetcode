package com.sanking.leetcode.queuestack;

import java.util.*;
import java.util.stream.Collectors;

/**
 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.

 */
public class Matrix01 {

    private static int[] d = new int[]{0,1,0,-1,0};

    public int[][] updateMatrix(int[][] matrix) {

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> processed = new HashSet<>();

        int x_size = matrix.length;
        int y_size = matrix[0].length;

        for(int i = 0 ; i < x_size; i ++){
            for(int j=0 ; j < y_size; j++){

                if(matrix[i][j] == 0){
                    queue.offer(i*y_size+j);

                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        if(queue.size() == 0 ){
            // no 0. impossible
        }

        int depth = 1 ;

        int marker = -1;
        queue.offer(marker);

        while(!queue.isEmpty()){

            int key = queue.poll();

            if(processed.contains(key)){
                continue;
            }

            if( key == marker && queue.isEmpty()){
                break;
            } else
            if( key == marker ){
                depth ++;
                queue.offer(marker);
                continue;
            }

            processed.add(key);

            int x = key/y_size;
            int y = key%y_size;

            for(int i = 0 ; i < 4 ; i ++){
                int m = x + d[i];
                int n = y + d[i+1];
                if( m >=0 && m < x_size && n >= 0 && n<y_size && matrix[m][n] == -1 ){
                    queue.offer(m*y_size+n);
                    matrix[m][n] = depth;
                }
            }

        }

        return matrix;
    }

    public static void main(String[] args){

//        int[][] input = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] input = new int[][]{{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};
//        int[][] output= Matrix01_1.updateMatrix(input);
        int[][] output= Matrix01_BFS.updateMatrix(input);
        System.out.println(Arrays.asList(output).stream().map( Arrays::toString ).collect(Collectors.joining("\n")));

        System.out.println("----------------------------------");

//        input = new int[][]{{1,Integer.MAX_VALUE,0, 1}
//                ,{1,1,1, Integer.MAX_VALUE}
//                ,{1,Integer.MAX_VALUE,1, Integer.MAX_VALUE}
//                ,{0,Integer.MAX_VALUE,1, 1}};

//        input = new int[][]{
//                {1,1,0, 1}
//                ,{1,1,1, 1}
//                ,{1,1,1, 1}
//                ,{0,1,1, 1}};
//        output = Matrix01_1.updateMatrix(input);
//        System.out.println(Arrays.asList(output).stream().map( Arrays::toString ).collect(Collectors.joining("\n")));
//        System.out.println("----------------------------------");
//        output = Matrix01_1.updateMatrix_1(input);
//        System.out.println(Arrays.asList(output).stream().map( Arrays::toString ).collect(Collectors.joining("\n")));
    }

}

class Matrix01_BFS {

//    private int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
//
//    private boolean isLegal(int x, int y, int m, int n) {
//        return x>=0 && y>=0 && x<m && y<n;
//    }
private static int[] d = new int[]{0,1,0,-1,0};

    public static int[][] updateMatrix(int[][] matrix) {

        int x_size = matrix.length;
        int y_size = matrix[0].length;
        int[][] result = new int[x_size][y_size];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    list.add(i*y_size+j);
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int key: list){
            dfs(matrix, key/y_size, key%y_size, result);
        }

        return result;
    }

    public static void dfs(int[][] rooms, int i, int j, int[][] result) {
        for (int k = 0; k < 4; ++k) {  // process the four directions
            int p = i + d[k], q = j + d[k + 1];
            if (0<= p && p < rooms.length && 0<= q && q < rooms[0].length && result[p][q] > result[i][j] + 1 ) {
                result[p][q] = result[i][j] + 1;
                dfs(rooms, p, q,result);
            }
        }
    }


}




class Matrix01_1 {

//    private int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
//
//    private boolean isLegal(int x, int y, int m, int n) {
//        return x>=0 && y>=0 && x<m && y<n;
//    }

    public static int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int MAX = m*n;
        for(int i = 0 ; i < m; i ++){
            for(int j = 0 ; j < n ; j++){

                if(matrix[i][j] == 1){

                    int up = i>0 ? dp[i-1][j] : MAX;
                    int left = j>0 ? dp[i][j-1] : MAX;
                    dp[i][j]=Math.min(up,left)+1;

                }

            }
        }

        for(int i=m-1; i >= 0 ; i--){
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j] == 1){
                    int down = i< m-1? dp[i+1][j]: MAX;
                    int right = j <n-1? dp[i][j+1]: MAX;
                    dp[i][j]= Math.min(dp[i][j], (Math.min(down,right)+1));
                }
            }
        }

        return dp;


    }


    /**
     * Why this method doesn't work?
     *
     * 每一次遍历，后面处理的应该依赖于前面处理的
     * 这个方法，当前元素的处理依赖于之后要处理的元素。
     *
     */
    public static int[][] updateMatrix_1(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int MAX=m*n;
        int[][] dp=new int[m][n];

        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {

                if(matrix[i][j]==1) {
                    int up=i>0?dp[i-1][j]:MAX;
                    int left=j>0?dp[i][j-1]:MAX;
                    dp[i][j]=Math.min(up,left)+1;
                }
            }
        }

        System.out.println(Arrays.asList(dp).stream().map( Arrays::toString ).collect(Collectors.joining("\n")));

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==1) {
                    int down=i<m-1?dp[i+1][j]:MAX;
                    int right=j<n-1?dp[i][j+1]:MAX;
                    dp[i][j]=Math.min(dp[i][j],Math.min(down,right)+1);
                }
            }
        }

        return dp;
    }
}
