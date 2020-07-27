package com.company.alibaba;

/**
 * \* project: JavaStudy
 * \* package: com.company.alibaba
 * \* author: Willi Wei
 * \* date: 2020-07-27 19:03:18
 * \* description:
 * 在纸上写一个非递减的数字序列，然后一次进行以下步骤，牛牛先开始
 * 每个人选择一个当前序列中的数字，把这个数字在序列中第一次出现的位置及其左边的数字全部删除，当某人操作完之后学列为空时则此人获胜，
 * 假设此时序列为111222，如果小强选择2，那么删除之后的得到的序列为22，假设小强小明都是大佬。请问谁能获得游戏的胜利
 * \
 * 第一行表示数据的测试组数
 * 每组数据，第一行一个整数n，n表示序列中数字的个数
 * 接下来一行n个整数，其中第i个整数ai表示第i个整数
 * 1
 * 5
 * 2 2 3 3 6
 * 输出 NIUNIU 小强赢
 * NIUMEI 小明赢
 * 小强先开始
 *小强拿6，小明无论拿什么都是输
 *
 */
public class Solution1 {

    public void f1(int[] arr){
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == arr[i - 1]){
                dp[i] = !dp[i - 1];
            }else {
                dp[i] = true;
            }
        }

        if (dp[arr.length - 1]){
            System.out.println("NIUNIU");
        }else {
            System.out.println("NIUMEI");
        }
    }

    public static void main(String[] args) {
        new Solution1().f1(new int[]{2, 2, 3, 3, 6});
    }
}