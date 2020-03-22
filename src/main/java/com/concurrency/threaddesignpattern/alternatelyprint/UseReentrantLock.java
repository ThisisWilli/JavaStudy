package com.concurrency.threaddesignpattern.alternatelyprint;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-22 13:14
 **/

public class UseReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(3, 1);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();

        new Thread(()->{
            awaitSignal.print("b", 2, 3, b, a, c);
        }).start();

        new Thread(()->{
            awaitSignal.print("a", 1, 2, a, b, c);
        }).start();

        new Thread(()->{
            awaitSignal.print("c", 3, 1, c, a, b);
        }).start();

        TimeUnit.SECONDS.sleep(2);
        try {
            awaitSignal.lock();
            System.out.println("start...");
            b.signal();
        } finally {
            awaitSignal.unlock();
        }
    }

}
/**
 * 三个线程交替打印abc
 * 输出内容   等待标记   下一个标记
 *   a         1          2
 *   b         2          3
 *   c         3          1
 */
class AwaitSignal extends ReentrantLock{

    private int loopNumber;
    private int flag;

    public void print(String str, int waitFlag, int nextFlag, Condition self, Condition others1, Condition others2){
        for (int i = 0; i < loopNumber; i++){
            try {
                lock();
                while (flag != waitFlag){
                    try {
                        self.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                others1.signalAll();
                others2.signalAll();
            } finally {
                unlock();
            }

        }
    }

    public AwaitSignal(int loopNumber, int flag) {
        this.loopNumber = loopNumber;
        this.flag = flag;
    }
}