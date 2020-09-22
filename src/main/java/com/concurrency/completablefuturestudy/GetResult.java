package com.concurrency.completablefuturestudy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 16:12:27
 * \* description:
 * \
 */
public class GetResult {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        });

        System.out.println(future1.getNow("can't wait just get now"));

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> f2 = f1.whenComplete((v, e) -> {
            System.out.println("result = " + v + " exception = " + e);
        });
        System.out.println(f2.get());
    }
}