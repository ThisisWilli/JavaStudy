package com.coding.sword2nd.math.printnumbers17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.math.printnumbers17
 * \* author: Willi Wei
 * \* date: 2020-07-07 14:39:59
 * \* description:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * \
 */
public class Solution {
    public int[] printNumbers(int n) {
        int[] result = new int[(int) Math.pow(10, n)];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Solution().printNumbers(3)) {
            System.out.println(i + " ");
        }
    }
}