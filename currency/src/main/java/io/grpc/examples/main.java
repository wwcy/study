package io.grpc.examples;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @auth wcy on 2020/1/9.
 */
public class main {

    private int port = 50051;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port).addService(new main.GreeterImpl()).build().start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop(){
        if(server != null){
            server.shutdown();
        }
    }

    private  void blockUntilShutdown() throws InterruptedException {
        if(server != null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        main main = new main();
        main.start();
        main.blockUntilShutdown();
    }

    private static class  GreeterImpl extends GreeterGrpc.GreeterImplBase{
        //621226 1718004234239
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("hello"+request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
