package com.sanking.leetcode.queuestack;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**

 Given a binary tree, return the inorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [1,3,2]
 Follow up: Recursive solution is trivial, could you do it iteratively?

 */

/**
 Depth First Traversals:
 (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            // if the left has the node, add it into stack.
            if(node.left!=null ){
                stack.push(node.left);
                node.left = null;
            } else {
                // out stack
                stack.pop();
                result.add(node.val);

                if( node.right != null ) {
                    stack.push(node.right);
                    node.right = null;
                }
            }
        }
        return result;
    }

    public static List < Integer > inorderTraversal_2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversal_good(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        while(!s.isEmpty() || root!=null){
            // 遍历到最left
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            // 退出stack
            root=s.pop();
            // 存入结果
            res.add(root.val);
            //遍历right
            root=root.right;
        }
        return res;
    }

    /**
     *
     Approach 3: Morris Traversal
     In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:

     Step 1: Initialize current as root

     Step 2: While current is not NULL,

     If current does not have left child

     a. Add current’s value

     b. Go to the right, i.e., current = current.right

     Else

     a. In current's left subtree, make current the right child of the rightmost node

     b. Go to this left child, i.e., current = current.left
     * @param root
     * @return
     */
    public static List < Integer > inorderTraversal_MorrisTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


    private static  TreeNode testData(){
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        node1 = new TreeNode(4);
        node2.left = node1;
        node2 = new TreeNode(5);
        node1.right = node2;
        return root;
    }

    private static  TreeNode testData_1(){
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        node1 = new TreeNode(4);
        node2.left = node1;
        node2 = new TreeNode(5);
        node1.right = node2;
        return root;
    }

    private static  TreeNode generateTreeNode(int[] input){

        

        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        node1 = new TreeNode(4);
        node2.left = node1;
        node2 = new TreeNode(5);
        node1.right = node2;
        return root;
    }

    public static void main(String[] args){

//        System.out.println(BinaryTreeInorderTraversal_1.inorderTraversal(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));
//        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));
//        System.out.println(BinaryTreeInorderTraversal.inorderTraversal_good(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));

        System.out.println("------------------------------------------");
        System.out.println(BinaryTreePreorderTraversal.preorderTraversal_DFS(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));
//        System.out.println(BinaryTreePreorderTraversal.preorderTraversal(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));
//        System.out.println(BinaryTreePreorderTraversal.preorderTraversal_MorrisTraversal(testData()).stream().map(Object::toString).collect(Collectors.joining(",")));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class BinaryTreeInorderTraversal_1 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    public static List<Integer> preorderTraversal_DFS(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();

        while(!s.isEmpty() || root!=null){
            while(root!=null){
                res.add(root.val);
                s.push(root);
                if( root.left == null ){
                    break;
                } else {
                    root=root.left;
                }
            }
            // 退出stack
            root=s.pop();
            //遍历right
            root=root.right;
        }
        return res;
    }


    public static List < Integer > preorderTraversal_MorrisTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {

            res.add(curr.val);
            if (curr.left == null) {
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr.right; // put cur right after the pre node
                //TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                //temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}

class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
            res.add(root.val);
        }
    }

    public static List<Integer> postorderTraversal_DFS(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();

        while(!s.isEmpty() || root!=null){
            while(root!=null){
                res.add(root.val);
                s.push(root);
                if( root.left == null ){
                    break;
                } else {
                    root=root.left;
                }
            }
            // 退出stack
            root=s.pop();
            //遍历right
            root=root.right;
        }
        return res;
    }

}

