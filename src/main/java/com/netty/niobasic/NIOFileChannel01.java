package com.netty.niobasic;

import io.netty.buffer.ByteBuf;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * \* project: JavaStudy
 * \* package: com.netty.niobasic
 * \* author: Willi Wei
 * \* date: 2020-09-24 14:41:46
 * \* description:
 * \
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello，尚硅谷";
        // 1. 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("data/input");
        // 2. 通过fileOutputStream对象获取对应的FileChannel， fileChannel真实类型是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();
        // 3. 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 4. 将str放入缓冲区
        byteBuffer.put(str.getBytes());
        // 5. 对byteBuffer进行flip
        byteBuffer.flip();
        // 6. 将byteBuffer数据写入到FileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}