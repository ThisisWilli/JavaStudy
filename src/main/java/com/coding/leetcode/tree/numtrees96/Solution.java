package com.coding.leetcode.tree.numtrees96;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.numtrees96
 * \* author: Willi Wei
 * \* date: 2020-07-16 16:13:36
 * \* description:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * \
 * 1 3 2
 * 1 2 3
 *
 */
public class Solution {
    /**
     * 二叉搜索树，不是一般的二叉树
     * @param n
     * @return
     */
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}