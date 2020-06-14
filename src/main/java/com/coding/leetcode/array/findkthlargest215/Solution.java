package com.coding.leetcode.array.findkthlargest215;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.findkthlargest215
 * \* author: Willi Wei
 * \* date: 2020-06-14 10:35:06
 * \* description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * \
 * 创建一个大顶堆，保持堆中的元素只有k个
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek() != null ? queue.peek() : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}