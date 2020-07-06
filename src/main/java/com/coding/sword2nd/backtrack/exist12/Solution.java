package com.coding.sword2nd.backtrack.exist12;

import javafx.util.Pair;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.backtrack.exist12
 * \* author: Willi Wei
 * \* date: 2020-07-06 16:29:10
 * \* description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向
 * 左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * \
 */
public class Solution {

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
        System.out.println(new Solution().exist(board, "ABCCED"));
    }
}