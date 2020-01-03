package com.coding.sword.recursion.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.recursion.fibonacci
 * \* author: Willi Wei
 * \* date: 2020-01-03 13:53:56
 * \* description:输入一个整数，输出斐波那契数列的第n项 1，1，2，3，5,
 *                  递归方法
 * \
 */
public class Solution {
    /**
     * 方法一：递归
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n < 1){
            return 0;
        }
        if (1 == n){
            return 1;
        }
        if (2 == n){
            return 1;
        }
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    /**
     * 方法二：打表
     * @param n
     * @return
     */
    public int Fibonacci2(int n){
        if (n <= 0){
            return 0;
        }
        List<Integer> results = new ArrayList<>();
        results.add(0, 1);
        results.add(1, 1);
        for (int i = 2;i < n; i++){
            results.add(i, results.get(i - 1) + results.get(i - 2));
        }
//        results.forEach(num-> System.out.print(num + " "));
        return results.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci2(5));
    }
}