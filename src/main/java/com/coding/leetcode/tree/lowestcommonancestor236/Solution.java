package com.coding.leetcode.tree.lowestcommonancestor236;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.lowestcommonancestor236
 * \* author: Willi Wei
 * \* date: 2020-05-10 09:45:04
 * \* description:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
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
     * 记录下每个节点的父结点，
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        dfs(root, fatherMap);
        ArrayList<TreeNode> visited = new ArrayList<>();
        while (p != null){
            visited.add(p);
            p = fatherMap.get(p);
        }
        while (q != null){
            if (visited.contains(q)){
                return q;
            }else {
                q = fatherMap.get(q);
            }
        }
        return null;
    }

    private void dfs(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap){
        if (root.left != null){
            fatherMap.put(root.left, root);
            dfs(root.left, fatherMap);
        }
        if (root.right != null){
            fatherMap.put(root.right, root);
            dfs(root.right, fatherMap);
        }
    }
}