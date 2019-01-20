package com.sanking.leetcode.linkedlist;

import com.sanking.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:

 Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> list = new LinkedList<>();

        ListNode node = head;
        while(true){
            list.add(node);
            if(node.next == null){
                break;
            } else {
                node = node.next;
            }
        }

        if( n == list.size() ){
            node = head.next;
            head.next = null;
            return node;
        } else if( n == 1){
            node = list.get(list.size()-2);
            node.next = null;
            return head;
        } else if( n < list.size()){
            int s = list.size() - n - 1;
            node = list.get(s);
            node.next = list.get(s+2);
            node = list.get(s+1);
            node.next = null;
            return head;
        } else {
            return head;
        }

    }


    //还是走的快的点(fastNode)与走得慢的点(slowNode)路程差的问题
    public static ListNode removeNthFromEnd_fast(ListNode head, int n) {
        ListNode headNode = new ListNode(9527);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while(fastNode.next != null){
            if(n <= 0)
                slowNode = slowNode.next;
            fastNode = fastNode.next;
            n--;
        }
        if(slowNode.next != null)
            slowNode.next = slowNode.next.next;
        return headNode.next;
    }
}
