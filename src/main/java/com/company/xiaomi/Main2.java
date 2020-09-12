package com.company.xiaomi;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-08 18:43
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 样例输入
 * SEE
 * 样例输出
 * true
 **/

public class Main2 {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        if (board == null){
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !result){
                    dfs(board, visited, directions, i, j, word,1, word.length());
                }
            }
        }

        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, int[][] directions, int x, int y, String word, int wordLoc, int targetLoc){
        if (wordLoc == targetLoc){
            result = true;
            return;
        }

        visited[x][y] = true;
        for (int[] direction : directions) {
            if (isEdge(board, x + direction[0], y + direction[1]) && !visited[x + direction[0]][y + direction[1]]
                    && (board[x + direction[0]][y + direction[1]] == word.charAt(wordLoc)) && wordLoc <= targetLoc && !result){
                dfs(board, visited, directions, x + direction[0], y + direction[1], word, wordLoc + 1, targetLoc);
            }
        }

        visited[x][y] =false;
    }

    public boolean isEdge(char[][] board, int i, int j){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println(new Main2().exist(board, sc.nextLine()));
    }
}
