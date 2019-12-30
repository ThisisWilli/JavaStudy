package com.study.thread.blockQueue;

import sun.reflect.generics.scope.DummyScope;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.blockQueue
 * \* author: Willi Wei
 * \* date: 2019-12-29 19:18:04
 * \* description:
 * \
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;

    // 等价于jdk11中的Path.of()
    private static final Path DUMMY = FileSystems.getDefault().getPath("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("输入根目录");
            String directory = in.nextLine();
            System.out.print("输入关键字");
            String keyword = in.nextLine();
            Runnable enumerator = ()->{
                try {
                    enumerate(FileSystems.getDefault().getPath(directory));
                    // 生产者枚举子目录下所有文件并将他们放到一个阻塞队列中
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            };

            new Thread(enumerator).start();
            for (int i = 1; i <= SEARCH_THREADS; i++){
                Runnable searcher = ()->{
                    try {
                        boolean done = false;
                        while (!done){
                            Path file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else {
                                search(file, keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * 递归遍历所有所给目录以及子目录中的文件
     * @param directory
     * @throws InterruptedException
     * @throws IOException
     */
    public static void enumerate(Path directory) throws InterruptedException, IOException {
        try (Stream<Path> children = Files.list(directory)){
            for (Path child : children.collect(Collectors.toList())){
                if (Files.isDirectory(child)){
                    enumerate(child);
                }else {
                    queue.put(child);
                }
            }
        }
    }

    /**
     * 通过关键字在文件中查找，并打印相关的行
     * @param file
     * @param keyword
     * @throws IOException
     */
    public static void search(Path file, String keyword) throws IOException{
        try (Scanner in = new Scanner(file, String.valueOf(StandardCharsets.UTF_8))){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)){
                    System.out.printf("%s:%d:%s%n", file, lineNumber, line);
                }
            }
        }
    }
}