package com.concurrency.threadpoolstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 11:47
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 计算从1到200000中间所有的质数
 */
public class ParallelCompute {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> result = getPrime(1, 4000000);
        long end = System.currentTimeMillis();
        System.out.println("单线程耗时" + (end - start) + "ms " + "质数个数为" + result.size());

        final int cpuCoreNum = 4;

        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        Future<List<Integer>> f1 = service.submit(new MyTask(1, 1000000));
        Future<List<Integer>> f2 = service.submit(new MyTask(1000001, 2000000));
        Future<List<Integer>> f3 = service.submit(new MyTask(2000001, 3000000));
        Future<List<Integer>> f4 = service.submit(new MyTask(3000001, 4000000));

        start = System.currentTimeMillis();
        int size1 = f1.get().size();
        int size2 = f2.get().size();
        int size3 = f3.get().size();
        int size4 = f4.get().size();
        end = System.currentTimeMillis();

        System.out.println("多线程耗时" + (end - start) + "ms " + "质数个数为" + (size1 + size2 + size3 + size4));
        service.shutdown();
    }

    static boolean isPrime(int num){
        for (int i = 1; i /*<= num*/<= Math.sqrt(num) + 1; i++){
            if (num % 2 == 0){
                return false;
            }
        }
        return true;
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> result = getPrime(startPos, endPos);
            return result;
        }
    }

    static List<Integer> getPrime(int start, int end){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++){
            if (isPrime(i)){
                result.add(i);
            }
        }
        return result;
    }
}
