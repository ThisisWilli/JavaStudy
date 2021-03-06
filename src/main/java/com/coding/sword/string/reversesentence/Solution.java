package com.coding.sword.string.reversesentence;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 10:06
 **/

import java.util.Arrays;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution {

    public String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        if (strs.length <= 1){
            return str;
        }
        int start = 0;
        int end = strs.length - 1;
        while (start < end){
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
            start++;
            end--;
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strs.length - 1; i++){
            result.append(strs[i]).append(" ");
        }
        return result.append(strs[strs.length - 1]).toString();
    }

    public static void main(String[] args) {
//        String s = "student. a am I";
        String s = "student";
        System.out.println(new Solution().ReverseSentence(s));
    }
}
