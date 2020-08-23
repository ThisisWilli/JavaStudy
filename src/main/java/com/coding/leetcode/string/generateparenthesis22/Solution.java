package com.coding.leetcode.string.generateparenthesis22;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-09 09:05
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 **/

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        helper(result, new StringBuilder(""), n, n);
        return result;
    }

    public void helper(List<String> result, StringBuilder builder, int left, int right){
        if (left > right){
            return;
        }
        if (left == 0 && right == 0){
            result.add(new String(builder));
            return;
        }
        if (left > 0){
            helper(result, builder.append('('), left - 1, right);
            if (builder.length() >0 ){
                builder.deleteCharAt(builder.length() - 1);
            }

        }
        if (right > 0){
            helper(result, builder.append(')'), left, right - 1);
            if (builder.length() >0 ){
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
