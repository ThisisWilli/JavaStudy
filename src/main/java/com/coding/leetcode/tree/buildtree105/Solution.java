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
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int preStart = 0, preEnd = preorder.length - 1, inStart = 0, inEnd = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]){
                // inorder中[0, i - 1] 为左子树区间，[i + 1, in.length - 1]为右子树区间
                root.left = helper(preorder, inorder, inStart, i - 1, preStart + 1, preStart + (i - inStart));
                root.right = helper(preorder, inorder, i + 1, preorder.length - 1, preStart + i - inStart + 1, preEnd);
                break;
            }
        }
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd){
        if (inStart > inEnd || preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]){
                root.left = helper(preorder, inorder, inStart, i - 1, preStart + 1, preStart + (i - inStart));
                root.right = helper(preorder, inorder, i + 1, inEnd, preStart + i - inStart + 1, preEnd);
                break;
            }
        }
        return root;
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