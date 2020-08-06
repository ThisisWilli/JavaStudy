package com.coding.leetcode.dp.coinchange322;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-16 09:34
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * 图解题解https://www.pythonf.cn/read/100808
 */
public class Solution {
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != amount + 1){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == amount + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }


        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], amount + 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++){
            for (int j = 1; j <= amount; j++){
                if (j >= coins[i- 1]){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        // https://zhuanlan.zhihu.com/p/121837186
        if (dp[coins.length][amount] >= amount + 1){
            return -1;
        }else {
            return dp[coins.length][amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1}, 1));
    }
}

