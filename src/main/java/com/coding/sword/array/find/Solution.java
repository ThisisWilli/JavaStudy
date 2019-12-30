package com.coding.sword.array.find;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.array.find
 * \* author: Willi Wei
 * \* date: 2019-12-19 20:48:07
 * \* description:二维数组中的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * \从右上角开始查找
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (rows > 0 && cols >= 0){
            int row = 0, col = cols - 1;
            while (row < rows && col > 0){
                if (target == array[row][col]){
                    return true;
                }else if(target > array[row][col]){
                    row++;
                }else {
                    col--;
                }
            }
        }
        return false;
    }
}