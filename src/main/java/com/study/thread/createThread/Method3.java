package com.study.thread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.createThread
 * \* author: Willi Wei
 * \* date: 2019-12-30 11:23:43
 * \* description:利用Callable的方法创建线程，需要依赖future task
 * \
 */
public class Method3 {
    public static void main(String[] args) {
        Callable c = ()->{
            int sum = 0;
            for (int i = 0; i < 100; i++){
                sum += i;
            }
            System.out.println("sum = " + sum);
            return sum;
        };
        FutureTask<Integer> task = new FutureTask<Integer>(c);
        task.run();
    }
}