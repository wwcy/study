package io.grpc.examples;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

import java.util.concurrent.TimeUnit;

/**
 * @auth wcy on 2020/1/9.
 */
public class client {

    private ManagedChannel channel;
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    public client(String host,int port){
        channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext().build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply reply = blockingStub.sayHello(request);
        System.out.println(reply.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        client client = new client("127.0.0.1",50051);
        try{
            client.greet("world");
        }finally {
            client.shutdown();
        }
    }
}
