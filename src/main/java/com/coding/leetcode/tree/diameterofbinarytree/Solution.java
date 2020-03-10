package com.coding.leetcode.tree.diameterofbinarytree;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-10 09:37
 **/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class Solution {
    private int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        // 直径的路径不一定经过根节点
        // 先计算一个树的两个树的子树高度加上自身高度是否大于最大值，如果大于，则改变最大值的值，并返回最大子树的层数给上一层
        getDiameter(root);
        return result;
    }
    private int getDiameter(TreeNode root){
        int leftHeight = 0, rightHeight = 0;
        if (root.left == null && root.right == null){
            return 0;
        }
        if (root.left != null && root.right == null){
            leftHeight = getDiameter(root.left) + 1;
        }
        if (root.left == null && root.right != null){
            rightHeight = getDiameter(root.right) + 1;
        }
        if (root.left != null && root.right != null){
            leftHeight = getDiameter(root.left) + 1;
            rightHeight = getDiameter(root.right) + 1;
        }
        if (leftHeight + rightHeight  > result){
            result = leftHeight + rightHeight;
        }
        return Math.max(leftHeight, rightHeight);
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        result = Math.max(leftDepth + rightDepth, result);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
