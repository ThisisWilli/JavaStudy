package com.concurrency.volatilestudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 22:09
 **/

public class VolatileTest {
    public volatile static int x = 1;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            new Thread(()->{
                if (x == 1){
                    x++;
                    System.out.println(Thread.currentThread().getName() + "执行了该操作");
                }
            }).start();
        }
    }
}
