package com.coding.leetcode.doublepointer.twosum1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepoint.twosum1
 * \* author: Willi Wei
 * \* date: 2020-05-25 10:19:35
 * \* description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0){
            return null;
        }
        // 利用map解题，key为值，value为出现的下标
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}