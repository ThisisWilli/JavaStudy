package com.coding.leetcode.dp.waytochange0811;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-23 09:02
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 **/

public class Solution {
    public int waysToChange(int n) {
        int result = 0;
        for (int i = 0; i * 25 <= n; i++){
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            result = (result + (a + 1) * (a + b + 1) % 1000000007) % 1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(26));
    }
}
