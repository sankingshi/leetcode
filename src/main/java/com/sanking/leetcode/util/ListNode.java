package com.sanking.leetcode.util;

/**
 * Created by Sanking on 12/28/2018.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }


    public static ListNode generateListNode(int[] values){
        ListNode head = new ListNode(0);
        ListNode next = head;
        for(int i : values){
            next.next = new ListNode(i);
            next = next.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        generateListNode(new int[]{1,2,3});
    }
}
