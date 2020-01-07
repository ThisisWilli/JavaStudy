package com.coding.sword.mathProblem.power;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.mathProblem.power
 * \* author: Willi Wei
 * \* date: 2020-01-06 10:38:03
 * \* description:给定一个double类型的浮点数base和int类型的整数exponent，求base的exponent次方
 * \
 */
public class Solution {

    /**
     * 快速幂方法 题解：https://juejin.im/post/5d4e493851882546ef680417
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent){
        double cur = base, result = 1;
        if (exponent < 0){
            cur = 1 / base;
            exponent = -exponent;
        }
        while (exponent != 0){
            if ((exponent & 1) == 1){
                result *= cur;
            }
            // 转换为相应的二进制次方所对应的结果
            cur *= cur;
            exponent = exponent >> 1;
        }
        return result;
    }

    /**
     * 白痴方法
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        double result = 1;
        if (exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }
        for (int i = 0; i < exponent; i++){
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Power(2, -3));
    }
}