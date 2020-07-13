package com.coding.sword2nd.array.twosum57;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-13 14:03
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0, end = nums.length - 1;
        while (start < end){
            if (nums[start] + nums[end] == target){
                result[0] = nums[start];
                result[1] = nums[end];
                return result;
            }else if (nums[start] + nums[end] > target){
                end--;
            }else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        for (int i : new Solution().twoSum(nums, 9)) {
            System.out.print(i + " ");
        }
    }
}
