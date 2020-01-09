package com.coding.sword.tree.verifySquenceOfBST;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.verifySquenceOfBST
 * \* author: Willi Wei
 * \* date: 2020-01-09 15:22:30
 * \* description:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果，假设输入的数组的任意两个数字互不相同
 *                二叉搜索树：根节点大于左节点，小于右节点
 * \
 */
public class Solution {
    /**
     * 后续遍历的合法序列是，对于一个序列S，最后一个元素是根，去掉根这个元素的序列为T，T满足：T可以分成两段，前一段左子树小于x，后一段
     * 右子树大于x，并且这两端子树都是合法的后序序列====>完美符合递归定义
     * 注意：去掉根节点的右子树的根节点比所有的左子树节点都要大
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }
    private boolean helper(int[] sequence, int start, int end){
        // end是根节点的坐标
        if (start >= end){
            return true;
        }
        int root = sequence[end];
        int i;
        for (i = start ;i < end; i++){
            // 先遍历左子树，知道左子树最后一个节点
            if (sequence[i] > root){
                break;
            }
        }
        // i处在右子树序列的开端
        for (int j = i; j < end;j++){
            // 右子树中每个节点必须都大于根节点，若出现小于根节点的，则错误
            if (sequence[j] < root){
                return false;
            }
        }
        return helper(sequence, start, i - 1) && helper(sequence, i, end - 1);
    }
}