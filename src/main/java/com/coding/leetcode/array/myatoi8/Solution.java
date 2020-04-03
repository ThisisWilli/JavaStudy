package com.coding.leetcode.array.myatoi8;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-03 09:02
 **/

public class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0;
        // 过滤空格
        while (index < n && chars[index] == ' '){
            index++;
        }
        // 如果过滤完空格来到了末尾，return 0
        if (index == n){
            return 0;
        }

        boolean negative = false;
        // 遇到了符号
        if (chars[index] == '-'){
            negative = true;
            index++;
        }else if (chars[index] == '+'){
            index++;
        }else if (!Character.isDigit(chars[index])){
            return 0;
        }

        int result = 0;
        while (index < n && Character.isDigit(chars[index])){
            int digit = chars[index] - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
    }
}
