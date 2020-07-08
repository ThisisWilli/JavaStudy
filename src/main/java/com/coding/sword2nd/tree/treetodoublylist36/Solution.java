package com.coding.sword2nd.tree.treetodoublylist36;

import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.treetodoublylist36
 * \* author: Willi Wei
 * \* date: 2020-07-08 20:08:27
 * \* description:
 * \
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node curr){
        if (curr == null){
            return;
        }
        dfs(curr.left);
        if (pre != null){
            pre.right = curr;
        }else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        dfs(curr.left);
    }
}