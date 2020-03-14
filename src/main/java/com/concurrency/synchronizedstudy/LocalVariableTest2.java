package com.concurrency.synchronizedstudy;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-14 14:37
 **/

/**
 * 局部变量应用的是一个对象
 */
public class LocalVariableTest2 {

    static final int THREAD_NUM = 2;
    static final int LOOP_NUM = 200;

    public static void main(String[] args) {
        ThreadUnsafe test = new ThreadUnsafe();
        for (int i = 0; i < THREAD_NUM; i++){
            new Thread(()->{
                test.method1(LOOP_NUM);
            }, "Thread" + i + 1).start();
        }
    }

}

class ThreadUnsafe{
    ArrayList<Integer> list = new ArrayList<>();
    public void method1(int loopNumber){
        for (int i = 0; i < loopNumber; i++){
            method2();
            method3();
        }
    }

    public void method2(){
        list.add(1);
    }

    public void method3(){
        list.remove(0);
    }
}


