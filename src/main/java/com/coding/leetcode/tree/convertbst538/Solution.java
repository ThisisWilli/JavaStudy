package com.coding.leetcode.tree.convertbst538;

import jdk.internal.org.objectweb.asm.util.CheckFieldAdapter;

import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.convertbst538
 * \* author: Willi Wei
 * \* date: 2020-05-28 13:33:29
 * \* description:
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /**
     * 前提为二叉搜索树，最右边的结点最大，左子树的结点小于其父结点
     * @param root
     * @return
     */
    int max = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root){

        if (root == null){
            return;
        }
        helper(root.right);
        int temp = root.val;
        root.val += max;
        max += temp;
        helper(root.left);
    }

    public static void main(String[] args) {

    }
}