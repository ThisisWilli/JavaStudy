package com.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     *
     * @param ctx 上下文对象，含有管道pipeline，通道channel地址
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("read thread" + Thread.currentThread().getName());
        log.info("server context = " + ctx);
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();

        // 将msg转换Bytebuf
        ByteBuf buf = (ByteBuf) msg;
        log.info("client send file = " + buf.toString(CharsetUtil.UTF_8));
        log.info("client address = " + channel.remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
