package com.coding.leetcode.array.gameoflife289;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-02 09:52
 **/

public class Solution {

    // 时间复杂度O(nm)，空间复杂度O(mn)
    public void gameOfLife(int[][] board) {
        // copy数组永远不变
        int[][] copy = new int[board.length][board[0].length];
        copy = board.clone();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                conv(board, copy, i, j);
            }
        }

//        for (int[] ints : copy) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        for (int[] ints : board) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
    }

    private void conv(int[][] board, int[][] copy, int i, int j){
        int aliveNum = 0;
        // 方向数组
        int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] direction : move) {
            if (isEdge(copy, i + direction[0], j + direction[1])){
                // 新的点在二维矩阵内，进行统计
                if (copy[i + direction[0]][j + direction[1]] == 1){
                    aliveNum++;
                }
            }
        }
        if (copy[i][j] == 1){
            if (aliveNum < 2){
                board[i][j] = 0;
            }
            if (aliveNum == 2 || aliveNum == 3){
                board[i][j] = 1;
            }
            if (aliveNum > 3){
                board[i][j] = 0;
            }
        }else {
            if (aliveNum == 3){
                board[i][j] = 1;
            }
        }
    }

    private boolean isEdge(int[][] board, int i, int j){
        return (i >= 0 && i < board.length) && (j >= 0 && j < board[0].length);
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
