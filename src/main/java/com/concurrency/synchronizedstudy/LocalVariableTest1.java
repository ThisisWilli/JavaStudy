package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-14 14:33
 **/

public class LocalVariableTest1 {
    public static void test1(){
        int i = 10;
        i++;
    }

    public static void main(String[] args) {
        new Thread(()->{
            test1();
        }, "t1").start();

        new Thread(()->{
            test1();
        }, "t2").start();
    }
}
