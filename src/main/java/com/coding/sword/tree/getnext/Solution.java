package com.coding.sword.tree.getnext;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.getnext
 * \* author: Willi Wei
 * \* date: 2020-01-10 11:20:48
 * \* description:给定一个二叉树和其中一个节点，请找出中序遍历顺序的下一个节点并且返回，
 *                注意：树中的节点不仅包括左右子结点，同时包含指向父结点的指针
 * \
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 三种情况：
     * 1.如果该节点有右子树，那么它下一个返回的节点是右子树中的最左节点
     * 2.如果该节点没有右子树
     *      2.1、如果节点是它父结点的左子节点，那么下一个节点就是它的父结点
     *      2.2、如果节点机没有右子树，而且它还是父节点的右子节点，则要沿着这个节点的父子节点向上遍历，直到找到它父子节点的左子
     *          节点的节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode next = null;
        // 只是对单个节点进行分析，不需要进行递归，三种情况开始分析
        if (pNode == null){
            return null;
        }
        // 如果这个节点有右子树，那么它的下一个节点就是它右子树的最左节点
        if (pNode.right != null){
            next = pNode.right;
            while (next.left != null){
                next = next.left;
            }
            return next;
        }else if (pNode.next != null){
            // 这个节点的左子树节点一定在这个节点的中序遍历的前面，所以不需要考虑左子树的节点
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            // 如果这个节点是其父结点的右节点，那么向上遍历，找到一个父结点是其父结点的左节点，返回其父结点的父结点
            while (pParent!= null && pCurrent == pParent.right){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            // 如果这个节点是其父结点的左子节点，那么直接返回其父结点
            next = pParent;
        }
        return next;
    }
}