package com.coding.sword2nd.tree.issymmetric28;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.issymmetric28
 * \* author: Willi Wei
 * \* date: 2020-06-28 13:32:14
 * \* description:
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
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
     * 通过两种前序遍历的方式对二叉树进行遍历，但是要考虑二叉树结点为null的情况
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            result.addLast(node.val);
            // 说明是空结点
            if (node.val == Integer.MIN_VALUE){
                continue;
            }

            if (node.right != null){
                stack.addLast(node.right);
            }else {
                stack.addLast(new TreeNode(Integer.MIN_VALUE));
            }

            if (node.left != null){
                stack.addLast(node.left);
            }else {
                stack.addLast(new TreeNode(Integer.MIN_VALUE));
            }
        }

        stack.clear();
        stack.addLast(root);
        int i = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if (result.get(i) != node.val){
                return false;
            }
            i++;
            if (node.val == Integer.MIN_VALUE){
                continue;
            }

            if (node.left != null){
                stack.addLast(node.left);
            }else {
                stack.addLast(new TreeNode(Integer.MIN_VALUE));
            }

            if (node.right != null){
                stack.addLast(node.right);
            }else {
                stack.addLast(new TreeNode(Integer.MIN_VALUE));
            }
        }

        return true;
    }

    public boolean isSymmetric2(TreeNode root){
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}