package com.coding.leetcode.tree.inorderTraversal94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.inorderTraversal94
 * \* author: Willi Wei
 * \* date: 2020-07-16 16:03:59
 * \* description:
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * \
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }

            cur = stack.pollLast();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }
}