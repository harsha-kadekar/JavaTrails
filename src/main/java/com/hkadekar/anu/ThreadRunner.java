package com.hkadekar.anu;

public class ThreadRunner {
    public static void main(String[] args){
        SimpleThreadingExample simpleThreadingExample = new SimpleThreadingExample();
        simpleThreadingExample.start();

        try{
            int i = 0;
            while(i <= 10){
                Thread.sleep(20000);
                i++;

            }
        } catch (Exception exp){

        }

        simpleThreadingExample.shutdown();

    }
}
