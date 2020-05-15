package com.coding.leetcode.array.subarraysum560;

import java.util.HashMap;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.subarraysum560
 * \* author: Willi Wei
 * \* date: 2020-05-15 08:40:05
 * \* description:
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * \
 */
public class Solution {
    /**
     * 前缀表 + hash优化
     * 用pre[i]记录0到i的和，用pre[j]表示从0到j的和，那么pre[i] - pre[j - 1] == k 就能表示从j到i的数字的和
     * 以和为key，以出现次数为value，
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2, 1}, 7));
    }
}