package com.coding.leetcode.string.generateparenthesis22;

import com.sun.javafx.tools.ant.CSSToBinTask;

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
    List<String> results = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0){
            return results;
        }
        if (n == 1){
            results.add("()");
            return results;
        }

        helper("(", n - 1, n);
        return results;
    }

    private void helper(String s, int left, int right){
        if (left > 0 && right > 0){
            helper(s + "(", left - 1, right);
            helper(s + ")", left, right - 1);
        }else if (left == 0 && right > 0){
            helper(s + ")", left, right - 1);
        }else if (left > 0 && right == 0){
            helper(s + "(", left - 1, right);
        }else if (left == 0 && right == 0){
            if (isResult(s)){
                results.add(s);
            }
//            results.add(s);
        }
    }

    private boolean isResult(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(chars[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
         new Solution().generateParenthesis(3).forEach(s-> System.out.println(s));
//        System.out.println(new Solution().isResult("((()))"));
    }
}
