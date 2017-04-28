package com.janita.video.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janita on 2017-04-28 13:36
 *
 * @see java.util.concurrent.locks.Lock;
 */
public class MyInterruptibly {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args){
        MyInterruptibly test = new MyInterruptibly();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        thread2.interrupt();
        System.out.println("******* ==============");
    }

    void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("*******"+thread.getName() + " 得到了锁");
            long start = System.currentTimeMillis();

            //这个线程一直在睡
            for ( ; ;){
                if (System.currentTimeMillis() - start >=Integer.MAX_VALUE)
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("*******"+Thread.currentThread().getName()+" 执行finally中代码");
            lock.unlock();
            System.out.println("*******"+thread.getName()+" 释放了锁");
        }
    }
}

class MyThread extends Thread{
    private MyInterruptibly test = null;
    public MyThread(MyInterruptibly test){
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        }catch (Exception e){
            System.out.println("*******"+Thread.currentThread().getName() + " 被中断");
        }
    }
}
