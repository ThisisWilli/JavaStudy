package com.coding.sword2nd.slidewindow.lengthoflongestsubstring48;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.slidewindow.lengthoflongestsubstring48
 * \* author: Willi Wei
 * \* date: 2020-07-10 20:14:27
 * \* description:
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int start = 0, end = 0;
        int result = 1;
        while (end < s.length()){
            if (end == start){
                end++;
            }else {
                char endChar = s.charAt(end);
                if (!s.substring(start, end).contains("" + endChar)){
                    end++;
                    result = Math.max(result, end - start);
                }else {
                    while (s.substring(start, end).contains("" + endChar)){
                        start++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}