package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Example:

 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null ) return head;

        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;

        ListNode t = root;
        ListNode p = root;
        ListNode c = head;

        boolean f = false;
        while(c!=null){

            if(!f){
                if( c.val < x ) { t = c; }
                else { f = true; }
                p = c;
                c = c.next;
            } else {
                if( c.val < x ){
                    p.next = c.next;
                    c.next = t.next;
                    t.next = c;
                    t = t.next;
                    c = p.next;
                } else {
                    p = c;
                    c = c.next;
                }
            }
        }

        return root.next;
    }
}
