package com.concurrency.threadpoolstudy;

import java.util.concurrent.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 11:29
 **/

public class FutureStudy {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(2);
            return 1000;
        });

        new Thread(task).start();

        // 这是一个阻塞方法，等任务执行完了之后再去拿到那个值
        System.out.println(task.get());

//        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService service = new ThreadPoolExecutor(4, 6, 2L, TimeUnit.SECONDS
                , new LinkedBlockingDeque<Runnable>());
        Future<Integer> f = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        // 阻塞线程，等submit执行之后，再取值
        System.out.println(f.get());

        // 之间判断submit有没有执行完
        System.out.println(f.isDone());
    }
    
}
