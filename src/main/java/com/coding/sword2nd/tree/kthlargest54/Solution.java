package com.coding.sword2nd.tree.kthlargest54;

import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.kthlargest54
 * \* author: Willi Wei
 * \* date: 2020-06-24 09:33:07
 * \* description:
 * 给定一棵二叉搜索树，请找出其中第k大的节点。

 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 中序遍历： 1 2 3 4 5 6
 * 限制
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
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
     * 使用迭代的方法解题
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.offerLast(curr);
                curr = curr.right;
            }
            curr = stack.pollLast();
            if (--k == 0){
                return curr.val;
            }
            curr = curr.left;
        }
        return 0;
    }
}