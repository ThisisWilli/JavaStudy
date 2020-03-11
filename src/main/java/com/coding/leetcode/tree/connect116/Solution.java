package com.coding.leetcode.tree.connect116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-11 10:25
 **/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//初始状态下，所有 next 指针都被设置为 NULL。

public class Solution {
    // 利用广度优先遍历，记录当前层数，出队元素与队头元素相连
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int thisLayer = 1, nextLayer = 0;
        while (!queue.isEmpty()){
            // 取出队头元素
            Node node = queue.pollFirst();
            thisLayer--;
            if (node.left != null){
                queue.offerLast(node.left);
                nextLayer++;
            }
            if (node.right != null){
                queue.offerLast(node.right);
                nextLayer++;
            }
            // 如果等于0，说明是这一层的最后一个元素，next为null
            if (thisLayer != 0){
                node.next = queue.peekFirst();
            }else {
                // thisLayer = 0，说明一层已经遍历完
                node.next = null;
                thisLayer = nextLayer;
                nextLayer = 0;
            }
        }
        return root;
    }
}
