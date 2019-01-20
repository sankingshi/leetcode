package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Share
 Given a linked list, swap every two adjacent nodes and return its head.

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Note:

 Your algorithm should use only constant extra space.
 You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null ) return head;

        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;

        ListNode pre = root;
        ListNode c = head;
        ListNode t = null;

        while(c!=null){

            if( c.next == null ){
                break;
            } else {
                t = c.next.next;
                pre.next = c.next;
                pre.next.next = c;
                c.next = t;
                pre = c;
                c = c.next;
            }

        }

        return root.next;
    }
}
