package com.coding.leetcode.greedy.jump;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.greedy.jump
 * \* author: Willi Wei
 * \* date: 2020-05-04 20:25:49
 * \* description:
 * \
 */
public class Solution {
    public int jump(int[] nums) {
        int steps = 0, end = 0, maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end){
                end = maxReach;
                steps++;
            }
        }

        return steps;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }
}