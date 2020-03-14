package com.concurrency.synchronizedstudy;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-14 16:45
 **/

public class LocalVariableTest3 {
    static final int THREAD_NUM = 2;
    static final int LOOP_NUM = 200;

    public static void main(String[] args) {
//        ThreadSafe test = new ThreadSafe();
        ThreadSafeSubClass test = new ThreadSafeSubClass();
        for (int i = 0; i < THREAD_NUM; i++){
            new Thread(()->{
                test.method1(LOOP_NUM);
            }, "Thread" + i + 1).start();
        }
    }
}

class ThreadSafe{
    public void method1(int loopNumber){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++){
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<Integer> list){
        list.add(0);
    }

    public void method3(ArrayList<Integer> list){
        list.remove(0);
    }
}

class ThreadSafeSubClass extends ThreadSafe{
    @Override
    public void method3(ArrayList<Integer> list) {
        new Thread(()->{
            list.remove(0);
        }).start();
    }
}