package com.wcy;

/**
 * @auth wcy on 2019/8/26.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC saveHook= null;

    public void isAlive(){
        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        saveHook = this;
    }

    public static void main(String[] args) throws Exception{
        saveHook = new FinalizeEscapeGC();
        saveHook = null;
        System.gc();
        Thread.sleep(1000);

        if(saveHook != null){
            saveHook.isAlive();
        }else {
            System.out.println("no,i am dead");
        }

        saveHook = null;
        System.gc();
        Thread.sleep(1000);

        if(saveHook != null){
            saveHook.isAlive();
        }else {
            System.out.println("no,i am dead");
        }


    }
}
