package com.coding.sword2nd.string.replacespace05;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.string.replacespace05
 * \* author: Willi Wei
 * \* date: 2020-07-06 15:34:17
 * \* description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * \
 */
public class Solution {
    public String replaceSpace(String s) {
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                spaceNum++;
            }
        }

        char[] result = new char[s.length() + spaceNum * 2];
        int newIndex = result.length - 1, oldIndex = s.length() - 1;

        while (newIndex >= 0 && oldIndex >= 0){
            if (s.charAt(oldIndex) != ' '){
                result[newIndex] = s.charAt(oldIndex);
                newIndex--;
                oldIndex--;
            }else {
                oldIndex--;
                result[newIndex] = '0';
                result[newIndex - 1] = '2';
                result[newIndex - 2] = '%';
                newIndex = newIndex - 3;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("").toString());
    }
}