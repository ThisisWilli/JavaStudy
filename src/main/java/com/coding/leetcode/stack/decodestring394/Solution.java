/*
 * @Author: your name
 * @Date: 2020-06-18 09:28:34
 * @LastEditTime: 2020-06-18 10:03:01
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \JavaStudy\src\main\java\com\coding\leetcode\stack\decodestring394\MinStack.java
 */ 
package com.coding.leetcode.stack.decodestring394;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.stack.decodestring394
 * \* author: Willi Wei
 * \* date: 2020-06-18 09:28:34
 * \* description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * \
 */
public class Solution {
    /**
     * 如果为字母或者左括号，则直接入字母栈
     * 如果为数字，则入数字栈
     * 如果为右括号，则出栈一个数字栈，并且将字母栈出栈，一直出到左括号
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> inStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for(Character c : s.toCharArray()) {
            if('[' == c ) {
                inStack.addLast(multi);
                strStack.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if(']' == c) {
                StringBuilder temp = new StringBuilder();
                int cur_multi = inStack.removeLast();
                for(int j = 0; j < cur_multi; j++)
                    temp.append(res);
                res = new StringBuilder(strStack.removeLast() + temp);
            } else if('0' <= c && '9' >= c) {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else
                res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().decodeString("abc3[cd]xyz");
        for (char c : s.toCharArray()) {
            System.out.print(c);
        }
    }
}