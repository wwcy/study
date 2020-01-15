package com.wcy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @auth wcy on 2019/12/25.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(10000));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            if(selector.selectNow() > 0){
                Set<SelectionKey> keys =  selector.selectedKeys();
                Iterator<SelectionKey> keyIterator =  keys.iterator();

                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    if(key.isAcceptable()){
                        System.out.println("建立一个连接");
                        SocketChannel client = ((ServerSocketChannel)key.channel()).accept();
                        client.configureBlocking(false);
                        client.register(selector,SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        try{
                            ByteBuffer buffer = ByteBuffer.allocate(10);
                            SocketChannel client = (SocketChannel)key.channel();
                            int size = client.read(buffer);
                            // 检查客户端是否写入数据。
                            if(size == -1){
                              /*  // 关闭通道
                                key.channel().close();
                                // 关闭连接
                                key.cancel();*/
                                break;
                            }
                            buffer.flip();
                            byte[] datas = new byte[buffer.remaining()];
                            // 是将Buffer中的有效数据保存到字节数组中。
                            buffer.get(datas);
                            System.out.println(buffer);
                            buffer.clear();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            key.channel().close();
                            key.cancel();
                        }
                    }
                    keyIterator.remove();
                }
            }
            System.out.println("等待accept");
        }
    }
}
