package com.coding.leetcode.string.reversewords151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-10 09:08
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 **/

public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0){
            return "";
        }
        // 先将字符串做处理，过滤掉多余的空格
        char[] chars = s.toCharArray();
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < chars.length){
            if (chars[i] == ' ' || chars[i] == 160){
                i++;
            }else {
                String word = "";
                while (i < chars.length){
                    if (chars[i] != ' ' && chars[i] != 160){
                        word += String.valueOf(chars[i]);
                        i++;
                    }else {
                        break;
                    }

                }
                strs.add(word);
            }
        }
        Collections.reverse(strs);
        String str = new String();
        for (int j = 0; j < strs.size(); j++) {
            if (j == strs.size() - 1){
                str += strs.get(j);
            }else {
                str += strs.get(j) + " ";
            }
        }


        return str;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the"));
    }
}
