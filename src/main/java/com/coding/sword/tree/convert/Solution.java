package com.coding.sword.tree.convert;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-14 09:41
 **/

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/***
 * 题干：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：对二叉树进行中序遍历，将左子树中最大的节点与跟节点相连，右子树最小的节点与根节点相连
 */
public class Solution {
    private TreeNode lastNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ConvertNode(pRootOfTree);
        TreeNode p = lastNode;
        // 每个节点的前一个节点要与其后一个节点进行连接
        while (p.left != null){
            p.left.right = p;
            p = p.left;
        }
        return p;
    }

    private void ConvertNode(TreeNode node){
        // 若为空，则直接返回
        if (node == null){
            return;
        }
        // 用currentNode当前节点
        // 向下遍历左子树
        if (node.left != null){
            ConvertNode(node.left);
        }
        // 左子树遍历完了，则将currentNode的左节点指向lastNode, 特殊情况为遍历到最左边的子树时，lastNode还一直为null
        node.left = lastNode;
        // 若lastNode不为空，则将lastNode的右节点指向currentNode
        if (lastNode != null){
            lastNode.right = node;
        }
        // 再将currentNode指向lastNode，这里最终将指向最后节点
        lastNode = node;
        // 最后对右子树进行操作，lastNode最终将指向最右边的节点，也就是最大的节点
        if (node.right != null){
            ConvertNode(node.right);
        }
    }
}
