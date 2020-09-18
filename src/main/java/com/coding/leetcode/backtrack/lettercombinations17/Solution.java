package com.coding.leetcode.backtrack.lettercombinations17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.backtrack.lettercombinations17
 * \* author: Willi Wei
 * \* date: 2020-09-17 10:03:07
 * \* description:
 * \
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)){
            return new ArrayList<>();
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        // 1. 使用HashMap存储数字与字母的映射
        // 2. 遍历
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1'){
                temp.append(digits.charAt(i));
            }
        }
        digits = new String(temp);
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();


        // 获取这个数字映射到的字符串
        String mapChars = map.get(digits.charAt(0));
        for (int j = 0; j < mapChars.length(); j++) {
            sb.append(mapChars.charAt(j));
            dfs(digits, map, result, 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return result;
    }

    /**
     *
     * @param digits 输入的字符串
     * @param map 数字与字母的映射关系
     * @param result 返回结果
     * @param loc 遍历到的位置
     * @param sb 临时结果集
     */
    public void dfs(String digits, HashMap<Character, String> map, LinkedList<String> result, int loc, StringBuilder sb){
        if (loc > digits.length() - 1){
            result.addLast(new String(sb));
            return;
        }
        String mapChars = map.get(digits.charAt(loc));
        for (int j = 0; j < mapChars.length(); j++) {
            sb.append(mapChars.charAt(j));
            dfs(digits, map, result, loc + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().letterCombinations("123");
        list.forEach(System.out::println);
    }
}