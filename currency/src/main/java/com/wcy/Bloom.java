package com.wcy;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @auth wcy on 2019/12/26.
 */
public class Bloom {

    //插入数据
    private static int expectedInsertions = 100;
    //期望的误判率
    private static double fpp = 0.01;

    //bit数组长度
    private static long numBits;

    //hash函数数量
    private static int numHash;


    static {
        numBits = optimalNumOfBits(expectedInsertions, fpp);
        numHash = optimalNumOfHashFunctions(expectedInsertions, numBits);
    }

    public static void main(String[] args) {
        System.out.println(numBits+":"+numHash);
    }

    /**
     * 根据key获取bitmap下标
     */
    private static long[] getIndexs(String key) {
        long hash1 = hash(key);
        long hash2 = hash1 >>> 16;
        long[] result = new long[numHash];
        for (int i = 0; i < numHash; i++) {
            long combinedHash = hash1 + i * hash2;
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            result[i] = combinedHash % numBits;
        }
        return result;
    }

    private static long hash(String key) {
        Charset charset = Charset.forName("UTF-8");
        return Hashing.murmur3_128().hashObject(key, Funnels.stringFunnel(charset)).asLong();
    }

    //计算hash函数个数
    private static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    //计算bit数组长度
    private static long optimalNumOfBits(long n, double p){
        if(p == 0){
            p = Double.MIN_VALUE;
        }
        return (long)(-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }
}
