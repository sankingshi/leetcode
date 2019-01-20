package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null ) return head;

        ListNode pre = head;
        ListNode c = head.next;

        while(c!= null){
            if( c.val == pre.val ){
                pre.next = c.next;
                c.next = null;
                c = pre.next;
            } else {
                pre = c;
                c = c.next;
            }
        }

        return head;

    }
}
