package com.study.basicalgorithm.tree.preorder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.basicalgorithm.tree.preorder
 * \* author: Willi Wei
 * \* date: 2020-06-24 14:09:45
 * \* description:
 * \
 */
public class PreOrderInteration {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return result;
        }

        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            result.add(node.val);
            if (node.right != null){
                stack.addLast(node.right);
            }
            if (node.left != null){
                stack.addLast(node.left);
            }
        }
        return result;
    }
}