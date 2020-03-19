package com.coding.leetcode.array.longestpalindrome;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-19 09:24
 **/

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 *  输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()){
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            // 当出现第一个字符出现为奇数时，ans变为奇数，后面再出现奇数的字符，就只取偶数部分
            if (v % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ccdbbb"));
    }
}
