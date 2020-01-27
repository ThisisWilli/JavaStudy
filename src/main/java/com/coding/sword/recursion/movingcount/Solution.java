package com.coding.sword.recursion.movingcount;

/**
 * @program: JavaStudy
 * @description:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入
 *              行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能
 *              进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author: Hoodie_Willi
 * @create: 2020-01-25 11:20
 **/

public class Solution {
    /**
     * 利用回溯法解题，
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 边界条件要确认要注意！！
        if (threshold <= 0){
            return 0;
        }
        // 成员变量的初始值是false
        boolean[][] grids = new boolean[rows][cols];
        int count = 1;
        return robotMoving(grids, 0, 0, rows, cols, threshold, count);
    }

    /**
     * 上下左右都不能走了 才算结束
     * @param grids
     * @param rowLoc
     * @param colLoc
     * @param count
     * @return
     */
    private int robotMoving(boolean[][] grids, int rowLoc, int colLoc, int rows, int cols, int threshold, int count){
        if (!getNumber(rowLoc, colLoc, threshold)){
            return count;
        }
        grids[rowLoc][colLoc] = true;
        // 向左，首先判断是否越界，再判断下一步之前是否走过, 再判断是否符合条件
        if (colLoc - 1 >= 0 && !grids[rowLoc][colLoc - 1] && getNumber(rowLoc, colLoc - 1, threshold)){
            count = robotMoving(grids, rowLoc, colLoc - 1, rows, cols, threshold, count+1);
        }
        // 向右
        if (colLoc + 1 < cols && !grids[rowLoc][colLoc + 1] && getNumber(rowLoc, colLoc + 1, threshold)){
            count = robotMoving(grids, rowLoc, colLoc + 1, rows, cols, threshold, count+1);
        }
        // 向上
        if (rowLoc - 1 >= 0 && !grids[rowLoc - 1][colLoc] && getNumber(rowLoc - 1, colLoc, threshold)){
            count = robotMoving(grids, rowLoc - 1, colLoc, rows, cols, threshold, count+1);
        }
        // 向下
        if (rowLoc + 1 < rows && !grids[rowLoc + 1][colLoc] && getNumber(rowLoc + 1, colLoc, threshold)){
            count = robotMoving(grids, rowLoc + 1, colLoc, rows, cols, threshold, count+1);
        }
        return count;
    }

    /**
     * 计算坐标的数位之和, 只要和小于threshold都能继续往下走
     * @param row
     * @param col
     * @return
     */
    private static boolean getNumber(int row, int col, int threshold){
        int sum = 0;
        while (row > 0){
            sum += row % 10;
            row /= 10;
        }
        while (col > 0){
            sum += col % 10;
            col /= 10;
        }
        if (sum <= threshold){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(5, 10, 10));
    }

}
