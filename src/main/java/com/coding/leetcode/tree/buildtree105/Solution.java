package com.coding.leetcode.tree.buildtree105;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.buildtree105
 * \* author: Willi Wei
 * \* date: 2020-05-22 09:00:23
 * \* description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution {
    /**
     * pre用来区分哪个是头节点，然后再preorder中确认头节点的位置，节点前面部分为左子树，节点后面为右子树
     * @param preorder
     * @param inorder
     * @return
     * 1、先确定左右子树的长度，也就是区间，再从区间中寻找子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int preStart = 0, preEnd = preorder.length - 1, inStart = 0, inEnd = inorder.length - 1;
        TreeNode result = new TreeNode(preorder[preStart]);
        for(int i = inStart; i <= inEnd; i++){
            // 找到第一个根节点
            if(inorder[i] == preorder[preStart]){
                // 左子树长度
                int leftLen = i - inStart;
                //                                     先序序列               中序序列
                result.left = helper(preorder, inorder, preStart + 1, preStart + leftLen, inStart, i - 1);
                result.right = helper(preorder, inorder, preStart + leftLen + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return result;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (inStart > inEnd || preStart > preEnd){
            return null;
        }
        TreeNode result = new TreeNode(preorder[preStart]);
        for(int i = inStart; i <= inEnd; i++){
            // 找到第一个根节点
            if(inorder[i] == preorder[preStart]){
                // 左子树长度
                int leftLen = i - inStart;
                //                                     先序序列               中序序列
                result.left = helper(preorder, inorder, preStart + 1, preStart + leftLen, inStart, i - 1);
                result.right = helper(preorder, inorder, preStart + leftLen + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode result = new Solution().buildTree(preOrder, inOrder);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}