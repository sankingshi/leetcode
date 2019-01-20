package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Reverse a singly linked list.

 Example:

 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 Follow up:

 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode c = head;
        ListNode t = null;
        while(c!=null){
            t = c.next;
            c.next = res;
            res = c;
            c = t;
        }
        return res;

    }

    // Reverse Linked List
    // Time Complexity: O(n), Space Complexity: O(n)
    public class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode tail = head.next;
            head.next = null;
            ListNode newHead = reverseList(tail);
            tail.next = head;

            return newHead;
        }
    }
}
