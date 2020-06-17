package com.coding.leetcode.math.numsquares279;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.math.numsquares279
 * \* author: Willi Wei
 * \* date: 2020-06-16 09:04:25
 * \* description:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * \
 */
public class Solution {
    public int numSquares(int n) {
        int[]dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareIndex = (int)Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];

        for (int i = 1; i < maxSquareIndex; i++){
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++){
            for (int s = 1; s < maxSquareIndex; s++){
                if (i < squareNums[s]){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(25));
    }
}