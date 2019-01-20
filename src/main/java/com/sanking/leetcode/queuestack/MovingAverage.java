package com.sanking.leetcode.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sanking on 12/14/2018.
 */
public class MovingAverage {

    private final Queue<Integer> stream = new LinkedList<>();
    private final int size;
    private int sum = 0;
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(stream.size()==size){
            sum -=stream.poll();
        }
        sum +=val;
        stream.offer(val);
        return sum*1d/stream.size();
    }

    public static void main(String[] args) throws Exception {

        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1)) ;//= 1
        System.out.println(m.next(10));//= (1 + 10) / 2
        System.out.println(m.next(3) ); //= (1 + 10 + 3) / 3
        System.out.println(m.next(5) ); //= (10 + 3 + 5) / 3

    }
}
