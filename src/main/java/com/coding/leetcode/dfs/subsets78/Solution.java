package com.coding.leetcode.dfs.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.dfs.subsets78
 * \* author: Willi Wei
 * \* date: 2020-08-23 14:15:20
 * \* description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * \
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            helper(nums, i, temp, result);
            temp.remove(temp.size() - 1);
        }
        return result;
    }

    public void helper(int[] nums, int loc, List<Integer> temp,  List<List<Integer>> result){
        for (int i = loc + 1; i < nums.length; i++) {
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            helper(nums, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{3, 2, 1});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}