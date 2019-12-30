package com.study.thread.createThread;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.createThread
 * \* author: Willi Wei
 * \* date: 2019-12-27 14:42:47
 * \* description:创建一个线程方法二：创建一个类实现Runnable接口并重写run方法，将其作为参数传入Thread的构造器中从而创建一个线程
 *                1、定义一个类实现Runnable接口，并重写接口中的run方法
 *                2、创建Runnable的实现类对象，作为Thread类构造器的参数，此Thread才是真正的线程对象
 * \
 */
class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "is runnning");
        }
    }
}
public class Method2{
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        new Thread(thread2, "线程一").start();
        new Thread(thread2, "线程二").start();
    }
}