package com.coding.sword2nd.tree.flatten114;

import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.flatten114
 * \* author: Willi Wei
 * \* date: 2020-07-17 19:15:24
 * \* description:
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    /**
     * 采用先序遍历的方法
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode dummy = new TreeNode();
        dummy.right = root;
        TreeNode pre = dummy, p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(p);
        while (!stack.isEmpty()){
            p = stack.pollLast();
            if (p.right != null){
                stack.addLast(p.right);
            }
            if (p.left != null){
                stack.addLast(p.left);
            }
            pre.right = p;
            p.left = null;
            pre = p;
        }
        root.left = null;
    }
}