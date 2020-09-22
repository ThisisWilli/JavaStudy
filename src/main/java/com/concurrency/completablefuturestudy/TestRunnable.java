package com.concurrency.completablefuturestudy;

import java.util.concurrent.Callable;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 11:10:05
 * \* description:
 * \
 */
public class TestRunnable{


    public static void main(String[] args) throws Exception {

        int result = 0;
        innerRunnableAdapter<Integer> adapter = new innerRunnableAdapter<>(() -> {
            System.out.println("this is runnable");
        }, result);
        Integer integer = adapter.call();
        System.out.println(integer);

    }

    static final class innerRunnableAdapter<T> implements Callable<T>{
        final Runnable task;
        final T result;

        public innerRunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }

        @Override
        public T call() throws Exception {
            task.run();
            return result;
        }
    }
}