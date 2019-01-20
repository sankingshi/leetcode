package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Reverse a linked list from position m to n. Do it in one-pass.

 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:

 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null ) return head;

        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = head;
        int i = 0;
        ListNode mpre = root;
        ListNode reverse = null;
        ListNode c = head;
        ListNode t = null;
        ListNode reLast = head;
        while(c!=null){
            i++;
            if( i < m-1){
                c = c.next;
                continue;
            } else if( i == m-1 ){
                mpre = c;
                c = c.next;
                reLast = c;
                continue;
            } else if( i>=m && i <=n ){
                t = c.next;
                c.next = reverse;
                reverse = c;
                c = t;
                mpre.next = reverse;
            } else {
                reLast.next = c;
                break;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        System.out.println((new ReverseLinkedListII()).reverseBetween(ListNode.generateListNode(new int[]{1,2,3,4,5}), 2, 4));
    }


}
