package com.study.thread.executor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.executor
 * \* author: Willi Wei
 * \* date: 2019-12-30 13:57:09
 * \* description:利用线程池对线程进行操作，统计一个目录树中包含一个给定单词的文件的个数，具体步骤如下
 *                  1、利用Callable接口为每个任务创建线程，将寻找关键词的方法传入，将所有线程添加到一个ArrayList中
 *                  2、创建一个线程池，并通过invokeAll方法提交线程集合，执行所有任务，并返回一个Future结合，即每个线程对应的处理结果
 *
 * \
 */
public class ExecutorDemo {

    /**
     * 返回目录树中word的出现次数
     * @param word
     * @param path
     * @return
     */
    public static long occurrences(String word, Path path){
        try (Scanner in = new Scanner(path)){
            int count = 0;
            while (in.hasNext()){
                if (in.next().equals(word)){
                    count++;
                }
            }
            return count;
        }catch (IOException e){
            e.printStackTrace();
            return 0;
        }
    }

    /***
     * 给出根目录下的所有文件名称
     * @param rootDir
     * @return
     * @throws IOException
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try(Stream<Path> entries = Files.walk(rootDir)){
            return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
        }
    }

    /**
     * 新建一个在文件中搜索单词的任务
     * @param word
     * @param path
     * @return
     */
    public static Callable<Path> searchForTask(String word, Path path){
        return ()->{
            try(Scanner in = new Scanner(path)) {
                while (in.hasNext()){
                    if (in.next().equals(word)){
                        return path;
                    }
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Search in" + path + " canceled.");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) {
        try(Scanner in = new Scanner((System.in))){
            // 输入
            System.out.print("Enter base directory");
            String start = in.nextLine();
            System.out.print("enter the key word");
            String word = in.nextLine();

            Set<Path> files = descendants(FileSystems.getDefault().getPath(start));

            // 为每个文件建立了一个单独的任务
            ArrayList<Callable<Long>> tasks = new ArrayList<>();
            for (Path file : files){
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            // 创建一个线程池，把这些建立的任务传递到一个执行器服务
            ExecutorService executor = Executors.newCachedThreadPool();
            Instant startTime = Instant.now();
            /**
             * invokeAll方法提交一个Callable对象集合中的所有对象，这个方法会阻塞，直到所有任务都完成、
             * 并返回表示所有任务答案的一个Future列表
             */
            List<Future<Long>> results = executor.invokeAll(tasks);
            int total = 0;
            // 为了得到组合后的统计结果，要将所有结果相加，这个工作会阻塞，直到所有结果都可用
            for (Future<Long> result : results){
                // 第一个get方法会阻塞，知道第一个结果可用
                total += result.get();
            }
            Instant endTime = Instant.now();
            System.out.println("Occurrences of " + word + ": " + total);
            System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + "ms");
            ArrayList<Callable<Path>> searchTasks = new ArrayList<>();
            for (Path file : files){
                searchTasks.add(searchForTask(word, file));
            }
            // 一旦有任务返回，invokeAny方法就会终止，能让搜索任务返回一个boolean来指示成功或失败，失败的任务要抛出异常
            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " occurs in: " + found);

            //程序打印执行期间线程池的最大大小，要将线程池对象强制转换成ThreadPoolExecutor类
            if (executor instanceof ThreadPoolExecutor){
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor)executor).getLargestPoolSize());
            }
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}