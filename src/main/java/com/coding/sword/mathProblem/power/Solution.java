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
     * 利用快速幂的方法，将指数与1进行&位运算，若为1，则结果乘上该位上对应的底数^2的对应次方
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public double Power(double base, int exponent){
        // 特殊情况，需要考虑指数为负数的情况
        if (base == 0){
            return 0;
        }
        if (exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }
        double result = 1;
        double cur = base;
        while(exponent > 0){
            if ((exponent & 1) == 1){
                result *= cur;
            }
            // 注意这里是指数次增长的
            cur *= cur;
            // 指数右移
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
        System.out.println(new Solution().Power(3, 5));
    }
}