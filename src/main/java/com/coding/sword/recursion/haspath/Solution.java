package com.coding.sword.recursion.haspath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第
 * 一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * @author: Hoodie_Willi
 * @create: 2020-01-23 09:03
 **/

public class Solution {
    /**
     * 利用回溯法解题，
     * a    b    t    g
     * c    f    c    s
     * j    d    e    h
     * @param matrix，输入矩阵
     * @param rows，矩阵行数
     * @param cols，矩阵列数
     * @param str，目标路径
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null){
            return false;
        }
        if (str == null){
            return true;
        }
        // 首先将一维数组转化为二维数组
        char[][] matrix2 = new char[rows][cols];
        char[][] visited = new char[rows][cols];
        boolean result = false;

        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[0].length; j++){
                visited[i][j] = 0;
            }
        }

        int i = 0, row = 0, col = 0;
        while (i < matrix.length){
            matrix2[row][col++] = matrix[i];
            if ((i+1) % cols == 0){
                row++;
                col = 0;
            }
            i++;
        }
        for (int m = 0; m < matrix2.length; m++){
            for (int n = 0; n < matrix2[0].length; n++){
                if (matrix2[m][n] == str[0]){
                    if (helper(matrix2, matrix2.length, matrix2[0].length, m, n, str, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return result;
    }

    private boolean helper(char[][] matrix2, int rows, int cols, int rowLoc, int colLoc, char[] str, int loc, char[][] visited){
        visited[rowLoc][colLoc] = 1;
        if (loc == str.length - 1){
            return true;
        }
        boolean hasPath = false;
        // 首先要判断是否访问到了什么位置
        // 向左, 判断向左是否越界；向左走的那个元素有没有被访问过；左边的那个元素是否等于下一个元素
        if ((colLoc - 1) >= 0 && visited[rowLoc][colLoc - 1] == 0 && matrix2[rowLoc][colLoc - 1] == str[loc + 1]) {
            if (hasPath = helper(matrix2, rows, cols, rowLoc, colLoc - 1, str, loc+1, visited)){
                return true;
            }
//            loc--;
        }
        // 向右
        if ((colLoc + 1) < cols && visited[rowLoc][colLoc + 1] == 0 && matrix2[rowLoc][colLoc + 1] == str[loc + 1]) {
            if (hasPath = helper(matrix2, rows, cols, rowLoc, colLoc + 1, str, loc+1, visited)){
                return true;
            }
//            loc--;
        }
        // 向上
        if ((rowLoc - 1) >= 0 && visited[rowLoc - 1][colLoc] == 0 && matrix2[rowLoc - 1][colLoc] == str[loc + 1]) {
            if (hasPath = helper(matrix2, rows, cols, rowLoc - 1, colLoc, str, loc+1, visited)){
                return true;
            }
//            loc--;
        }
        // 向下
        if ((rowLoc + 1) < rows && visited[rowLoc + 1][colLoc] == 0 && matrix2[rowLoc + 1][colLoc] == str[loc + 1]){
            if (hasPath = helper(matrix2, rows, cols, rowLoc + 1, colLoc, str, loc+1, visited)){
                return true;
            }
//            loc--;
        }
        // 如果都不能走，则返回上层，并且将现在这个点标成可访问, 并且访问长度减一
        visited[rowLoc][colLoc] = 0;
        if (loc != 0){
            loc--;
        }
        return hasPath;
    }

    public static void main(String[] args) {
        // ABCESFCSADEE",3,4,"ABCCED
        System.out.println(new Solution().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SLHECCEIDEJFGGFIE".toCharArray()));
    }
}
