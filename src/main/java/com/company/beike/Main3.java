package com.company.beike;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-07 15:47
 **/

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mod = 1000000007;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int c = sc.nextInt();
            HashSet<Integer>[] color = new HashSet[m + 1];
            for (int j = 1; j <= m; j++) {
                color[j] = new HashSet<Integer>();
                for (int k = 1; k <= c; k++) {
                    color[j].add(sc.nextInt());
                }
            }
            int[][] dp = new int[n + 1][m + 1];
            for (int j = 1; j <= m; j++) {
                dp[1][j] = 1;
            }

            help(n, m, dp, color, mod);
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += dp[n][j];
                sum %= mod;
            }
            System.out.println(sum);
        }
    }

    public static void help(int n, int m, int[][] dp, HashSet<Integer>[] color, int mod){
        for (int j = 2; j <= n; j++){
            for (int k = 1; k <= m; k++) {
                for (int l = 1; l <= m; l++) {
                    if (!color[k].contains(l)){
                        dp[j][l] += dp[j - 1][k];
                        dp[j][l] %= mod;
                    }
                }
            }
        }
    }
}
