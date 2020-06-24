package com.coding.sword2nd.tree.mirrortree27;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.mirrortree27
 * \* author: Willi Wei
 * \* date: 2020-06-24 09:24:59
 * \* description:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}