package com.coding.leetcode.dp.coinchange322;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-16 09:34
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    /**
     *
     * @param coins
     * @param index
     * @param amount
     * @param cnt 现在硬币的数量
     */
    private void dfs(int[] coins, int index, int amount, int cnt){
        if(index<0){
            return;
        }
        for(int c = amount / coins[index]; c>=0; c--){
            // 用较大硬币兑换过后的余额
            int na = amount - c * coins[index];
            // 现在兑换硬币的数量
            int ncnt = cnt + c;
            if(na==0){
                ans=Math.min(ans,ncnt);
                break;//剪枝1
            }
            if(ncnt+1>=ans){
                break; //剪枝2
            }
            dfs(coins,index-1, na, ncnt);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
