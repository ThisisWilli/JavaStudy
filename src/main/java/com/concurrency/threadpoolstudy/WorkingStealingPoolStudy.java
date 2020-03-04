package com.concurrency.threadpoolstudy;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 13:56
 **/

public class WorkingStealingPoolStudy {
    // 任务分配不均匀的场景
     static class R implements Runnable{
        int time;
        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool(4);
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 线程1处理的任务时间比任务2长，启动线程为一个daemon线程，虚拟机不结束永远不停止运行
        service.execute(new R(3000));
        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(4000));
        // 等4个线程都分配到任务执行之后，线程2抢占任务执行
        service.execute(new R(5000));
        service.execute(new R(6000));
        System.in.read();
    }
}
