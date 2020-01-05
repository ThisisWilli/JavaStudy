package com.study.abstractAndInterface.abstractTest;

/**
 * \* project: JavaStudy
 * \* package: com.study.abstractAndInterface.abstractTest
 * \* author: Willi Wei
 * \* date: 2020-01-05 19:26:49
 * \* description:
 * \
 */
public abstract class Animal {

    /**
     * 抽象类中可以自己定义成员变量和成员方法，没有访问修饰符限制
     */
    private int num;
    static {
        System.out.println("this is static code block");
    }

    {
        System.out.println("this is code block");
    }

    public Animal() {
        System.out.println("构造函数");
    }

    private void run(){

    }

    static void eat(){

    }

    public abstract void speak();

    // 错误，抽象方法中不能有实现
//    public abstract void sleep(){
//
//    }
}