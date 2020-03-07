package com.coding.sword.mathProblem.findnumberswithsum;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 13:21
 **/

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 1, 2, 3, 4, 5, 6,
 */
public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2) {
            return result;
        }
        int start = 0, end = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                if (array[start] * array[end] < min) {
                    min = array[start] * array[end];
                    result.add(array[start]);
                    result.add(array[end]);
                }
                start++;
                end--;
            }else if (array[start] + array[end] > sum){
                end--;
            }else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().FindNumbersWithSum(new int[]{1,2,4,7,11,15}, 15).forEach(num->{
            System.out.println(num);
        });
    }
}
