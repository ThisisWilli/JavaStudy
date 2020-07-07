package com.coding.sword.sort.quicksort;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.sort.quicksort
 * \* author: Willi Wei
 * \* date: 2020-07-07 16:00:42
 * \* description:
 * \
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
//        int start = 0, end = nums.length - 1;
        if (start < end){
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid);
            quickSort(nums, mid + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        int p = nums[start];
        while (start < end){
            while (nums[end] >= p && start < end){
                end--;
            }
            nums[start] = nums[end];

            while (nums[start] < p && start < end){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = p;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 4, 5};
        int[] res = new Solution().sortArray(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}