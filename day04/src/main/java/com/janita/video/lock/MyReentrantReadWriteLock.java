package com.janita.video.lock;

/**
 * Created by Janita on 2017-04-28 13:55
 * @see java.util.concurrent.locks.ReentrantReadWriteLock;
 */
public class MyReentrantReadWriteLock {

    public static void main(String[] args){
        final MyReentrantReadWriteLock test = new MyReentrantReadWriteLock();

        new Thread("one"){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread("two"){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }


    /**
     * 读写不分离的
     * @param thread
     */
    public synchronized void get(Thread thread){
         long start = System.currentTimeMillis();
         int i=0;
         while (System.currentTimeMillis() - start <= 1){
             i++;
             if (i % 4 == 0){
                 System.out.println("******* " + thread.getName() +" 正在进行写操作");
             }else {
                 System.out.println("******* " + thread.getName() +" 正在进行读操作");
             }
         }
         System.out.println("******* " + thread.getName() +" 读写操作完成");
     }
}
