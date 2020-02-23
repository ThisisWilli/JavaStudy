package com.concurrency.volatilestudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-23 12:43
 **/

/**
 * 两个线程，一个线程将一个变量++，当变量值达到固定值时，第二个线程停止
 */
public class MyContainer {

    private int count = 0;

    public static void main(String[] args) {
        MyContainer containter = new MyContainer();
        new Thread(()->{
            try {
                for (int i = 0; i <10; i++){
                    System.out.println(containter.count);
                    containter.count++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            while (true){
                if (containter.count == 5){
                    System.out.println("线程2结束");
                    break;
                }
            }
        }, "t2").start();
    }
}
