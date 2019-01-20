package com.sanking.leetcode.queuestack;

import org.junit.jupiter.api.Test;

/**
 * Created by Sanking on 12/9/2018.
 */
public class MyCircularQueueTest {

    @Test
    public void testMyCircularQueue(){
        MyCircularQueue obj = new MyCircularQueue(81);

        obj.enQueue(69);
        obj.deQueue();
        obj.enQueue(92);
        obj.enQueue(12);
        obj.deQueue();
        obj.isFull();
        obj.isFull();
        obj.Front();

        obj.deQueue();
        obj.enQueue(28);
        obj.Front();
        obj.enQueue(13);
        obj.enQueue(45);
        obj.Rear();
        obj.Rear();
        obj.deQueue();
        obj.enQueue(24);
        obj.enQueue(27);
        obj.Rear();
        obj.Rear();
        obj.Front();
        obj.Rear();
        obj.Rear();
        obj.deQueue();
        obj.enQueue(88);
        obj.Rear();
        obj.deQueue();
        obj.Rear();
        obj.Rear();
        obj.Front();
        obj.Front();
        obj.enQueue(53);
        obj.enQueue(39);
        obj.Front();
        obj.enQueue(28);
        obj.enQueue(66);
        obj.enQueue(17);
        obj.Front();
        obj.isEmpty();
        obj.enQueue(47);
        obj.Rear();
        obj.enQueue(87);
        obj.Front();
        obj.enQueue(92);
        obj.enQueue(94);
        obj.Front();
        obj.enQueue(59);
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(99);
        obj.deQueue();
        obj.Front();
        obj.enQueue(84);
        obj.Rear();
        obj.isEmpty();
        obj.Front();
        obj.enQueue(52);
        obj.Front();
        obj.deQueue();
        obj.enQueue(86);
        obj.enQueue(30);
        obj.deQueue();
        obj.deQueue();
        obj.Front();
        obj.Front();
        obj.deQueue();
        obj.isEmpty();
        obj.enQueue(45);
        obj.Rear();
        obj.Front();
        obj.enQueue(83);
        obj.isEmpty();
        obj.Front();
        obj.Front();
        obj.enQueue(22);
        obj.enQueue(77);
        obj.enQueue(23);
        obj.Rear();
        obj.Front();
        obj.Front();
        obj.enQueue(14);
        obj.isEmpty();
        obj.deQueue();
        obj.enQueue(90);
        obj.enQueue(57);
        obj.Rear();
        obj.deQueue();
        obj.Rear();
        obj.Front();
        obj.enQueue(34);
        obj.deQueue();
        obj.Rear();
        obj.Front();
        obj.Rear();
        obj.deQueue();
        obj.Rear();
        obj.Rear();
        obj.enQueue(49);
        obj.enQueue(59);
        obj.Rear();
        obj.enQueue(71);


    }

}
