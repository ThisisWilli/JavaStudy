package com.coding.sword.tree.isbalancetree;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-06 09:26
 **/

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        return true;
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }
}
