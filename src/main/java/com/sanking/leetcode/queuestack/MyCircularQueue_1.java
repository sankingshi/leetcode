package com.sanking.leetcode.queuestack;

/**
 * Created by Sanking on 12/9/2018.
 */
public class MyCircularQueue_1 {

    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final int dataSize;
    private final int[] data;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue_1(int k) {
        this.data = new int[k];
        this.dataSize = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if( this.isFull() ){
            return false;
        }
        if( this.isEmpty()){
            this.head++;
            if( this.head >= this.dataSize ){
                this.head = 0;
            }
        }

        this.size++;
        this.tail++;
        if( this.tail >= this.dataSize ){
            this.tail = 0;
        }
        this.data[this.tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if( this.isEmpty() ){
            return false;
        }
        this.size--;
        if( !this.isEmpty() ){
            this.head++;
            if( this.head >= this.dataSize ){
                this.head = 0;
            }
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return this.isEmpty() ? -1 : this.data[this.head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return this.isEmpty() ? -1 : this.data[this.tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size == this.dataSize ;
    }

    public static void main(String[] args) throws Exception {
        System.out.println( (3+1+5)%5);
        System.out.println( (4+1+5)%5);
    }

}
