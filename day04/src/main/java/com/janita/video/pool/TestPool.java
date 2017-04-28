package com.janita.video.pool;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Janita on 2017-04-28 14:56
 */
public class TestPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<?> submit;
        ArrayList<Future<?>> results = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i =0; i < 10; i ++){
            submit =  service.submit(new TaskCallable(i));
            results.add(submit);
        }
        for (Future future : results){
            boolean done = future.isDone();
            System.out.println(done?"已完成":"未完成");
            System.out.println("*******future结果："+future.get());
        }
        service.shutdown();
    }
}

class TaskCallable implements Callable<String>{
    private int s;
    Random r = new Random();
    public TaskCallable(int s){
        this.s = s;
    }
    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        long now = System.currentTimeMillis();
        System.out.println("*******name: "+ name +" 启动时间： "+now/1000);

        int rInt = r.nextInt(3);
        try {
            Thread.sleep(rInt*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("*******"+name+" is wording..."+s);
        return s+"";
    }
}
