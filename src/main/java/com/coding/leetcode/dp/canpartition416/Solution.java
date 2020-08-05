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
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1){
            return false;
        }

        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--){
                if (Math.max(dp[j], nums[i] + dp[j - nums[i]]) > sum / 2){
                    dp[j] = dp[j];
                }else {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
                if (dp[j] == sum / 2){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}