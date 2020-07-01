package com.coding.sword2nd.array.search53I;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.search53I
 * \* author: Willi Wei
 * \* date: 2020-07-01 10:24:35
 * \* description:
 * 统计一个数字在排序数组中出现的次数。

 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * \
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, targetIndex = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                targetIndex = mid;
            }
            if (nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        if (targetIndex == -1){
            return 0;
        }else {
            int result = 1;
            int i = targetIndex - 1, j = targetIndex + 1;
            while (i >= 0 && nums[i] == target){
                i--;
                result++;
            }

            while (j < nums.length && nums[j] == target){
                j++;
                result++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}