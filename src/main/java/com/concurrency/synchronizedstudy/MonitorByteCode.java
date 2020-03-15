package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-15 13:42
 **/

public class MonitorByteCode {
    static final Object lock = new Object();

    public static void method1(){
        synchronized (lock){
            method2();
        }
    }

    public static void method2(){

    }
}
