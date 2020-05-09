package com.coding.leetcode.math.mysqrt69;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.math.mysqrt69
 * \* author: Willi Wei
 * \* date: 2020-05-09 09:18:04
 * \* description:
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * \
 */
public class Solution {
    public int mySqrt(int x) {
        // 二分查找解题
        int r = x, l = 0, ans = -1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}