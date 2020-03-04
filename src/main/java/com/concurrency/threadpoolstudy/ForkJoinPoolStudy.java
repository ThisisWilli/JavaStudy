package com.concurrency.threadpoolstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-04 13:45
 **/

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 计算1000000个随机数的和
 */
public class ForkJoinPoolStudy {
    private static int[] nums = new int[1000000];
    private static final int MAX_NUM = 50000;
    private static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("单线程计算数组和为" + Arrays.stream(nums).sum());
    }

//    // 这种方式没有返回值
//    static class AddTask extends RecursiveAction{
//        int start, end;
//
//        public AddTask(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        protected void compute() {
//            if (end - start <= MAX_NUM){
//                long sum = 0;
//                for (int i = start; i < end; i++) {
//                    sum += nums[i];
//                }
//                System.out.println("from " + start + "to " + end + "=" + sum);
//            }else {
//                int mid = start + (end - start) / 2;
//                AddTask subTask1 = new AddTask(start, mid);
//                AddTask subTask2 = new AddTask(mid + 1, end);
//                subTask1.fork();
//                subTask2.fork();
//            }
//        }
//    }

    static class AddTask1 extends RecursiveTask<Long> {
        int start, end;

        public AddTask1(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM){
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
//                System.out.println("from " + start + "to " + end + "=" + sum);
                System.out.println(Thread.currentThread().getName());
                return sum;
            }else {
                int mid = start + (end - start) / 2;
                AddTask1 subTask1 = new AddTask1(start, mid);
                AddTask1 subTask2 = new AddTask1(mid, end);
                subTask1.fork();
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
//        AddTask task = new AddTask(0, nums.length);
//        pool.execute(task);
        // 由于是daemon线程，所以需要阻塞
//        System.in.read();

        AddTask1 task1 = new AddTask1(0, nums.length);
        pool.execute(task1);
        Long result = task1.join();
        System.out.println("多线程计算数组和为" + result);
    }
}
