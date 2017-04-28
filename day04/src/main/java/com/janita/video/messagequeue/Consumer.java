package com.janita.video.messagequeue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Janita on 2017-04-28 15:27
 */
public class Consumer implements Runnable {
    private BlockingQueue<String> queue;
    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("*******"+Thread.currentThread().getName());
            String temp = queue.take();
            System.out.println("*******"+temp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
