package com.coding.leetcode.backtrack.solvequeens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-19 09:27
 * 在一个N*N的棋盘上放置N个皇后，每行一个并使其不能互相攻击（同一行、同一列、同一斜线上的皇后都会自动攻击
 **/

public class Solution {
    boolean [][] chessBoard;
//    boolean [][] visited
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 1){
            result.add(new ArrayList<>(Arrays.asList("Q")));
            return result;
        }
        chessBoard = new boolean[n][n];
//        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            chessBoard[0][i] = true;
            getResult(chessBoard, 1);
            chessBoard[0][i] = false;
        }
        return result;
    }

    /**
     * 在当前层寻找一个能够存放的点，如果不能被存放，则回溯上去
     * @param chessBoard
     * @param loc 当前层
     */
    public void getResult(boolean[][] chessBoard, int loc){
        // 按列遍历
        for (int i = 0; i < chessBoard.length; i++){
            if (canPut(chessBoard, loc, i)){
                chessBoard[loc][i] = true;
                if (loc == chessBoard.length - 1){
                    addResult(chessBoard);
                }else {
                    getResult(chessBoard, loc + 1);
                }
                chessBoard[loc][i] = false;
            }
        }
    }

    public boolean canPut(boolean[][] chessBoard, int locI, int locJ){
        // 向上和向下，j固定
        for (int i = 0; i < chessBoard.length; i++){
            if (chessBoard[i][locJ]){
                return false;
            }
        }

        // 向左和向右
        for (int j = 0; j < chessBoard.length; j++){
            if (chessBoard[locI][j]){
                return false;
            }
        }

        // 左上
        int i = locI, j = locJ;
        while (i >= 0 && i < chessBoard.length && j >= 0 && j < chessBoard.length){
            if (chessBoard[i][j]){
                return false;
            }else {
                i--;
                j--;
            }
        }
        // 左下
        i = locI;
        j = locJ;
        while (i >= 0 && i < chessBoard.length && j >= 0 && j < chessBoard.length){
            if (chessBoard[i][j]){
                return false;
            }else {
                i++;
                j--;
            }
        }

        // 右下
        i = locI;
        j = locJ;
        while (i >= 0 && i < chessBoard.length && j >= 0 && j < chessBoard.length){
            if (chessBoard[i][j]){
                return false;
            }else {
                i++;
                j++;
            }
        }

        // 右上
        i = locI;
        j = locJ;
        while (i >= 0 && i < chessBoard.length && j >= 0 && j < chessBoard.length){
            if (chessBoard[i][j]){
                return false;
            }else {
                i--;
                j++;
            }
        }
        return true;
    }

    public void addResult(boolean[][] chessBoard){
        List<String> s = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            StringBuilder str = new StringBuilder(new String());
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j]){
                    str.append("Q");
                }else {
                    str.append(".");
                }
            }
            s.add(str.toString());
        }
        result.add(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(1);
        lists.forEach(list->{
            list.forEach(num->{
                System.out.print(num + " ");
                System.out.println();
            });
            System.out.println();
        });
    }
}
