package com.sanking.leetcode.queuestack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.

 */
public class PerfectSquares {

    /**
     * DP
     * f(0) = 0
     * f(1) = 1
     * f(2) = Min( f(2-1) ) + 1 = 2
     * f(3) = Min( f(3-1) ) + 1 = 3
     * f(4) = Min( f(4-1), f(4-4) ) + 1 = 1
     * f(5) = Min( f(5-1), f(5-4) ) + 1 = 2
     * .......
     * f(n) = Min( f(n-1), f(n-4), f(n-9)....) + 1
     *
     */
    public int numSquares_dp(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j<= i; j++){
                min = Math.min( min, res[i-j*j] ) ;
            }
            res[i] = min+1;
        }
        return res[n];
    }


    /**
     *  用queue的大小来标注每一步处理的列表
     *
     *  用减法不是加法，这样减少运算量
     *
     *  还是超出时间
     */
    public int numSquares_BFS(int n) {

        Set<Integer> processed = new HashSet<>();
        int depth = 0;
        Queue<Integer> processing = new LinkedList<>();
        processing.offer(n);

        while(!processing.isEmpty()){
            int size = processing.size();
            depth++;
            for( int i = 0 ; i < size; i ++ ){
                int node = processing.poll();
                for(int j = 0 ; j*j<= node ; j++){
                    int les = node - j*j;
                    if(les==0){
                        return depth;
                    } else {
                        processing.offer(les);
                    }
                }
            }
        }

        return 0;
    }

}
