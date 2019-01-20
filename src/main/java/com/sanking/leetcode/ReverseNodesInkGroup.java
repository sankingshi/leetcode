package com.sanking.leetcode;

import com.sanking.leetcode.util.ListNode;

import java.util.Stack;

/**
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<>();
        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = head;
        int i = 0 ;

        ListNode pre = root;
        ListNode current = head;
        ListNode blockStart = head;
        while(true){

            if(current == null){
                pre.next = blockStart;
                break;
            }

            // push node into stack
            stack.push(current);
            i++;
            // point to the next node
            current = current.next;

            if(i%k == 0 ){
                while( !stack.isEmpty() ){
                    pre.next = stack.pop();
                    pre = pre.next;
                }
                blockStart = current;
            }

        }
        return root.next;
    }

}
