package com.concurrency.futurestudy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.futurestudy
 * \* author: Willi Wei
 * \* date: 2020-08-21 22:47:35
 * \* description:
 * \
 */
public class FutureStudy {
    static int result = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> runnableTask = new FutureTask<Integer>(new Runnable() {
            @Override
            public void run() {
                result = 100000;
            }
        }, result);

        FutureTask<String> callableTask = new FutureTask<>(() -> {
            return "callable";
        });
        runnableTask.run();
        Integer integer = runnableTask.get();
        System.out.println(integer);
        callableTask.run();
        String s = callableTask.get();
        System.out.println("=====" + s);
    }
}