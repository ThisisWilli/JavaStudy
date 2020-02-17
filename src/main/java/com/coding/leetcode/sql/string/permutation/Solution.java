package com.coding.leetcode.sql.string.permutation;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-17 09:37
 **/

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Solution {
    public String[] permutation(String s) {
        if (s.length() == 0){
            return null;
        }
        char[] str = s.toCharArray();
        ArrayList list = new ArrayList<String>();
        helper(str, list, 0);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size();i++){
            result[i] = (String)list.get(i);
        }
        return result;
    }

    /**
     *
     * @param str
     * @param result
     * @param loc 已经交换到的位置
     */
    private void helper(char[] str, ArrayList<String> result, int loc){
        if (loc == str.length - 1){
            result.add(String.valueOf(str));
        }else {
            HashSet<Character> set = new HashSet<>();
            for (int i = loc; i < str.length;i++){
                // 剪枝去重
                if (i == loc || !set.contains(str[i])){
                    set.add(str[i]);
                    swap(str, loc, i);
                    helper(str, result, loc + 1);
                    swap(str, loc, i);
                }
            }
        }
    }

    /**
     * 在字符数组中交换指定两个index的值
     * @param s
     * @param i
     * @param j
     */
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Arrays.asList(new Solution().permutation("aab")).forEach(System.out::println);
    }
}
