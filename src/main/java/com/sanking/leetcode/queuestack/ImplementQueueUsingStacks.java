package com.sanking.leetcode.queuestack;

import java.util.Stack;

/**
 * Created by Sanking on 12/16/2018.
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> stack = new Stack<>();
//    private Integer first;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
    }
    /** Push element x to the back of queue. */
    public void push(int x) {

//        if( this.stack.isEmpty() ){
//            this.first = x;
//        }

        Stack<Integer> newStack = new Stack<>();
        while(!this.stack.isEmpty()){
            newStack.push(stack.pop());
        }
        this.stack.push(x);
        while(!newStack.isEmpty()){
            this.stack.push(newStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return this.stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.size() == 0;
    }
    /**

     ["MyQueue","push","push","push","pop","pop","pop","empty"]
     [[],[1],[2],[3],[],[],[],[]]

     * @param args
     */
    public static void main(String[] args) {

        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}


class ImplementQueueUsingStacks_1 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> queue = new Stack<>();
    int fistInStack;

    /** Initialize your data structure here. */

    /** Push element x to the back of queue. */
    public void push(int x) {
        if( this.stack.isEmpty()){
            this.fistInStack = x;
        }
        this.stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( this.queue.isEmpty() ){
            while(!this.stack.isEmpty()){
                this.queue.push(this.stack.pop());
            }
        }
        return this.queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return this.queue.isEmpty() ? this.fistInStack : this.queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty() ;
    }

}
