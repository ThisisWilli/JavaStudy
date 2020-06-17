/*
 * @Author: your name
 * @Date: 2020-06-17 08:58:13
 * @LastEditTime: 2020-06-17 09:38:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \JavaStudy\src\main\java\com\coding\leetcode\dp\maxprofit309\Solution.java
 */ 
package com.coding.leetcode.dp.maxprofit309;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dp.maxprofit309
 * \* author: Willi Wei
 * \* date: 2020-06-17 09:00:48
 * \* description:
 * \
         给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

         设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

         你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
         示例:

         输入: [1,2,3,0,2]
         输出: 3
         解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
         第一天买入为1元，第二天卖出为2元，利润一元，第三天不买，第四天0元买入，第5天2元卖出，利润2元，
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, rest = 0, hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int preSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSold);
        }
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}