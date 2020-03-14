package com.coding.leetcode.dp.lengthoflis;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-14 08:35
 **/

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 创建dp[i]数组，代表以第i个数字结尾的最长上升子序列，注意nums[i]必须被选取
        // 状态转移方程为 dp[i] = dp[j] + 1  0 <= j < i && nums[j] < nums[i]
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 以nums[i]为结尾的最长上升子序列
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = maxVal + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
