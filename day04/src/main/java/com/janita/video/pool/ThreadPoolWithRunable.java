package com.janita.video.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janita on 2017-04-28 14:41
 */
public class ThreadPoolWithRunable {

    public static void main(String[] args){
        //创建一个线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //提交4个任务
        for (int i = 0 ;i < 5; i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("******* thread name: " +Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
