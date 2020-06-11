package com.coding.leetcode.doublepointer.findunsortedsubarray581;

import java.lang.ref.SoftReference;
import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepointer.findunsortedsubarray581
 * \* author: Willi Wei
 * \* date: 2020-06-11 10:52:51
 * \* description:
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 *      [1, 3, 2, 4]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * \
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //找到逆序pair中的最小和最大值
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] > nums[i]){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            }
        }

        // 找到逆序对中最左边的结点
        int l, r;
        for (l = 0; l < nums.length; l++){
            if (min < nums[l]){
                break;
            }
        }

        // 找到逆序对中最右边的结点
        for (r = nums.length - 1; r >=0; r--){
            if (max > nums[r]){
                break;
            }
        }

        return r - l < 0 ? 0: r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}