package com.coding.sword.string.firstnotrepeatingchar;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 *              如果没有则返回 -1（需要区分大小写）.
 * @author: Hoodie_Willi
 * @create: 2020-02-27 09:29
 **/

public class Solution {

    // 若使用hashmap表，则要考虑hashmap不是顺序存储的问题，如果自定义
    private int FirstNotRepeatingChar(String str) {
        if (str.length() == 0){
            return -1;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
                continue;
            }
            map.put(str.charAt(i), 1);
        }
        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("aaaaaaaaaaaaaabcd"));
    }
}
