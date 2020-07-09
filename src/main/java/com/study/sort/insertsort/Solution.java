package com.study.sort.insertsort;

/**
 * \* project: JavaStudy
 * \* package: com.study.sort.insertsort
 * \* author: Willi Wei
 * \* date: 2020-07-09 21:45:10
 * \* description:
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * \
 */
public class Solution {
    public void insertSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], minLoc = i;
            for (int j = i; j < nums.length; j++){
                if (nums[j] <= min){
                    min = nums[j];
                    minLoc = j;
                }
            }
            for (int j = minLoc; j > i; j--){
                nums[j] = nums[j - 1];
            }
            nums[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        new Solution().insertSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}