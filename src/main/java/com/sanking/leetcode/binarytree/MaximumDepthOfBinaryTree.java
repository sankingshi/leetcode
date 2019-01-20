package com.sanking.leetcode.binarytree;

import com.sanking.leetcode.util.TreeNode;

/**
 * Created by Sanking on 12/18/2018.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return nodeDepth(root);
    }

    private int nodeDepth(TreeNode root){
        if( root == null )
        {
            return 0 ;
        } else {
            return Math.max(nodeDepth(root.left), nodeDepth(root.right)) + 1;
        }
    }
}
