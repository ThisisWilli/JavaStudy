package com.coding.leetcode.array.sortarray912;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-31 09:21
 **/

public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int begin ,int end){
        if (begin > end){
            return ;
        }
        int i = begin;
        int j = end;
        int guard = nums[begin];
        while (begin < end){
            while (begin < end && nums[end] > guard){
                end--;
            }
            nums[begin] = nums[end];
            while (begin < end && nums[begin] <= guard){
                begin++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = guard;
        quickSort(nums, i, begin - 1);
        quickSort(nums, end + 1, j);
    }

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        new Solution().sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
