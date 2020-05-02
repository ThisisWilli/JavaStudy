package com.coding.leetcode.string.lengthoflongestsubstring3;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 10:46
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
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
 *
 **/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        ArrayList<Character> window = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!window.contains(chars[i])){
                window.add(chars[i]);
                result = Math.max(window.size(), result);
            }else {
                int j = 0;
                while (window.get(j) != chars[i]){
                    window.remove(j);
//                    j++;
                }
                window.remove(j);
                window.add(chars[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }
}
