package com.coding.sword.array.MoreThanHalfNumSolution;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-18 09:41
 **/

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int countMax = 0, maxNum = array[0];
        for (int i = 0; i < array.length; i++){
            // 如果当前数字等于最大的数字，那么countMax加一，最大数字不变
            if (array[i] == maxNum){
                countMax++;
            }else {
                // 如果当前数字不等于最大数字，maxNum-1，如果countMax等于0，那么最大数字要换成当前数字
                countMax--;
                if (countMax == 0){
                    maxNum = array[i];
                    countMax = 1;
                }
            }
        }
        if (checkMoreThanHalf(maxNum, array)){
            return maxNum;
        }else {
            return 0;
        }
    }

    private boolean checkMoreThanHalf(int num, int[]array){
        int count = 0;
        for (int i = 0; i < array.length;i++){
            if (array[i] == num){
                count++;
            }
        }
        if (count > array.length / 2){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
    }
}
