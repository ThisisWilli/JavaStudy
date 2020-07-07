package com.coding.sword2nd.bit.hammingweight15;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.bit.hammingweight15
 * \* author: Willi Wei
 * \* date: 2020-07-07 11:09:42
 * \* description:
 * \请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class Solution {
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {

        long N = n;
        int count = 0;
        while (N != 0){
            count += (N & 1);
            N = N >>> 1;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight2(1024));
    }
}