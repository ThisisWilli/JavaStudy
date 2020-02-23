package com.concurrency.volatilestudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-23 12:53
 **/

/**
 * 上一个版本的增强版，使用volatile函数
 */
public class MyContainer2 {
    private volatile int count = 0;

    public static void main(String[] args) {
        MyContainer2 containter2 = new MyContainer2();
        new Thread(()->{
            try {
                for (int i = 0; i <10; i++){
                    System.out.println(containter2.count);
                    containter2.count++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            while (true){
                if (containter2.count == 5){
                    System.out.println("线程2结束");
                    break;
                }
            }
        }, "t2").start();
    }
}
