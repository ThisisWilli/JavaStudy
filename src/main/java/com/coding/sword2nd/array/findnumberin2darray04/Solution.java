package com.coding.sword2nd.array.findnumberin2darray04;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.findnumberin2darray04
 * \* author: Willi Wei
 * \* date: 2020-07-01 10:42:37
 * \* description: 从右上角中的元素开始寻找
 * \在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int i = 0, j = matrix[0].length - 1;

        while (isEdge(i, j, matrix[0].length, matrix.length)){
            if (isEdge(i, j, matrix[0].length, matrix.length) && matrix[i][j] == target){
                return true;
            }

            if (isEdge(i, j, matrix[0].length, matrix.length) && matrix[i][j] > target){
                j--;
            }

            if (isEdge(i, j, matrix[0].length, matrix.length) && matrix[i][j] < target){
                i++;
            }
        }
        return false;
    }

    public boolean isEdge(int i, int j, int width, int height){
        return i >= 0 && i < height && j >= 0 && j < width;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//               {1,   4,  7, 11, 15},
//               {2,   5,  8, 12, 19},
//               {3,   6,  9, 16, 22},
//               {10, 13, 14, 17, 24},
//               {18, 21, 23, 26, 30}};
        int[][] matrix = {{-1, 3}};

        System.out.println(new Solution().findNumberIn2DArray(matrix, 3));
    }
}