package com.coding.sword2nd.recursion.fib10I;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.recursion.fib10I
 * \* author: Willi Wei
 * \* date: 2020-07-05 12:47:52
 * \* description:
 * \
 */
public class Solution {
    public int fib(int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1 || n == 2){
            return 1;
        }

        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 1;
        results[3] = 2;
        for (int i = 3; i <= n; i++) {
            results[i] = (results[i - 1] + results[i - 2]) % 1000000007;
        }

        return results[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(5));
    }
}