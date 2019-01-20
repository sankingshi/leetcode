package com.sanking.leetcode.queuestack;

/**
 * Created by Sanking on 12/9/2018.
 */
public class MyCircularQueue {

    private int head = -1;
    private int tail = -1;
    private int size = 0;
    private final int dataSize;
    private final int[] data;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.dataSize = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if( this.isFull() ){
            return false;
        }
        if( this.isEmpty()){
            this.head = (this.head+1+this.dataSize)%this.dataSize;
        }

        this.size++;
        this.tail = (this.tail+1+this.dataSize)%this.dataSize;
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
            this.head = (this.head+1+this.dataSize)%this.dataSize;
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

        MyCircularQueue obj = new MyCircularQueue(81);

        obj.enQueue(69);
        obj.deQueue();
        obj.enQueue(92);
        obj.enQueue(12);
        obj.deQueue();
        obj.isFull();
        obj.isFull();
        obj.Front();


    }

}
