package com.coding.leetcode.dp.canpartition416;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dp.canpartition416
 * \* author: Willi Wei
 * \* date: 2020-06-23 09:08:57
 * \* description:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * \
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = true;

        if (nums[0] == target){
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++){
            for (int j = 0; j <= target; j++){

                dp[i][j] = dp[i - 1][j];
                // 当前这个nums[i] <= j，dp[i - 1][j - nums[i]]为true，说明加上nums[i] 总和就为j，应该为true
                if (nums[i] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            if (dp[i][target]){
                return true;
            }
        }

        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}