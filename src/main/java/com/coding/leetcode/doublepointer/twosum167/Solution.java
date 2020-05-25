package com.coding.leetcode.doublepointer.twosum167;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepointer.twosum167
 * \* author: Willi Wei
 * \* date: 2020-05-25 10:35:00
 * \* description:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
 * \
 */
public class Solution {
    // 考虑[2, 3, 6, 8, 11, 15]的情况 2,6时，需要low增加
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0){
            return null;
        }

        int[] result = new int[2];
        int low = 0, high = numbers.length - 1;
        while (low < high){
            if (numbers[low] + numbers[high] == target){
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            }
            if (numbers[low] + numbers[high] > target){
                high--;
            }else {
                low++;
            }
        }
        return result;
    }
}