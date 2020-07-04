package com.coding.sword2nd.sort.minnumber45;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.sort.minnumber45
 * \* author: Willi Wei
 * \* date: 2020-07-04 19:16:59
 * \* description:
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:  输出结果可能非常大，所以你需要返回一个字符串而不是整数, 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 对元素进行排序，
 * \
 */
public class Solution {

    String result;

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0){
            return "";
        }
        for (int num : nums) {
            list.add("" + num);
        }
        // 排序数组
        Collections.sort(list);

        // 找出数组中的开始元素
        boolean[] visited = new boolean[nums.length];
        ArrayList<String> results = new ArrayList<>();
        int target = 0;
        for (String s : list) {
            target += s.length();
            result += s;
        }
        for (int i = 0; i < list.size(); i++) {

            if (!visited[i]){
                visited[i] = true;
                helper(list, visited, target, "" + list.get(i));
                visited[i] = false;
            }
        }

        return result;
    }

    public void helper(List<String> list, boolean[] visited, int target, String temp){
        for (int i = 0; i < list.size(); i++) {
            if (result.substring(0, temp.length()).compareTo(temp) < 0){
                continue;
            }
            if (!visited[i]){
                visited[i] = true;
                helper(list, visited, target, temp + list.get(i));
                visited[i] = false;
            }
        }
        if (temp.length() == target){
            if (temp.compareTo(result) < 0){
                result = temp;
            }
        }
        if (temp.length() > 0){
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(new Solution().minNumber(nums));
//        System.out.println("333333333333333333333333333333".compareTo("333333333333333333333333333334"));
//        System.out.println();
    }
}