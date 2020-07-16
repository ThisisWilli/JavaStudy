package com.coding.leetcode.tree.issymmetric101;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.issymmetric101
 * \* author: Willi Wei
 * \* date: 2020-07-16 16:50:55
 * \* description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null){
            return true;
        }else if (r1 == null || r2 == null){
            return false;
        }else if (r1.val == r2.val){
            return judge(r1.left, r2.right) && judge(r1.right, r2.left);
        }else {
            return false;
        }
    }
}