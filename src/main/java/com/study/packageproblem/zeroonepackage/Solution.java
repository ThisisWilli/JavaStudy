package com.study.packageproblem.zeroonepackage;

import java.util.Scanner;

/**
 * \* project: JavaStudy
 * \* package: com.study.packageproblem.zeroonepackage
 * \* author: Willi Wei
 * \* date: 2020-08-05 14:55:55
 * \* description:
 * \
 */
public class Solution {

    public int twoDimension(int[] weight, int[] value, int targetWeight){
        int[][] dp = new int[value.length][targetWeight + 1];
        int res = 0;

        // 每次都尝试将不同的物品放入背包中，j为背包的容量，dp[i][j]表示尝试将第i个物品放入背包中，并且背包的容量为j
        for (int i = 1; i < weight.length; i++){
            for (int j = 1; j <= targetWeight; j++){
                dp[i][j] = dp[i - 1][j];

                if (j >= weight[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }

                if (j == targetWeight){
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int oneDimension(int[] weight, int[] value, int targetWeight){
        int[] dp = new int[targetWeight + 1];
        int res = 0;
        for (int i = 1; i < weight.length; i++){
            for (int j = targetWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
            res = Math.max(dp[targetWeight], res);
        }
        return res;
    }

    public static void main(String[] args) {

//        int[] weight = new int[]{0, 1, 2, 3, 4};
//        int[] value = new int[]{0, 2, 4, 4, 5};
        Scanner sc = new Scanner(System.in);
        // 物品数量
        int N = sc.nextInt();
        // 目标容量
        int V = sc.nextInt();
        int[] weight = new int[1 + N];
        int[] value = new int[1 + N];
//         dp[i][j] 表示价值为j时，抽到第i件物品的价值最大值
        for (int i = 1; i < weight.length; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
//        System.out.println(new Solution().getResult(weight, value, V));
        System.out.println(new Solution().oneDimension(weight, value, V));
    }
}