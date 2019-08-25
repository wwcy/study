package com.wcy;

public class JavaVMStack {

    private int stackLength = 0;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JavaVMStack stack = new JavaVMStack();
        try{
            stack.stackLeak();
        }catch (Throwable e){
            System.out.println(stack.stackLength);
            throw e;
        }
    }
}
