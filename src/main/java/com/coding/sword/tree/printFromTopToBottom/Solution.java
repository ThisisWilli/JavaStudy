package com.coding.sword.tree.printFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.printFromTopToBottom
 * \* author: Willi Wei
 * \* date: 2020-01-09 15:04:27
 * \* description:从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * \
 */
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 采用层次遍历的方法解题
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            // 取出队头元素
            TreeNode head = queue.remove();
            result.add(head.val);
            if (head.left != null){
                queue.add(head.left);
            }
            if (head.right != null){
                queue.add(head.right);
            }
        }
        return result;
    }
}