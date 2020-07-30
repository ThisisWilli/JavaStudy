package com.problemsolve.polymorphisms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.polymorphisms
 * \* author: Willi Wei
 * \* date: 2020-07-30 09:09:42
 * \* description:
 * \
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        animal.sleep();
        animal.run();
        System.out.println(animal.num);
        System.out.println(animal.age);
    }
}