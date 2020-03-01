package com.coding.sword.tree.kthnode;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-01 10:06
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
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 利用二叉搜索树的性质，中序遍历解题
 */
public class Solution {
    int count = 0;
    TreeNode result = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        preOrder(pRoot, k);
        return result;
    }

    private void preOrder(TreeNode root, int k){
        if (root == null){
            return;
        }
        preOrder(root.left, k);
        count++;
        if (count == k){
            result = root;
            return;
        }
        preOrder(root.right, k);
    }
}
