package com.study.sort.selectsort;

/**
 * \* project: JavaStudy
 * \* package: com.study.sort.selectsort
 * \* author: Willi Wei
 * \* date: 2020-07-21 19:58:38
 * \* description: 实现选择排序
 * \
 */
public class Solution {
    /**
     * 每次都找最大的那个元素与最后的那个元素交换
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < nums.length - i; j++){
                max = nums[j] > nums[max] ? j : max;
            }
            int temp = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[max];
            nums[max] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = new Solution().sortArray(new int[]{5,1,1,2,0,0});
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}