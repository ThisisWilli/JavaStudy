package com.coding.sword2nd.tree.buildtree07;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.buildtree07
 * \* author: Willi Wei
 * \* date: 2020-06-29 09:16:40
 * \* description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int preStart = 0, preEnd = preorder.length - 1, inStart = 0, inEnd = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]){
                root.left = helper(preorder, inorder, inStart, i - 1, preStart + 1, preStart + (i - inStart));
                root.right = helper(preorder, inorder, i + 1, preorder.length - 1, preStart + i - inStart + 1, preEnd);
                break;
            }
        }
        return root;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd){
        // 终止条件
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
}