package com.wcy;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOM{

    }

    public static void main(String[] args) {
        List<OOM> list = new ArrayList<>();
        while (true){
            list.add(new OOM());
        }
    }
}
