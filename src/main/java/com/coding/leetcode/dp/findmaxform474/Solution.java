package com.coding.leetcode.dp.findmaxform474;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dp.findmaxform474
 * \* author: Willi Wei
 * \* date: 2020-08-05 19:22:18
 * \* description:
 *
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * 注意:
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 * \
 */
public class Solution {
    /**
     * 把总的0和1的个数视为背包的容量，把每个字符串十位装进背包的物品
     * dp[i][j][k] 表示输入字符串在子区间[0, i]能够使用j个0和k个1的字符串的最大数量
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++){
            int[] cnt = countZeroAnOne(strs[i - 1]);
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = cnt[0];
                    int ones = cnt[1];

                    if (j >= zeros && k >= ones){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] countZeroAnOne(String str){
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0", "1"};
        System.out.println(new Solution().findMaxForm(strs, 1, 1));
    }
}