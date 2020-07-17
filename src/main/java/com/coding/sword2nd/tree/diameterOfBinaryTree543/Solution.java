package com.coding.sword2nd.tree.diameterOfBinaryTree543;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.diameterOfBinaryTree543
 * \* author: Willi Wei
 * \* date: 2020-07-17 19:55:59
 * \* description:
 * \
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        helper(root);
        return result;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        result = Math.max(left + right, result);
        return Math.max(left + 1, right + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}