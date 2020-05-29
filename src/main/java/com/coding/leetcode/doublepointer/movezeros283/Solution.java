package com.coding.leetcode.doublepointer.movezeros283;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepointer.movezeros283
 * \* author: Willi Wei
 * \* date: 2020-05-29 16:06:21
 * \* description:
 * \
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length){
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}