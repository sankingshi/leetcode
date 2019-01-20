package com.sanking.leetcode.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sanking on 12/18/2018.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    public static TreeNode generator(Integer[] array){

        TreeNode root = null;
        if(array == null || array.length < 1 || array[0] == null){
            return root;
        }
        Arrays.stream(array).forEach( System.out::println );

        root = new TreeNode(array[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        TreeNode t = null;
        int i = 0 ;
        Integer c = null;
        while(!treeNodes.isEmpty() && i<array.length ){
            t = treeNodes.poll();
            i++;
            if(i<array.length){
                c = array[i];
                if( c != null ){
                    t.left = new TreeNode(c);
                    treeNodes.offer(t.left);
                }
            }
            i++;
            if(i<array.length){
                c = array[i];
                if( c != null ){
                    t.right = new TreeNode(c);
                    treeNodes.offer(t.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args){
//        generator(new Integer[]{1, null, 2});
//        generator(new Integer[]{0,0,null,0,0});
//        generator(new Integer[]{0,0,null,0,null,0,null,null,0});

        generator(new Integer[]{0,0,null,0,null,0,null,null,0,2});
    }
}
