package com.coding.leetcode.dfs.numrookcaptures999;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-26 09:19
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
 * 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 * 注意：只能吃颜色相反方格上的卒，碰到🐘要停
 * 白车 R
 * 白象 B
 * 黑卒 p
 *[[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","R",".",".",".","p"],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 **/

public class Solution {

    int result = 0;

    public int numRookCaptures(char[][] board) {
        if (board == null){
            return 0;
        }
        int Ri = 0, Rj = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'R'){
                    Ri = i;
                    Rj = j;
                }
            }
        }
        dfs(board, Ri, Rj, true, false, false, false);
        dfs(board, Ri, Rj, false, true, false, false);
        dfs(board, Ri, Rj, false, false, true, false);
        dfs(board, Ri, Rj, false, false, false, true);
        return result;
    }

    private void dfs(char[][] board, int i, int j, boolean up, boolean down, boolean left, boolean right){
        if (up && i - 1 >= 0){
            if (board[i - 1][j] == 'p'){
                result++;
                return;
            }
            if (board[i - 1][j] == 'B'){
                return;
            }
            dfs(board, i - 1, j, true, false, false, false);
        }
        if (down && i + 1 < board.length){
            if (board[i + 1][j] == 'p'){
                result++;
                return;
            }
            if (board[i + 1][j] == 'B'){
                return;
            }
            dfs(board, i + 1, j, false, true, false, false);
        }
        if (left && j - 1 >= 0){
            if (board[i][j - 1] == 'p'){
                result++;
                return;
            }
            if (board[i][j - 1] == 'B'){
                return;
            }
            dfs(board, i, j - 1, false, false, true, false);
        }
        if (right && j + 1 < board[0].length){
            if (board[i][j + 1] == 'p'){
                result++;
                return;
            }
            if (board[i][j + 1] == 'B'){
                return;
            }
            dfs(board, i, j + 1, false, false, false, true);
        }
    }

}
