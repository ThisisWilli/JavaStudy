package com.coding.sword.tree.findpath;

import java.util.ArrayList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.findpath
 * \* author: Willi Wei
 * \* date: 2020-01-11 16:14:19
 * \* description:输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值得和为输入整数得所有路径，路径定义为从树得根节点开始往下一直到
 *                叶结点所经过得结点形成一条路径，在返回得list中，数组长度大得整数靠前
 * \
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {

    private void preFindPath(TreeNode node, int sum, int target, ArrayList<Integer>temp, ArrayList<ArrayList<Integer>> result){
        // 如果节点为空，则向上返回
        if (node == null){
            return;
        }
        // 如果节点值和之前的sum相加等于target，则将temp添加进result，并向上返回
        if (node.val + sum == target){
            if (node.left == null && node.right == null){
                temp.add(node.val);
                // 此处注意一定要重新创建一个list，如果只是将temp传进去，那么之后temp还是原来哪个temp的引用，后续操作会影响result中的值
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }else {
                // 如果节点下面还有节点，说明这条路径不对，向上返回
                return;
            }
        }
        // 如果节点值加之前的值小于target，则继续向下寻找
        if (node.val + sum < target){
            temp.add(node.val);
            if (node.left == null && node.right == null){
                // 节点无左右子🌲，则去除这个节点的值向上返回
                temp.remove(temp.size() - 1);
                return;
            }
            if (node.left != null && node.right != null){
                preFindPath(node.left, sum + node.val, target, temp, result);
                preFindPath(node.right, sum + node.val, target, temp, result);
                // 找遍左右子🌲还是没有结果，去除这个节点的值向上返回
                temp.remove(temp.size() - 1);
                return;
            }
            if (node.left != null && node.right == null){
                preFindPath(node.left, sum + node.val, target, temp, result);
                temp.remove(temp.size() - 1);
                return;
            }
            if (node.left == null && node.right != null){
                preFindPath(node.right, sum + node.val, target, temp, result);
                temp.remove(temp.size() - 1);
                return;
            }
        }
        if (node.val + sum > target){
            return;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        preFindPath(root, 0, target, temp, results);
        return results;
    }
}