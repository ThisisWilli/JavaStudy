package com.problemsolve.polymorphisms;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.polymorphisms
 * \* author: Willi Wei
 * \* date: 2020-07-30 09:09:14
 * \* description:
 * \
 */
public class Cat extends Animal {
    int num = 80;
    static int age = 90;
    String name = "tomCat";

    public void eat(){
        System.out.println("猫吃饭");
    }

    public static void sleep(){
        System.out.println("猫在睡觉");
    }

    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }
}