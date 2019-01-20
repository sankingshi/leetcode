package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode res = root;
        while( true ){

            if(l1==null && l2==null){
                break;
            } else if( l1==null){
                res.next = l2;
                break;
            } else if( l2 == null){
                res.next = l1;
                break;
            } else {

                if(l1.val < l2.val){
                    res.next = l1;
                    l1 = l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }

        }

        return root.next;

    }
}
