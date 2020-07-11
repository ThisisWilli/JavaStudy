package com.coding.sword2nd.string.firstuniqchar50;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.string.firstuniqchar50
 * \* author: Willi Wei
 * \* date: 2020-07-11 15:42:26
 * \* description:
 * \在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 */
public class Solution {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                Integer count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        char result = ' ';
        int k = 1;
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar(""));
    }
}