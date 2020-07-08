package com.coding.sword2nd.tree.verifypostorder33;

import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.verifypostorder33
 * \* author: Willi Wei
 * \* date: 2020-07-08 17:05:17
 * \* description:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * [1,2,5,10,6,9,4,3]
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0){
            return true;
        }
        // 根节点
        int root = postorder[postorder.length - 1];
        int leftStart = 0, leftEnd = 0, rightStart = 0, rightEnd = 0;
        for (int i = postorder.length - 2; i >= 0; i--) {
            // 先从后往前寻找右子树
            if (postorder[i] < root) {
                rightStart = i + 1;
                break;
            }
        }

        for (int i = rightStart - 1; i >= 0; i--) {
            if (postorder[i] > root){
                return false;
            }
        }

        leftEnd = rightStart - 1;
        rightEnd = postorder.length - 2;
        return helper(postorder, leftStart, Math.max(leftStart, leftEnd)) && helper(postorder, rightStart, Math.max(rightStart, rightEnd));

    }

    public boolean helper(int[] postorder, int start, int end){
        if (start == end){
            return true;
        }

        int root = postorder[end];
        int leftStart = start, leftEnd = start, rightStart = start, rightEnd = start;
        for (int i = end - 1; i >= start; i--){
            if (postorder[i] < root){
                rightStart = i + 1;
                break;
            }
        }

        for (int i = rightStart - 1; i >= 0; i--){
            if (postorder[i] > root){
                return false;
            }
        }
        leftEnd = rightStart - 1;
        rightEnd = end - 1;
        return helper(postorder, leftStart, Math.max(leftStart, leftEnd)) && helper(postorder, rightStart, Math.max(rightStart, rightEnd));
    }

    public boolean verifyPostorder2(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--){
            if (postorder[i] > root){
                return false;
            }
            while (!stack.isEmpty() && stack.peekLast() > postorder[i]){
                root = stack.pollLast();
            }
            stack.addLast(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
}