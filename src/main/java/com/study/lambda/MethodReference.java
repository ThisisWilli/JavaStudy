package com.study.lambda;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.study.lambda
 * \* author: Willi Wei
 * \* date: 2019-12-26 16:11:51
 * \* description:表达式System.out::println是一个方法引用，他只是编译器生成一个函数式接口的实例，覆盖这个接口的抽象方法来调用给定的
 *    方法，在这个例子中会生成一个ActionListener，它的actionPerformed(ActionEvent e)方法要调用System.out.println(e)
 * \
 */
public class MethodReference {
    public static void main(String[] args) {
        String[] strings = new String[]{"if", "else", "For", "while"};
        Arrays.sort(strings, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strings));
    }
}