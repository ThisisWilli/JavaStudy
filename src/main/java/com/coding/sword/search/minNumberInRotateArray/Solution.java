package com.coding.sword.search.minNumberInRotateArray;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.search.minNumberInRotateArray
 * \* author: Willi Wei
 * \* date: 2020-01-03 10:30:22
 * \* description:把数组最开始的若干个元素搬到数组的末尾，成为数组的旋转，输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
 *      数组为递增数组
 * \
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
            i++;
        }
        return array[0];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().minNumberInRotateArray(new int[]{1, 1, 0, 1, 1}));
    }
}