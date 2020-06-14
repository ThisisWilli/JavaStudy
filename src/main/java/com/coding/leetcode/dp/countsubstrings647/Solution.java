package com.coding.leetcode.dp.countsubstrings647;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dp.countsubstrings647
 * \* author: Willi Wei
 * \* date: 2020-06-14 11:03:26
 * \* description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * 输入的字符串长度不会超过1000。
 * \
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int result = n;
        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}