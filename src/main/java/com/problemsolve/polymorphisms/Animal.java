package com.problemsolve.polymorphisms;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.polymorphisms
 * \* author: Willi Wei
 * \* date: 2020-07-30 09:04:41
 * \* description:
 * \
 */
public class Animal {
    int num = 10;
    static int age = 20;

    public void eat(){
        System.out.println("动物吃饭");
    }

    public static void sleep(){
        System.out.println("动物在睡觉");
    }

    public void run(){
        System.out.println("动物在奔跑");
    }
}
