package com.coding.sword2nd.tree.pathsum34;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.pathsum34
 * \* author: Willi Wei
 * \* date: 2020-06-29 09:35:59
 * \* description:
 * \输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        dfs(root, sum, 0, result, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int sum, int currentSum, List<List<Integer>> result, List<Integer> temp){
        if (currentSum + root.val == sum){
            if (root.left == null && root.right == null){
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }else {
                return;
            }
        }

        temp.add(root.val);
        if (root.left != null){
            dfs(root.left, sum, currentSum + root.val, result, temp);
        }
        if (root.right != null){
            dfs(root.right, sum, currentSum + root.val, result, temp);
        }
        temp.remove(temp.size() - 1);
    }
}