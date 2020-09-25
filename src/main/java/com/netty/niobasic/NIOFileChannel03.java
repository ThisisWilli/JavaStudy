package com.netty.niobasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * \* project: JavaStudy
 * \* package: com.netty.niobasic
 * \* author: Willi Wei
 * \* date: 2020-09-24 16:30:42
 * \* description:
 * \
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("data/input.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("data/output.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){
            // 先清空buffer
            byteBuffer.clear();

            // 通过Channel01将数据读到缓冲区中
            int read = fileChannel01.read(byteBuffer);
            System.out.println("read = " + read);
            if (read == -1){
                break;
            }
            // 将buffer中的数据写入到fileChannel-2中
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }
        // 关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}