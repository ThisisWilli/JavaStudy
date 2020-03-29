package com.coding.leetcode.bfs.maxdistance1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-29 09:27
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1
 *
 **/

public class Solution {

    public int maxDistance(int[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    queue.add(getIndex(i, j, grid.length));
                }
            }
        }

        int size = queue.size();
        if (size == 0 || size == grid.length * grid.length){
            return -1;
        }

        int step = 0;
        while (!queue.isEmpty()){
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++){
                Integer head = queue.poll();
                int currentX = head / grid.length;
                int currentY = head % grid.length;
                for (int[] direction : directions){
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (inArea(newX, newY, grid.length) && grid[newX][newY] == 0){
                        grid[newX][newY] = 1;
                        queue.add(getIndex(newX, newY, grid.length));
                    }
                }
            }
            step++;
        }
        return step - 1;
    }


    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private boolean inArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    private int getDistance(int x0, int y0, int x1, int y1){
        return Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }
}