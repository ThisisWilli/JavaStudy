package com.coding.leetcode.tree.invalidbst98;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.invalidbst98
 * \* author: Willi Wei
 * \* date: 2020-05-05 09:21:08
 * \* description:
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    // 中序遍历解题目，最后的序列一定是升序序列
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if (!isValidBST(root.left)){
            return false;
        }

        if (root.val <= pre){
            return false;
        }

        pre = root.val;
        return isValidBST(root.right);
    }

}