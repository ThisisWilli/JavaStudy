package com.company.alibaba;

import com.coding.leetcode.math.mypow50.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-05 08:49
 * 扑克牌去掉大小王由数字1-13各四种花色组成，小强创建一张牛牌，牛牌由数字1-n各四种花色组成，但是小强只有黑色水笔画不出四种花色，因此他只能
 * 创造出1-n各四张牌，他想知道，当他手上有m张牌时，这m张牌一共有多少牌型（两种牌型不同当且仅当某个数字在两种牌型中的数量不同）
 *
 * dp[i][j]表示抽完1到i，手牌有j张时的种数，
 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4]; //边界条件要考虑，每次加了之后取
 *
 * n m
 * 3 2
 *
 * 6
 * 1 1
 * 1 2
 * 1 3
 * 2 2
 * 2 3
 * 3 3
 *
 * 9 14
 * 118800
 **/

public class Main1 {
    public int result = 0;
    private void fun(int n, int m){
        int mod = 1000000007;
        int[][] dp = new int[n + 1][m + 5];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;

        for (int i = 2; i <=n; i++){
            for (int j = 0; j <= m; j++){
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0){
                    dp[i][j] += (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j - 2 >= 0){
                    dp[i][j] += (dp[i][j] + dp[i - 1][j - 2]) % mod;
                }
                if (j - 3 >= 0){
                    dp[i][j] += (dp[i][j] + dp[i - 1][j - 3]) % mod;
                }
                if (j - 4 >= 0){
                    dp[i][j] += (dp[i][j] + dp[i - 1][j - 4]) % mod;
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // 范围1 - n
//        int n = sc.nextInt();
//        // 手牌数量
//        int m = sc.nextInt();
        new Main1().fun(9, 14);
    }
}
