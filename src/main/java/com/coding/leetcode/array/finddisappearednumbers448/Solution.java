package com.coding.leetcode.array.finddisappearednumbers448;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.finddisappearednumbers448
 * \* author: Willi Wei
 * \* date: 2020-05-29 16:14:29
 * \* description:
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * \
 */
public class Solution {
    /**
     * 将
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        result.forEach(num->{
            System.out.print(num + " ");
        });
    }
}