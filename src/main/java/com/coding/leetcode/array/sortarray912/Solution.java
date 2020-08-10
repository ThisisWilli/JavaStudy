package com.coding.leetcode.array.sortarray912;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-31 09:21
 **/

public class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void merge(int[] nums, int start, int mid, int end){
        // 申请临时数组
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, tempLoc = 0;
        while(i <= mid && j <= end){
            if(nums[i] >= nums[j]){
                temp[tempLoc++] = nums[j];
                j++;
            }else{
                temp[tempLoc++] = nums[i];
                i++;
            }
        }

        while(i <= mid){
            temp[tempLoc++] = nums[i++];
        }

        while(j <= end){
            temp[tempLoc++] = nums[j++];
        }

        i = start;
        j = 0;
        while(i <= end){
            nums[i++] = temp[j++];
        }
    }

    public void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void main(String[] args) {
        int[] nums = {};
        new Solution().sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
