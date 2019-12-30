package com.study.thread.createThread;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.createThread
 * \* author: Willi Wei
 * \* date: 2019-12-27 14:36:20
 * \* description:创建一个线程方法一：继承Thread并重写run方法，因为Thread类中实现了Runnable接口，具体步骤如下
 *                                   1、创建线程类继承Thread类，并重写run方法
 *                                   2、实例化线程对象
 *                                   3、调用线程对象中的start方法来启动线程
 *
 * \
 */


class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("启动一个线程.....");
    }
}

public class Method1 extends Thread{
    public static void main(String[] args) {
        new Thread1().start();
    }
}