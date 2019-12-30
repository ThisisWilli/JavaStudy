package com.study.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.lambda
 * \* author: Willi Wei
 * \* date: 2019-12-26 15:15:39
 * \* description:对于只有一个抽象方法的接口（只有一个抽象方法时，lambda表达式才能顺利推导），需要这种接口的对象时，就可以提供一个lambda表达式，这种接口称为函数式接口
 * \
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("if", "else", "just", "while"));
        // removeif参数为一个Predicate，这个接口专门用来传递lambda表达式
        list.removeIf(str -> str.contains("else"));
        System.out.println(list.toString());
    }
}