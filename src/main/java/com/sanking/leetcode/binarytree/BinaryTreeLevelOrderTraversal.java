package com.sanking.leetcode.binarytree;

import com.sanking.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanking on 12/18/2018.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int level){
        if(root == null){
            return ;
        }
        add(list, level, root.val);
        dfs(root.left, list, level+1);
        dfs(root.right, list, level+1);
    }

    public void add(List<List<Integer>> list, int level, int value){
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        List<Integer> l = list.get(level);
        l.add(value);
    }




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
