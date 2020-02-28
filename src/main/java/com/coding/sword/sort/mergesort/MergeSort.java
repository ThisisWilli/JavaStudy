package com.coding.sword.sort.mergesort;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-28 10:17
 **/

public class MergeSort {
    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 先把较小的数放到temp中
        while (i <= mid && j <= high){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= high){
            temp[k++] = nums[j++];
        }

        for (int n = 0; n < temp.length; n++){
            nums[n + low] = temp[n];
        }
    }

    private void mergeSort(int[] nums, int low, int high){
        int mid = (high + low) / 2;
        if (low < high){
            // 左半边数组不停分割
            mergeSort(nums, low, mid);
            // 右半边数组进行排序
            mergeSort(nums, mid + 1, high);
            // 将数组进行合并
            merge(nums, low, mid, high);

        }
    }
}
