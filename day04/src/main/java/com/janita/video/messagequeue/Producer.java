package com.janita.video.messagequeue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Janita on 2017-04-28 15:27
 */
public class Producer implements Runnable{

    private BlockingQueue<String> queue;
    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            System.out.println("*******I hava made a product: "+ Thread.currentThread().getName());
            String temp = "A Product,生产线程："+Thread.currentThread().getName();
            queue.put(temp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
