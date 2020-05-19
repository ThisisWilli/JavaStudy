package com.coding.leetcode.string.validpalindrome680;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.string.validpalindrome680
 * \* author: Willi Wei
 * \* date: 2020-05-19 09:07:49
 * \* description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * \
 */
public class Solution {
    /**
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right){
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (leftC == rightC){
                left++;
                right--;
            }else {
                boolean l = true, r = true;
                // 删除左边元素
                for (int i = left + 1, j = right; i < j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        l = false;
                        break;
                    }
                }
                // 删除右边元素

                for (int i = left, j = right - 1; i < j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        r = false;
                        break;
                    }
                }
                return l || r;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abca"));
    }
}