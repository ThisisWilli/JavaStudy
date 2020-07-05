package com.coding.sword2nd.recursion.mypow16;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.recursion.mypow16
 * \* author: Willi Wei
 * \* date: 2020-07-05 12:50:54
 * \* description:
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * \
 */
public class Solution {

    public double quickPow(double x, long N){
        if (N == 0){
            return 1.0;
        }

        double y = quickPow(x, N / 2);
        return N % 2 == 1 ? y * y * x : y * y;

    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x, N) : 1 / quickPow(x, -N);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, 4));
    }

}