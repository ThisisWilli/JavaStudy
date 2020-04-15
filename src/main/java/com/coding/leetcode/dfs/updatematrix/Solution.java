package com.coding.leetcode.dfs.updatematrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-15 09:14
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 **/

public class Solution {
    int[][] result;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null){
            return null;
        }

        int[][] directions =  new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        result = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // 将所有的0进队，进队之后，搜索非0点，将0点之外的一层节点进队
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
                    visited[i][j] = true;
                    queue.offer(pair);
                }
            }
        }

        while (!queue.isEmpty()){
            Pair node = queue.poll();
            for (int[] direction : directions) {
                if (isEdge(matrix, visited,(Integer) node.getKey() + direction[0], (Integer) node.getValue() + direction[1])){
                    visited[(Integer) node.getKey() + direction[0]][(Integer) node.getValue() + direction[1]] = true;
                    result[(Integer) node.getKey() + direction[0]][(Integer) node.getValue() + direction[1]] = result[(Integer) node.getKey()][(Integer) node.getValue()] + 1;
                    queue.offer(new Pair<Integer, Integer>((Integer) node.getKey() + direction[0], (Integer) node.getValue()));

                }
            }
        }
        return result;
    }


    public boolean isEdge(int[][] matrix,boolean[][] visited, int i, int j){
        return (i >= 0 && i < matrix.length) && (j >= 0 && j < matrix[0].length) && !visited[i][j];
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 1},


        };

        Solution s = new Solution();
        s.updateMatrix(matrix);
        for (int i = 0; i < s.result.length; i++) {
            for (int j = 0; j < s.result[0].length; j++) {
                System.out.print(s.result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
