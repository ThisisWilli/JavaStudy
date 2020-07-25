package com.coding.leetcode.concurrency.Foo;

import java.util.concurrent.Semaphore;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.concurrency
 * \* author: Willi Wei
 * \* date: 2020-07-24 14:44:25
 * \* description:
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 *
 * 注意:
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 *
 * 你看到的输入格式主要是为了确保测试的全面性。
 * \
 */
public class Foo {

//    private AtomicInteger firstJobDone = new AtomicInteger(0);
//    private AtomicInteger secondJobDone = new AtomicInteger(0);

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        firstJobDone.incrementAndGet();
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
//        while (firstJobDone.get() != 1){
////            System.out.println("second");
//        }
//        printSecond.run();
//        secondJobDone.incrementAndGet();
        s1.acquire();
        printSecond.run();
        s2.release();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

//        while (secondJobDone.get() != 1){
////            System.out.println("third");
//        }
//        printThird.run();

        s2.acquire();
        printThird.run();


    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable printOne = () -> {
            System.out.println("one");
        };

        Runnable printTwo = () -> {
            System.out.println("two");
        };

        Runnable printThree = () -> {
            System.out.println("three");
        };

        new Thread(()->{
            try {
                foo.second(printTwo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                foo.first(printOne);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                foo.third(printThree);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

