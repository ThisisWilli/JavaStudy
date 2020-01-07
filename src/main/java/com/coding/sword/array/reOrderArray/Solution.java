package com.coding.sword.array.reOrderArray;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.array.reOrderArray
 * \* author: Willi Wei
 * \* date: 2020-01-06 11:09:44
 * \* description:
 * \
 */
public class Solution {
    /**
     * 输入一个整形数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
     * 利用插入排序的思想解题
     * @param array [2, 4, 6, 8, 1, 3, 5, 7] --> [1, 3, 5, 7, 2, 4, 6, 8]
     *              [1, 2, 3, 4, 5, 6, 7, 8] --> [1, 3, 5, 7, 2, 4, 6, 8]
     */
    public void reOrderArray(int [] array) {
        int pre = 0;
        for (int i = 0; i < array.length; i++){
            // 寻找奇数，若寻找到，则将pre到i之间的数字向后移动一位
            if ((array[i] % 2) == 1){
                int temp = array[i];
                // 注意不是从前往后替换，应该是从后往前替换
                for (int j = i - 1; j >= pre; j--){
                    array[j + 1] = array[j];
                }
                array[pre] = temp;
                pre++;
            }
        }
        for (int i = 0; i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Solution().reOrderArray(new int[]{2, 1, 3, 4, 5});
//        System.out.println(2 % 2);
    }
}