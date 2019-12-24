package com.wcy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioApplication {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new  RandomAccessFile("test.txt","rw");
		FileChannel channel = file.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(48);
		int size = channel.read(buffer);
		while (size != -1){
			buffer.flip();
			while (buffer.hasRemaining()){
				System.out.println((char) buffer.get());
			}
			buffer.clear();
			size = channel.read(buffer);
		}
		file.close();
	}

}
