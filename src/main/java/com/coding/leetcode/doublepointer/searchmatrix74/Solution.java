package com.coding.leetcode.doublepointer.searchmatrix74;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepointer.searchmatrix74
 * \* author: Willi Wei
 * \* date: 2020-06-22 10:01:30
 * \* description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * \
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >=0){
            if (matrix[m][n] == target){
                return true;
            }else if (matrix[m][n] > target){
                n--;
            }else {
                m++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        System.out.println(new Solution().searchMatrix(matrix, 15));
    }
}