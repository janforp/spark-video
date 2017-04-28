package com.janita.video.pool;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017-04-28 14:41
 *
 * callable:有返回结果
 * runnable:无返回，主线程无法获得任务线程的返回值
 * callable的call方法可以返回结果，但是会阻塞主线程
 */
public class ThreadPoolWithCallable {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        //线程池中有4个线程
        ExecutorService pool = Executors.newFixedThreadPool(4);

        //提交10个任务
        for (int i =0; i <10 ;i++){
            //提交任务
            /**
             * 从Future中get结果，会阻塞
             */
            Future<String> submit = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
//                    Thread.sleep(5000);
                    return "b -- "+Thread.currentThread().getName();
                }
            });

//            System.out.println("*******"+submit.isDone());
            System.out.println("*******"+submit.get());
        }
        pool.shutdown();
    }
}
