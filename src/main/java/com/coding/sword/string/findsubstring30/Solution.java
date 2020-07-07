package com.coding.sword.string.findsubstring30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.string.findsubstring30
 * \* author: Willi Wei
 * \* date: 2020-07-07 13:29:18
 * \* description:
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  1.单词长度相同
 *  2. 不需要考虑单词串联的顺序
 *
 * 示例 1：
 *
 * 输入：
 *   s = "",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * "barfoofoobarthefoobarman"
 * ["bar","foo","the"]
 * \
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        if (s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length()){
            return new ArrayList<>();
        }

        // 原生HashMap，记录元素之间的记录关系
        HashMap<String, Integer> rawMap = new HashMap<>();
        for (String word : words) {
            if (!rawMap.containsKey(word)){
                rawMap.put(word, 1);
            }else {
                Integer temp = rawMap.get(word);
                rawMap.put(word, temp + 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>(rawMap);
        // 目标数量，以及每次移动的步长
        int targetNum = words.length, stepLength = words[0].length();

        for (int i = 0; i < s.length(); i++) {
            // 现在已经统计的单词个数
            int countNum = 0;
            int j = i;
//            result = new ArrayList<>();
            countMap = new HashMap<>(rawMap);
            while (j < s.length()){

                // 超出这个步长
                if (j + stepLength > s.length()){
                    break;
                }
                String sub = s.substring(j, j + stepLength);
                if (countMap.containsKey(sub) && countMap.get(sub) != 0){
                    Integer integer = countMap.get(sub);
                    countMap.put(sub, integer - 1);
                    countNum++;
//                    result.add(j);
                    j += stepLength;
                }else {
                    break;
                }
                if (countNum == targetNum){
                    result.add(i);
                    break;
//                    return result;
                }
            }
        }
        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {

        if (s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length()){
            return new ArrayList<>();
        }

        // 原生HashMap，记录元素之间的记录关系
        HashMap<String, Integer> rawMap = new HashMap<>();
        for (String word : words) {
            if (!rawMap.containsKey(word)){
                rawMap.put(word, 1);
            }else {
                Integer temp = rawMap.get(word);
                rawMap.put(word, temp + 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>(rawMap);
        // 目标数量，以及每次移动的步长
        int targetNum = words.length, stepLength = words[0].length();

        for (int i = 0; i < s.length(); i++) {
            // 现在已经统计的单词个数
            int countNum = 0;
            int j = i;
//            result = new ArrayList<>();
            countMap = new HashMap<>(rawMap);
            while (j < s.length()){

                // 超出这个步长
                if (j + stepLength > s.length()){
                    break;
                }
                String sub = s.substring(j, j + stepLength);
                if (countMap.containsKey(sub) && countMap.get(sub) != 0){
                    Integer integer = countMap.get(sub);
                    countMap.put(sub, integer - 1);
                    countNum++;
//                    result.add(j);
                    j += stepLength;
                }else {
                    break;
                }
                if (countNum == targetNum){
                    result.add(i);
                    break;
//                    return result;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {//                        I  I  I
        List<Integer> result = new Solution().findSubstring("", new String[]{});
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}