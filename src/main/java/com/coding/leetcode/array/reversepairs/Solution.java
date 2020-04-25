package com.coding.leetcode.array.reversepairs;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-24 09:06
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 **/

public class Solution {
    int result = 0;
    /**
     * 使用归并排序解题，在对数组进行归并时对result进行统计
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length == 0){
            return result;
        }
        mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(int[] nums, int low, int high){
        int mid = (high + low) / 2;
        if (low < high){
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        // nums[low, mid], nums[mid + 1, high]为两个区间
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high){
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
                result += (j - (mid + 1));
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
            result += j - (mid + 1);
        }
        while (j <= high){
            temp[k++] = nums[j++];
        }

        for (int n = 0; n < temp.length; n++){
            nums[n + low] = temp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
