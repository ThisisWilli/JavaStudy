package com.jvm;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-13 13:10
 **/

public class NativeTest {
    public static void main(String[] args) {
        new Thread(()->{

        }, "my thread name").start();
    }
}
