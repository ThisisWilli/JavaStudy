package com.study.sort.bubblesort;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-14 19:31
 **/

public class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++) {
                if (j + 1 <= i && nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums, int l1, int l2){
        int temp = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().sortArray(new int[]{5, 4, 3, 2, 1});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
