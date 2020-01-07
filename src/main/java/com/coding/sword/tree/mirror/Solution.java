package com.coding.sword.tree.mirror;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.mirror
 * \* author: Willi Wei
 * \* date: 2020-01-07 14:58:33
 * \* description:操作给定的二叉树，将其变换为源二叉树的镜像
 * \
 */
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left != null || root.right != null){
            TreeNode temp = new TreeNode(0);
            temp.left = root.left;
            temp.right = root.right;
            root.left = temp.right;
            root.right = temp.left;
            temp = null;
            Mirror(root.left);
            Mirror(root.right);
        }else {
            return;
        }
    }
}