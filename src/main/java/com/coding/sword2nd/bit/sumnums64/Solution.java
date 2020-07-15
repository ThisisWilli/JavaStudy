package com.coding.sword2nd.bit.sumnums64;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.bit.sumnums64
 * \* author: Willi Wei
 * \* date: 2020-07-15 09:15:31
 * \* description:
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 * \
 */
public class Solution {
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }
}