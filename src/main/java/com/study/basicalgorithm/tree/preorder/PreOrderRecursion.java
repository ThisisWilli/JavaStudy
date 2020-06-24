package com.study.basicalgorithm.tree.preorder;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.basicalgorithm.tree.preorder
 * \* author: Willi Wei
 * \* date: 2020-06-24 14:06:18
 * \* description:
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class PreOrderRecursion {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}