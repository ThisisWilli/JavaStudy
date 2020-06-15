package com.coding.leetcode.array.topkfrequent347;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.topkfrequent347
 * \* author: Willi Wei
 * \* date: 2020-06-15 08:51:07
 * \* description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * \
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums.length < k){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }
        int i = 0;
        for (Integer integer : heap) {
            result[i++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Solution().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)) {
            System.out.print(i + " ");
        }
    }
}