package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head ==null || head.next == null) return head;

        ListNode h = head;
        ListNode res = head;
        ListNode c = head;

        int i = 0 ;
        boolean f = false;
        int t = 0 ;
        while(true){
            i++;
            if(c.next == null){
                // last one.
                c.next = head;
                if(!f){
                    f = true;
                }
                t = i - k%i;
                i = 0 ;
            }

            if(f&&i==t){
                res = c.next;
                c.next = null;
                break;
            }

            c = c.next;

        }

        return res;
    }

}
