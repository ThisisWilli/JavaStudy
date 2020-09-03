package com.company.baidu;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-03 20:20
 * 回家要走n个台阶
 * 单步最多只能跨m个台阶，最少一个台阶
 * 每步和之前两步走的台阶数目不能相同，
 * 一行一个整数，表示答案
 *
 * 一行输入两个整数n，m，表示台阶数目，单步跨越的最多台阶数目
 * 30%数据有m<= n < 5
 * 60%的数据有 n<=300
 * 对于100%的数据有1<=n <= 100000, 2<=m < 7
 *
 * 7 3
 * 2
 * 合法走法为1 2 3 1      1 3 2 1          1 2 1 3 非法走法
 **/

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][m + 1][m + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k == j){
                        continue;
                    }
                    for (int l = 0; l <= m; l++) {
                        if (i - k == 0 && j == 0) {
                            dp[i][k][j] = 1;
                            continue;
                        }
                        if (l == k || i - k <= 0){
                            continue;
                        }
                        dp[i][k][j] += dp[i - k][j][l];
                        dp[i][k][j] %= mod;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                sum += dp[n][i][j];
                sum %= mod;
            }
        }
        System.out.println(sum);
    }
}
