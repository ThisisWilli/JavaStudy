package com.study.basicalgorithm.tree.inorder;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.basicalgorithm.tree.inorder
 * \* author: Willi Wei
 * \* date: 2020-06-24 10:45:41
 * \* description:
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * \
 */


public class InOrderRecursion {
    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    public void helper(TreeNode root){
        if (root == null){
            return;
        }

        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}