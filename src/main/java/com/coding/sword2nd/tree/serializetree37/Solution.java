package com.coding.sword2nd.tree.serializetree37;

import sun.java2d.pipe.SpanClipRenderer;

import java.io.IOException;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.serializetree37
 * \* author: Willi Wei
 * \* date: 2020-06-29 10:41:19
 * \* description:
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }

        StringBuilder res = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                res.append("null,");
            }
        }

        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)){
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!"null".equals(vals[i])){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;

            if (!"null".equals(vals[i])){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}