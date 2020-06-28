package com.coding.sword2nd.tree.levelorder32III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.levelorder32III
 * \* author: Willi Wei
 * \* date: 2020-06-28 09:37:22
 * \* description:
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
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
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        int currentLayerNodeNum = 1, nextLayerNodeNum = 0;
        boolean leftOrRight = true;
        queue.addLast(root);
        LinkedList<Integer> layerNodes = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if (leftOrRight){
                layerNodes.addLast(node.val);
            }else {
                layerNodes.addFirst(node.val);
            }

            currentLayerNodeNum--;

            if (node.left != null){
                queue.addLast(node.left);
                nextLayerNodeNum++;
            }
            if (node.right != null){
                queue.addLast(node.right);
                nextLayerNodeNum++;
            }

            if (currentLayerNodeNum == 0){
                result.add(new ArrayList<>(layerNodes));
                layerNodes.clear();
                currentLayerNodeNum = nextLayerNodeNum;
                nextLayerNodeNum = 0;
                leftOrRight = !leftOrRight;
            }
        }

        return result;
    }
}