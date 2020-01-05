package com.study.abstractAndInterface.interfaceTest;

/**
 * \* project: JavaStudy
 * \* package: com.study.abstractAndInterface.interfaceTest
 * \* author: Willi Wei
 * \* date: 2020-01-05 19:48:20
 * \* description:
 * \
 */
public interface Person {
    // 不能定义构造器和初始化块
    // 默认为public static final
    int a = 0;

    /**
     * 抽象方法
     */
    public void fun();

}