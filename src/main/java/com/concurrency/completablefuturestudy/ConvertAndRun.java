package com.concurrency.completablefuturestudy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 15:14:07
 * \* description:
 * \
 */
public class ConvertAndRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "first task";
//        });
//
//        CompletableFuture<String> future2 = future1.thenApply(name -> {
//            return "next task" + name;
//        });
//
//        try {
//            System.out.println(future2.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        CompletableFuture.supplyAsync(()->{
//            return "not need callback result";
//        }).thenAccept(product-> System.out.println("get former function result " + product));

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "some Result")
                .thenApplyAsync(result -> result + " processed result");
        System.out.println(future3.get());
    }
}