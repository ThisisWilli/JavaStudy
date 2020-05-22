package com.coding.leetcode.string.longestpalindrome5;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.string.longestpalindrome5
 * \* author: Willi Wei
 * \* date: 2020-05-21 08:48:18
 * \* description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * \
 */
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            // 第一轮循环进行的是，判断每个单个字符是不是回文子串，第一次判断长度为1的字符串是否为回文子串，第二次判断长度为2的子串是否为回文子串
            // i+ l是判断是否溢出的
            for (int i = 0; i + l < n; i++){
                int j = i + l;
                if (i == j){
                    dp[i][j] = true;
                }else if (l == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && l + 1> ans.length()){
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abba"));
    }
}