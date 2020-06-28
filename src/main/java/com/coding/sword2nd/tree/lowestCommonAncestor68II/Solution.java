package com.coding.sword2nd.tree.lowestCommonAncestor68II;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.lowestCommonAncestor68II
 * \* author: Willi Wei
 * \* date: 2020-06-28 10:20:12
 * \* description:
 *  给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 *  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *  示例 1:
 *  输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *  输出: 3
 *  解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *  示例 2:

 *  输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *  输出: 5
 *  解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *   
 *  说明:
 *  所有节点的值都是唯一的。
 *  p、q 为不同节点且均存在于给定的二叉树中。
 * \
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.addLast(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = queue.pollFirst();
            if (node.left != null){
                parent.put(node.left, node);
                queue.addLast(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                queue.addLast(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }


}