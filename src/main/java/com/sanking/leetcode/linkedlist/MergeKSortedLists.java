package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeLists(lists, 0, lists.length-1);
    }

    private ListNode mergeLists(ListNode[] lists, int l, int h ){
        if(l==h){
            return lists[l];
        } else if(l+1==h){
            return merge2Lists(lists[l], lists[h]);
        } else {
            return merge2Lists(
                    mergeLists(lists, l, (h-l)/2 + l),
                    mergeLists(lists, (h-l)/2 + l + 1, h)
            );
        }
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){

        if( l1 == null && l2 == null){
            return null;
        } else if (l1== null){
            return l2;
        } else if (l2==null){
            return l1;
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode current = result;
        while( true){

            if( l1.val <= l2.val ){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;

            if( l1 == null ){
                current.next = l2;
                break;
            }
            if( l2 == null){
                current.next = l1;
                break;
            }
        }
        return result.next;
    }

}
