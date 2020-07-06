package com.coding.sword2nd.dp.cuttingrope14II;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.dp.cuttingrope14II
 * \* author: Willi Wei
 * \* date: 2020-07-06 20:06:36
 * \* description:
 * \
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n == 2){
            return 1;
        }

        if (n == 3){
            return 2;
        }

        long res = 1;
        while (n > 4){
            res *= 3;
            res = res % (1000000007);
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(120));
    }
}