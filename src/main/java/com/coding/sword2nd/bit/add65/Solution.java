package com.coding.sword2nd.bit.add65;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.bit.add65
 * \* author: Willi Wei
 * \* date: 2020-07-15 09:28:32
 * \* description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * \
 */
public class Solution {
    public int add(int a, int b) {
        int sum = 0, carry = 0;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (carry != 0);
        return a;
    }
}