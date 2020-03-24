package com.concurrency.synchronizedstudy;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-24 11:48
 **/

public class HappensBefore {

    static int x;
    static int y;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            y = 10;
            x = 20;
        }, "t1").start();

        new Thread(()->{
            // x = 20对t2可见，同时y=10也对t2可见
            System.out.println(x);
        }, "t2").start();
    }
}
