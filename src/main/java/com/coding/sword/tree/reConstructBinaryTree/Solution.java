package com.coding.sword.tree.reConstructBinaryTree;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.reConstructBinaryTree
 * \* author: Willi Wei
 * \* date: 2020-01-02 15:40:19
 * \* description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 *                前序遍历：根节点，左子树，右子树
 *                中序遍历：左子树，根节点，右子树
 *                后序遍历：左子树，右子树，根节点
 *
 *                采用递归解题
 * \
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        return constructBinaryTree(pre, in);
        return constructBinaryTree2(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    private TreeNode constructBinaryTree(int[] pre, int[] in){
        // 通过先序遍历确定根节点的位置
        if (pre.length != 0){
            TreeNode root = new TreeNode(pre[0]);
            int loc = -1;
            for (int i = 0;i < pre.length; i++){
                // 在中序遍历中找到根几点的位置
                if (in[i] == root.val){
                    loc = i;
                    break;
                }
            }
            int[] preLeft = Arrays.copyOfRange(pre, 1, 1 + loc);
            int[] inLeft = Arrays.copyOfRange(in, 0, loc);
            int[] preRight = Arrays.copyOfRange(pre, 1 + loc, pre.length);
            int[] inRight = Arrays.copyOfRange(pre, 1 + loc, in.length);
            if (loc != -1){
                root.left = constructBinaryTree(preLeft, inLeft);
                root.right = constructBinaryTree(preRight, inRight);
                return root;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    private TreeNode constructBinaryTree2(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn){
        // 通过先序遍历确定根节点的位置
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn;i <= endIn; i++){
            // 在中序遍历中找到根几点的位置
            if (in[i] == root.val){
                root.left = constructBinaryTree2(pre, in, startPre + 1,  startPre + i - startIn, startIn, i - 1);
                // i - startIn为左子树元素的长度， +1表示取出根元素
                root.right = constructBinaryTree2(pre, in, i - startIn + startPre + 1, endPre, 1 + i, endIn);
            }
        }
//            int[] preLeft = Arrays.copyOfRange(pre, 1, 1 + loc);
//            int[] inLeft = Arrays.copyOfRange(in, 0, loc);
//            int[] preRight = Arrays.copyOfRange(pre, 1 + loc, pre.length);
//            int[] inRight = Arrays.copyOfRange(pre, 1 + loc, in.length);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(new Solution().reConstructBinaryTree(pre, in).left.val);
    }
}