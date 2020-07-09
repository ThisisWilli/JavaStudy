package com.coding.sword2nd.bit.majorityelement39;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.bit.majorityelement39
 * \* author: Willi Wei
 * \* date: 2020-07-09 14:01:30
 * \* description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * [10,9,9,9,10]
 * \
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int vote = 0;
        for (int num : nums) {
            if (num != result){
                vote--;
                if (vote < 0){
                    result = num;
                    vote = 0;
                }
            }else {
                vote++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] nums = {10,9,9,9,10};
        System.out.println(new Solution().majorityElement(nums));
    }
}