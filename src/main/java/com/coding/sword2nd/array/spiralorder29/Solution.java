package com.coding.sword2nd.array.spiralorder29;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.spiralorder29
 * \* author: Willi Wei
 * \* date: 2020-07-01 08:59:27
 * \* description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * \
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // 判空
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }
        if (matrix.length == 1){
            return matrix[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int i = 0, j = 0, count = 0, targetCount = matrix.length * matrix[0].length - 1;

        while (count <= targetCount){

            while (isEdge(i, j, matrix) && visited[i][j] && count <= targetCount){
                j++;
            }
            // 向右
            while (isEdge(i, j, matrix) && j < matrix[0].length && !visited[i][j] && count <= targetCount){
                result[count++] = matrix[i][j];
                visited[i][j] = true;
                j++;
            }
            j--;

            while (isEdge(i, j, matrix) && visited[i][j] && count <= targetCount){
                i++;
            }
            // 向下
            while (isEdge(i, j, matrix) && i < matrix.length && !visited[i][j] && count <= targetCount){
                result[count++] = matrix[i][j];
                visited[i][j] = true;
                i++;
            }
            i--;

            while (isEdge(i, j, matrix) && visited[i][j] && count <= targetCount){
                j--;
            }
            // 向左
            while (isEdge(i, j, matrix) && j >= 0 && !visited[i][j] && count <= targetCount){
                result[count++] = matrix[i][j];
                visited[i][j] = true;
                j--;
            }
            j++;

            while (isEdge(i, j, matrix) && visited[i][j] && count <= targetCount){
                i--;
            }
            // 向上
            while (isEdge(i, j, matrix) && i >= 0 && !visited[i][j] && count <= targetCount){
                result[count++] = matrix[i][j];
                visited[i][j] = true;
                i--;
            }
            i++;
        }

        return result;
    }

    public boolean isEdge(int i, int j, int[][] matrix){
        return (i >= 0 && i < matrix.length) && (j >= 0 && j < matrix[0].length);
    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
//        int[][] test = {
//                {2},
//                {3}};

        int[] result = new Solution().spiralOrder(test);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}