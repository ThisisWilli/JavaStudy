package com.concurrency.completablefuturestudy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 16:37:24
 * \* description:
 * \
 */
public class ThenComposeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(ThenComposeTest::getInteger)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i * 10));
        System.out.println(f.get());
    }

    public static int getInteger(){
        return 666;
    }

    public static int expandValue(int num){
        return num * 10;
    }
}