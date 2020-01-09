package com.coding.sword.array.printMatrix;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.array.printMatrix
 * \* author: Willi Wei
 * \* date: 2020-01-08 20:11:50
 * \* description:输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
 * \
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1.首先计算要逆时针旋转的层数
     * @param matrix
     * @return
     */

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(matrix.length==0) {
            return result;
        }
        int n = matrix.length,m = matrix[0].length;
        if(m==0) {
            return result;
        }
        //这个是层数
        int layers = (Math.min(n,m)-1)/2+1;
        for(int i=0;i<layers;i++){
            //左至右
            for(int k = i;k<m-i;k++) {
                result.add(matrix[i][k]);
            }
            //右上至右下
            for(int j=i+1;j<n-i;j++){
                result.add(matrix[j][m-i-1]);
            }
            //右至左
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--){
                result.add(matrix[n-i-1][k]);
            }
            //左下至左上
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--){
                result.add(matrix[j][i]);
            }
        }
        return result;
    }
}