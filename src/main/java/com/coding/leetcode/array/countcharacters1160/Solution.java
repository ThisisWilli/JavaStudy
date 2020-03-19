package com.coding.leetcode.array.countcharacters1160;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-17 09:52
 **/

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * 1、遍历words数组是每次重建一个hash表，存储每个字母垂岸的次数
 * 2、遍历words中的每个元素，
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        if (words == null || chars == null){
            return 0;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < chars.length(); i++){
            if (map1.containsKey(chars.charAt(i))){
                map1.put(chars.charAt(i), map1.get(chars.charAt(i)) + 1);
            }else {
                map1.put(chars.charAt(i), 1);
            }
        }
        for (String word : words) {
            boolean flag = true;
            // 遍历每个word之前新建一个hashmap
            HashMap<Character, Integer> map = new HashMap<>(map1);
            // 创建完hashmap之后，开始遍历word中的每个元素
            for (int i = 0; i < word.length(); i++){
                if (map.containsKey(word.charAt(i)) && map.get(word.charAt(i)) > 0){
                    Integer count = map.get(word.charAt(i));
                    map.put(word.charAt(i), count - 1);
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
