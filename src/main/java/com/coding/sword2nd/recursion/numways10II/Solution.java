package com.coding.sword2nd.recursion.numways10II;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.recursion.numways10II
 * \* author: Willi Wei
 * \* date: 2020-07-05 12:33:17
 * \* description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * \
 */
public class Solution {
    public int numWays(int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1 || n == 2){
            return n;
        }

        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        for (int i = 3; i <= n; i++) {
            results[i] = (results[i - 1] + results[i - 2]) % 1000000007;
        }

        return results[n] % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(46));
    }
}