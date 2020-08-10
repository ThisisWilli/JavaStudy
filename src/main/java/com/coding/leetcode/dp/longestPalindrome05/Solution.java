package com.coding.leetcode.dp.longestPalindrome05;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dp.longestPalindrome05
 * \* author: Willi Wei
 * \* date: 2020-08-10 18:48:56
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
 * 通过次数341,228提交次数1,087,066
 * \
 */
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String result = "";
        for (int l = 0; l < length; l++){
            for (int i = 0; i + l < length; i++){
                int j = l + i;
                if (i == j){
                    dp[i][j] = true;
                }else if (j - i == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }

                if (j - i + 1 > result.length() && dp[i][j]){
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}