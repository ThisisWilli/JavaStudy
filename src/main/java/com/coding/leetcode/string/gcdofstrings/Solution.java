package com.coding.leetcode.string.gcdofstrings;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-12 09:16
 **/

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 先判断两个字符串的长短，把短字符串一点一点与str1判断
        if (str1 == null && str2 == null){
            return "";
        }
        String temp = "";
        if (str1.length() > str2.length()){
            temp = str2;
            return findString(str1, temp);
        }else {
            temp = str1;
            return findString(str2, temp);
        }
    }

    /**
     *
     * @param s1 不停被除的字符串
     * @param s2 
     * @return
     */
    private String findString(String s1, String s2){
        StringBuffer result = new StringBuffer("");
        for (int i = 1; i <= s2.length(); i++){
            String temp = s2.substring(0, i);
            if (s1.length() % temp.length() != 0 || s2.length() % temp.length() != 0){
                continue;
            }
            int start = 0;
            while (start < s1.length()){
                if (s1.substring(start, start + temp.length()).equals(temp)){
                    start = start + temp.length();
                }else {
                    break;
                }
            }
            if (start >= s1.length()){
                result = new StringBuffer(temp);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findString("ABCABC", "ABCABC"));
    }
}
