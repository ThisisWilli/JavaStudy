package com.coding.sword2nd.tree.levelorder32II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.levelorder32II
 * \* author: Willi Wei
 * \* date: 2020-06-28 09:19:31
 * \* description:
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 *   [9,20],
 *   [15,7]
 * ]
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
     * 采用层次遍历进行解题，每次记录下新的一层的节点数量
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        int currentLayerNodeNum = 1, nextLayerNodeNum = 0;
        queue.addLast(root);
        ArrayList<Integer> layerNodes = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            layerNodes.add(node.val);

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
            }
        }

        return result;
    }
}