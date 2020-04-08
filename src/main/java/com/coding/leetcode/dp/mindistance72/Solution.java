package com.coding.leetcode.dp.mindistance72;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-06 09:09
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * |      | ' '  | r    | o    | s    |
 * | ---- | ---- | ---- | ---- | ---- |
 * | ' '  | 0    | 1    | 2    | 3    |
 * | h    | 1    | 1    | 2    | 3    |
 * | o    | 2    | 2    | 1    | 2    |
 * | r    | 3    | 2    | 2    | 2    |
 * | s    | 4    | 3    | 3    | 2    |
 * | e    | 5    | 4    | 4    | 3    |
 **/

/**
 * dp[i][j]表示 word1的第i个字母转换成word2的第j个字母所用的最少操作
 * dp[i][j] = min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1
 *
 * dp[i-1][j] 表示删除
 * dp[i][j-1] 表示插入操作
 * dp[i-1][j-1] 表示替换操作
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] cost = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= word1.length(); i++){
            cost[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++){
            cost[0][i] = i;
        }

        for (int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    cost[i][j] = cost[i - 1][j - 1];
                }else {
                    cost[i][j] = Math.min(Math.min(cost[i-1][j], cost[i][j-1]), cost[i-1][j-1]) + 1;
                }
            }
        }
        return cost[l1][l2];
    }
}
