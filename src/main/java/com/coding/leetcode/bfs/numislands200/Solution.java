package com.coding.leetcode.bfs.numislands200;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 09:06
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 **/

public class Solution {
    int result;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1'){
                    result++;
                    dfs(grid, visited, directions, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int[][] directions, int i, int j){
        visited[i][j] = true;
        for (int[] direction : directions) {
            // 可以走，并且没有访问过，并且值= 1
            if (isEdge(grid, i + direction[0], j + direction[1])
                    && !visited[i + direction[0]][j + direction[1]] && grid[i + direction[0]][j + direction[1]] == '1'){
                dfs(grid, visited, directions, i + direction[0], j + direction[1]);
            }
        }
    }

    private boolean isEdge(char[][] grid, int i, int j){
        return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[i].length);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grids = new char[][]{
                {'1', '1','0', '0', '0'},
                {'1', '1','0', '0', '0'} ,
                {'0', '0','1', '0', '0'},
                {'0', '0','0', '1', '1'}
        };

        System.out.println(s.numIslands(grids));
    }
}
