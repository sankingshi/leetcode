package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null ) return head;

        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = head;
        ListNode pre = root;
        ListNode c = head;

        while(c != null){

            if(c.next == null ){
                break;
            } else if( c.next.val != c.val){
                pre = c;
                c = c.next;
                continue;
            } else {
                int v = c.val;
                while(c!=null && c.val == v ){
                    pre.next = c.next;
                    c.next = null;
                    c = pre.next;
                }
            }
        }

        return root.next;
    }

}

class RemoveDuplicatesfromSortedListII_1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null || head.next == null) return head;

        ListNode p = head.next;
        if (head.val == p.val) {
            while (p != null && head.val == p.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
