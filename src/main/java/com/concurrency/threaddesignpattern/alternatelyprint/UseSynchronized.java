package com.concurrency.threaddesignpattern.alternatelyprint;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-22 13:01
 **/

public class UseSynchronized {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(1, 5);
        new Thread(()->{
            wn.print("a", 1, 2);
        }).start();
        new Thread(()->{
            wn.print("b", 2, 3);
        }).start();
        new Thread(()->{
            wn.print("c", 3, 1);
        }).start();
    }
}

/**
 * 三个线程交替打印abc
 * 输出内容   等待标记   下一个标记
 *   a         1          2
 *   b         2          3
 *   c         3          1
 */
class WaitNotify{

    private int flag;
    private int loopNumber;

    public void print(String str, int waitFlag, int nextFlag){
        for (int i = 0; i < loopNumber; i++){
            synchronized (this){
                while (flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}