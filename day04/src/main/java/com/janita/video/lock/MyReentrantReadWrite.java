package com.janita.video.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Janita on 2017-04-28 14:02
 * 使用读写锁，可以实现读写锁分离，读操作并发进行，写操作锁定单个线程
 *
 * 如果有一个线程已经占用了读锁，则此时其他线程如果申请写锁，则申请写锁的线程会一直等待释放读锁
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请读锁或者写锁，则申请的线程会一直等待释放写锁
 */
public class MyReentrantReadWrite {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args){
        final MyReentrantReadWrite reentrantReadWrite = new MyReentrantReadWrite();
        new Thread("one"){
            @Override
            public void run() {
                reentrantReadWrite.get(Thread.currentThread());
                reentrantReadWrite.write(Thread.currentThread());
            }
        }.start();

        new Thread("two"){
            @Override
            public void run() {
                reentrantReadWrite.get(Thread.currentThread());
                reentrantReadWrite.write(Thread.currentThread());
            }
        }.start();
    }

    private void write(Thread thread) {
        lock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println("*******"+thread.getName()+" 正在进行读操作");
            }
            System.out.println("*******"+thread.getName()+" 读操作完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    private void get(Thread thread) {
        lock.writeLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println("*******"+thread.getName()+" 正在进行写操作");
            }
            System.out.println("*******"+thread.getName()+" 写操作完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
