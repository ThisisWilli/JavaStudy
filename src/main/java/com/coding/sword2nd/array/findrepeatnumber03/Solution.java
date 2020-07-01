package com.coding.sword2nd.array.findrepeatnumber03;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.findrepeatnumber03
 * \* author: Willi Wei
 * \* date: 2020-07-01 10:17:54
 * \* description:
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * \
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        boolean[] have = new boolean[nums.length];

        for (int num : nums) {
            if (have[num]){
                return num;
            }else {
                have[num] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}