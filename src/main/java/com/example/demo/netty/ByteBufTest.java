package com.example.demo.netty;

import io.netty.buffer.*;

import java.nio.charset.Charset;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-12
 * @Version 1.0
 */
public class ByteBufTest {

    public static void main(String[] args) {
        CompositeByteBuf byteBufs = Unpooled.compositeBuffer();
        ByteBuf buf = Unpooled.copiedBuffer("dfdfdfd", Charset.forName("UTF-8"));


    }
}
