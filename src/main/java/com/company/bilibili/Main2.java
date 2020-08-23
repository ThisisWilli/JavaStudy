package com.company.bilibili;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-13 19:26
 * 给出一个只包含括号的字符串，
 * 左括号必须要相同类型的右括号进行闭合
 * 左括号必须使用正确顺序闭合，空字符串也是有效字符串
 * {[]}
 *
 * true
 **/

public class Main2 {


    public boolean IsValidExp (String s) {
        // write code here

        char[] chars = s.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(')');
            }else if (chars[i] == '{'){
                stack.push('}');
            }else if (chars[i] == '['){
                stack.push(']');
            }else if (stack.isEmpty() || chars[i] != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new Main2().IsValidExp(s));
    }
}
