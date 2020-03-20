package com.problemsolve.whyequals;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-19 22:18
 **/

public class Test {
    public static void main(String[] args) {
        String s = new String("123");
//        String s1 = new String("123");
        String s1 = s;
        System.out.println(s == s1);
    }
}
