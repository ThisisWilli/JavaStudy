package com.coding.leetcode.tree.levelorder102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.levelorder102
 * \* author: Willi Wei
 * \* date: 2020-05-13 08:59:32
 * \* description:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * \
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        int lastLayer = 1, currentLayer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node = list.pollFirst();
            temp.add(node.val);
            lastLayer--;
            if (node.left != null){
                list.offer(node.left);
                currentLayer++;
            }

            if (node.right != null){
                list.offer(node.right);
                currentLayer++;
            }

            if (lastLayer == 0){
                results.add(new ArrayList<Integer>(temp));
                temp.clear();
                lastLayer = currentLayer;
                currentLayer = 0;
            }
        }
        return results;
    }
}