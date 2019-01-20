package com.sanking.leetcode.queuestack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sanking on 12/14/2018.
 */
public class MinStack_2 {

    private final List<Integer> stack = new ArrayList<>();
    private final List<Integer> min = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack_2() {}

    public void push(int x) {
        this.stack.add(x);
    }

    public void pop() {
        if(stack.size() > 0){
            this.stack.remove(this.stack.size()-1);
        }
    }

    public int top() {
        if(stack.size() > 0){
            return this.stack.get(this.stack.size()-1);
        } else {
            return 0;
        }
    }

    public int getMin() {
        if( this.stack.size() == 0 ){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < this.stack.size() ; i ++){
            min = Math.min(this.stack.get(i),min);
        }
        return min;
    }
}
