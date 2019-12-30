package com.study.thread.createThread;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.createThread
 * \* author: Willi Wei
 * \* date: 2019-12-27 15:06:52
 * \* description:利用lambda表达式创建一个线程
 *                1、首先利用函数时接口船舰一个Runnable实例，因为Runnable接口中有@FunctionalInterface注释，并且只有一个abstract方法
 *                   lambda表达式能够进行推导
 * \
 */
public class Lambda {
    public static void main(String[] args) {
        Runnable r = ()->{
            for(int i = 0; i < 100; i++){
                System.out.println(Thread.currentThread().getName() + "线程启动.....");
            }
        };
        new Thread(r, "one").start();
        new Thread(r, "two").start();
    }
}