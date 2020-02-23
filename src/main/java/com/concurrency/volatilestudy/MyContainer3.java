package com.concurrency.volatilestudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-23 12:55
 **/

/**
 * 上一个程序的再次升级版，记住wait方法释放锁，sleep和notify都不释放所
 */
public class MyContainer3 {

    private volatile int count = 0;

    public static void main(String[] args) {
        MyContainer3 containter3 = new MyContainer3();
        new Thread(()->{
            synchronized (containter3){
                try {
                    for (int i = 0; i <10; i++){
                        if (containter3.count == 5){
                            // 释放锁
                            containter3.wait();
                        }
                        System.out.println(containter3.count);
                        containter3.count++;
                        Thread.sleep(1000);
                    }
                    // 叫醒为他沉睡的线程2
                    containter3.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1").start();

        new Thread(()->{
//            while (true){
//                if (containter3.count == 5){
//                    System.out.println("线程2结束");
//                    break;
//                }
//            }
            synchronized (containter3){
                try {
                    if (containter3.count == 5){
                        System.out.println("线程2结束");
                    }
                    containter3.notify();
                    containter3.wait();
                    System.out.println("但是我线程2还是要执行一下哈哈哈，先不释放锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t2").start();
    }
}
