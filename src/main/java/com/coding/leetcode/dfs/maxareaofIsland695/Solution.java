package com.coding.leetcode.dfs.maxareaofIsland695;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-15 09:24
 **/

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 */
public class Solution {

    private int result = 0;
    private int temp;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null){
            return 0;
        }
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                // 如果该点的值为1，并且没有访问过
                if (grid[i][j] == 1 && visited[i][j] != 1){
                    dfs(grid, visited, i, j);
//                    System.out.println("start at " + i +" " + j + " " + " temp = " + temp);
                    if (temp > result){
                        result = temp;
                        temp = 0;
                    }else {
                        temp = 0;
                    }
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int[][] visited, int i, int j){
        temp++;
        visited[i][j] = 1;
        // 向上走
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == 0){
            dfs(grid, visited, i - 1, j);
        }
        // 向下走
        if (i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] == 0){
            dfs(grid, visited, i + 1, j);
        }
        // 向左走
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == 0){
            dfs(grid, visited, i, j - 1);
        }
        // 向右走
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && visited[i][j + 1] == 0){
            dfs(grid, visited, i, j + 1);
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},

        };
        System.out.println(new Solution().maxAreaOfIsland(nums));
    }
}
