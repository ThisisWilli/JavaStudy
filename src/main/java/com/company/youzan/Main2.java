package com.company.youzan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-11 14:52
 **/

public class Main2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 输入的表达式的括号是否能配对
     * @param statement string字符串
     * @return bool布尔型
     * ( [ {
     */
    public static boolean isValid (String statement) {
        // write code here
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        set.add('(');
        set.add(')');
        set.add('{');
        set.add('}');
        set.add('[');
        set.add(']');
        for (char c : statement.toCharArray()) {
            if (!set.contains(c)){
                continue;
            }
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (c == ']'){
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (c == '}'){
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("123"));
        System.out.println(isValid("(123)"));
        System.out.println(isValid("(12"));
        System.out.println(isValid("()"));
        System.out.println(isValid("((123))abc"));
        System.out.println(isValid("[(123))abc"));
        System.out.println(isValid("123[(abc)]"));
        System.out.println(isValid("{(123)}abc"));
        System.out.println(isValid(""));
    }
}
