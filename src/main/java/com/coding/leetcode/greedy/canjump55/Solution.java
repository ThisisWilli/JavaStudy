package com.coding.leetcode.greedy.canjump55;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-04 23:38
 **/

public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i + nums[i] && max >= i){
                max = i + nums[i];
            }
            if (max >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
