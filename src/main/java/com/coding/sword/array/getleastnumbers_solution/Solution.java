package com.coding.sword.array.getleastnumbers_solution;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: Hoodie_Willi
 * @create: 2020-02-19 09:44
 **/

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 数组大小小于k，或者k=0的情况
        if (input.length < k || k == 0){
            ArrayList result = new ArrayList();
//            for (int i = 0; i < input.length;i++){
//                result.add(input[i]);
//            }
//            return result;

            return result;
        }
        // 用一个list存储最小值，在list.size() < k时，直接加入元素，大于时，看看是否能够替换list中的最大元素
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++){
            if (result.size() < k){
                result.add(input[i]);
            }
            if (result.size() >= k){
                if (Collections.max(result) > input[i]){
                    int max = Collections.max(result);
                    result.remove(result.indexOf(max));
                    result.add(input[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().GetLeastNumbers_Solution(new int[]{4}, 4).forEach(System.out::println);
    }
}
