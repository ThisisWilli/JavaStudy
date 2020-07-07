package com.coding.sword2nd.array.exchange21;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.exchange21
 * \* author: Willi Wei
 * \* date: 2020-07-07 15:33:55
 * \* description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * \
 */
public class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int start = 0, end = nums.length - 1;
        while (start != end){
            while (nums[start] % 2 == 1 && start < end){
                start++;
            }
            while (nums[end] % 2 == 0 && start < end){
                end--;
            }

            if (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        for (int i : new Solution().exchange(new int[]{1, 2, 3, 4})) {
            System.out.print(i + " ");
        }
    }
}