package com.janita.video.thread;

import java.util.Random;

/**
 * Created by Janita on 2017-04-28 11:19
 */
public class ImplementThread implements Runnable {
    private int x;

    public ImplementThread(int x){
        this.x = x;
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " 线程的run方法调用 ....");
        for (int i=0;i<10;i++){
            System.out.println("*******"+ x);
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        Thread thread1 = new Thread(new ImplementThread(1),"name1");
        Thread thread2 = new Thread(new ImplementThread(2),"name2");
        thread1.start();
        thread2.start();
    }
}
