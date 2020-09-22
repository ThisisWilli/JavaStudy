package com.concurrency.completablefuturestudy;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 16:44:15
 * \* description:
 * \
 */
public class TheCombineTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(TheCombineTest::randomInteger)
                .thenCombine(CompletableFuture.supplyAsync(TheCombineTest::randomInteger), (i, j) -> i * j);
        System.out.println(future.get());
    }

    public static Integer randomInteger(){
        return 100;
    }
}