package com.study.abstractAndInterface.abstractTest;

/**
 * \* project: JavaStudy
 * \* package: com.study.abstractAndInterface.abstractTest
 * \* author: Willi Wei
 * \* date: 2020-01-05 19:38:36
 * \* description:
 * \
 */
public class Dog extends Animal{
    @Override
    public void speak() {
        System.out.println("dog speaking");
    }

    public static void main(String[] args) {
        new Dog().speak();
    }
}