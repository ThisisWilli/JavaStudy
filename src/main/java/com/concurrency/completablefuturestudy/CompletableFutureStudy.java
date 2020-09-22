package com.concurrency.completablefuturestudy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 14:11:42
 * \* description:
 * \
 */
public class CompletableFutureStudy {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // 2. 使用runAsync执行异步计算，返回的是CompletableFuture对象
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("run Async");
        });


        // 3. 使用supplyAsync()运行一个异步任务并且有返回结果
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "the result of supplyAsync");
        System.out.println(future1.get());

        // 4. 创建一个线程池传递给
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Result of the asynchronous computation"
                , Executors.newFixedThreadPool(10));
        System.out.println(future3.get());
    }
}