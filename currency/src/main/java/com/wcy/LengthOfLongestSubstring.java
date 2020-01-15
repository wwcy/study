package com.wcy;

import java.util.*;

/**
 * @auth wcy on 2020/1/14.
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        String str = "au";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
       byte[] bytes = s.getBytes();
        //有重复字符
        int max0 = Integer.MIN_VALUE;
        //无重复字符
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < bytes.length; i++) {
            List<Byte> list = new ArrayList<>(16);
            list.add(bytes[i]);
            for (int j = i+1; j < bytes.length; j++) {
               if(list.contains(bytes[j])){
                   int size = list.size();
                   max0 = max0 <  size ? size : max0;
                    break;
               }else {
                   list.add(bytes[j]);
               }
            }
            int size1 = list.size();
            if(size1 >= 0){
                max1  = max1 <  size1 ? size1 : max1;
            }
        }
        return max0 <  max1 ? max1 : max0;
    }
}
