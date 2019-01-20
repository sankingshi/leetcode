package com.sanking.leetcode.binarytree;

import com.sanking.leetcode.util.TreeNode;

/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        return findPath(root, sum, 0);
    }

    private boolean findPath(TreeNode root, int sum, int s){

        if(root == null){
            return false;
        }

        s+= root.val;

        if( root.left == null && root.right==null && s==sum ){
            return true;
        } else {
            return findPath(root.left, sum, s) || findPath(root.right, sum, s) ;
        }

    }
}
