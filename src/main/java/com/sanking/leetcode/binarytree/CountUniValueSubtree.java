package com.sanking.leetcode.binarytree;

import com.sanking.leetcode.util.TreeNode;

/**
 Count Univalue Subtrees

 Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,

 5
 / \
 1   5
 / \   \
 5   5   5
 return 4.
 */
public class CountUniValueSubtree {

    public int countUniValSubtrees(TreeNode root){
        Integer count = 0 ;
        count(root, count);
        return count;
    }

    private void count( TreeNode root, Integer count ){

        boolean leftSame = true;
        boolean rightSame = true;
        if(root.left != null){
            leftSame = root.val == root.left.val;
            count(root.left, count);
        }
        if(root.right != null){
            rightSame = root.val == root.right.val;
            count(root.right, count);
        }

        if(leftSame && rightSame){
            count++;
        }
    }



}
