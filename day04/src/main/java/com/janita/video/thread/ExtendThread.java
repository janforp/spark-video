package com.janita.video.thread;

import java.util.Random;

/**
 * Created by Janita on 2017-04-28 11:14
 */
public class ExtendThread extends Thread {

    private String flag;

    public ExtendThread(String flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " 线程的run方法调用 ....");
        for (int i=0;i<20;i++){
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tName + "*******" + flag);
        }
    }

    public static void main(String[] args){

        Thread thread = new ExtendThread("a");
        Thread thread1 = new ExtendThread("b");
        thread.start();
        thread1.start();
    }
}
