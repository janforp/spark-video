package com.janita.video.pool;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017-04-28 14:41
 */
public class ThreadPoolWithCallable {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        //线程池中有4个线程
        ExecutorService pool = Executors.newFixedThreadPool(4);

        //提交10个任务
        for (int i =0; i <10 ;i++){
            //提交任务
            Future<String> submit = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "b -- "+Thread.currentThread().getName();
                }
            });

            System.out.println("*******"+submit.isDone());
            System.out.println("*******"+submit.get());
        }
        pool.shutdown();
    }
}
