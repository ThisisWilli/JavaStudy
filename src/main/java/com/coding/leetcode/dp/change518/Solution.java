package com.coding.leetcode.dp.change518;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-11 21:32
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 **/

public class Solution {
    int result = 0;
    public  int change(int amount, int[] coins) {
        if (amount == 0){
            return 1;
        }
        for (int i = 0; i < coins.length; i++) {
            helper(amount - coins[i], coins, i);
        }
        return result;
    }

    public  void helper(int amount, int[] coins, int loc){
        if (amount < 0){
            return;
        }
        if (amount == 0){
            result++;
            return;
        }
        for (int i = loc; i < coins.length; i++) {
            helper(amount - coins[i], coins, i);
        }
    }

    public static void main(String[] args) {
//        System.out.println(change(3, new int[]{2}));
    }
}
