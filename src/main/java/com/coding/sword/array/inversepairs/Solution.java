package com.coding.sword.array.inversepairs;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-28 09:36
 **/

import java.util.Arrays;

/**
 * 使用归并排序的方法进行解题
 */
public class Solution {

    private int result = 0;
    public int InversePairs(int [] array) {
        if (array.length < 1){
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return result % 1000000007;
    }

    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = mid;
        int j = high;
        int k = temp.length - 1;
        while (i >= low && j >= mid + 1){
            // 如果前半部分大于后半部分数组，则构成逆序对，并且逆序对的个数等于后半部分子数组中的剩余数字
            if (nums[i] > nums[j]){
                temp[k--] = nums[i--];
                result += j - (mid + 1) + 1;
                if(result>=1000000007)//数值过大求余
                    result%=1000000007;
            }else {
                // 后半部分数字较大，不构成逆序对
                temp[k--] = nums[j--];
            }
        }
        while (i >= low){
            temp[k--] = nums[i--];
        }
        while (j >= mid + 1){
            temp[k--] = nums[j--];
        }
        for (int n = 0; n < temp.length; n++){
            nums[low + n] = temp[n];
            System.out.print(temp[n] + " ");
        }
        System.out.println();
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

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println("result = " + new Solution().InversePairs(nums));
    }
}
