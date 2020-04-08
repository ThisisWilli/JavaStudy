package com.coding.leetcode.dfs.movingcount13;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-08 09:16
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 **/

public class Solution {
    int result = 0;
    public int movingCount(int m, int n, int k) {
        if (k < 0){
            return 0;
        }
        int[][] grids = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dfs(0, 0, k, grids, visited, directions);
        return result;
    }

    private boolean isEdge(int m, int n, int i, int j){
        return (i < m && i >= 0) && (j < n && j >= 0);
    }

    private void dfs(int i, int j, int k, int[][] grids, boolean[][] visited, int[][] directions){
        if (transfer(i) + transfer(j) <= k){
            result++;
            visited[i][j] = true;
            for (int[] direction : directions) {
                if (isEdge(grids.length, grids[0].length, i + direction[0], j + direction[1])
                        && !visited[i + direction[0]][j + direction[1]]){
                    dfs(i + direction[0], j + direction[1], k, grids, visited, directions);
                }
            }
        }
    }

    private int transfer(int x){
        int sum = 0;
        while (x > 0){
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(3, 1, 0));
    }
}
