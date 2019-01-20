package com.sanking.leetcode.binarytree;

import com.sanking.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left, root.right);
    }
    private boolean isSame(TreeNode left, TreeNode right){
        if( left == right ){
            return true;
        }
        if( left!=null && right!=null &&left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left) ){
            return true;
        }
        return false;
    }

    public boolean isSymmetric_Iterative(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if( t1 == null && t2 == null ){
                continue;
            } else if (t1 == null || t2 == null){
                return false;
            } else if( t1.val != t2.val){
                return false;
            } else {
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
        }
        return true;
    }



}
