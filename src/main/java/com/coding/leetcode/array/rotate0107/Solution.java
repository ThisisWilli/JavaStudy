package com.coding.leetcode.array.rotate0107;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-07 08:58
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 **/

public class Solution {
    public void rotate(int[][] matrix) {
        // 先左右翻转
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }

        // 对角线翻转
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1- j][matrix[0].length - 1 - i];
                matrix[matrix.length - 1- j][matrix[0].length - 1 - i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3},
                                 {4, 5, 6},
                                {7, 8, 9}};
        new Solution().rotate(nums);
    }
}
