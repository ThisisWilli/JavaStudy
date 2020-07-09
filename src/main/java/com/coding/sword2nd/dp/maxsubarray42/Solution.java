package com.coding.sword2nd.dp.maxsubarray42;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.dp.maxsubarray42
 * \* author: Willi Wei
 * \* date: 2020-07-09 14:59:25
 * \* description:
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * \
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-1, -2}));
    }
}