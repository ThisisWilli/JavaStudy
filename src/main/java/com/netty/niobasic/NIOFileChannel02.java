package com.netty.niobasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * \* project: JavaStudy
 * \* package: com.netty.niobasic
 * \* author: Willi Wei
 * \* date: 2020-09-24 16:20:30
 * \* description:
 * \
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        // 1. 创建文件的输入流
        File file = new File("data/input");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 2. 通过fileInputStream获取对应的FileChannel
        FileChannel fileChannel = fileInputStream.getChannel();
        // 3. 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 4. 将通道中的数据读入到buffer
        fileChannel.read(byteBuffer);
        // 5. 将byteBuffer的字节数据转换成String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}