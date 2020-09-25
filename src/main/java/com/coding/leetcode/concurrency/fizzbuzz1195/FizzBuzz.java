package com.coding.leetcode.concurrency.fizzbuzz1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.concurrency.fizzbuzz1195
 * \* author: Willi Wei
 * \* date: 2020-07-28 14:19:20
 * \* description:
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only input "fizz"
 *   public void buzz(printBuzz) { ... }          // only input "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only input "fizzbuzz"
 *   public void number(printNumber) { ... }      // only input the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整
 * \
 */
class FizzBuzz {
    // Initialize the permit, limit to one.
    private Semaphore sema = new Semaphore(1);

    // The current number.
    private int curNum = 1;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;) {
            // Acquire the permit, try to run the logic exclusively.
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                    printFizz.run();
                    this.curNum++;
                }
            } finally {
                // Release the permit anyway.
                this.sema.release(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                    printBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                    printFizzBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                    printNumber.accept(this.curNum);
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }
}
