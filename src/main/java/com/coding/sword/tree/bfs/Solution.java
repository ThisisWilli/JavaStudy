package com.coding.sword.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-09 11:11
 **/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return result;
        }
        // 初始化队列及记录当前层数元素个数以及记录下一层元素个数的变量
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(pRoot);
        temp.add(pRoot.val);
        result.add(new ArrayList<>(temp));
        temp = new ArrayList<>();
        int thisLayer = 1, nextLayer = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if (node.left != null && node.right != null){
                queue.add(node.left);
                temp.add(node.left.val);
                queue.add(node.right);
                temp.add(node.right.val);
                thisLayer--;
                nextLayer += 2;
            }
            if (node.left != null && node.right == null){
                queue.add(node.left);
                temp.add(node.left.val);
                thisLayer--;
                nextLayer += 1;
            }
            if (node.left == null && node.right != null){
                queue.add(node.right);
                temp.add(node.right.val);
                thisLayer--;
                nextLayer += 1;
            }
            if (thisLayer == 0){
                result.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
                thisLayer = nextLayer;
                nextLayer = 0;
            }
        }
        return result;
    }
}
