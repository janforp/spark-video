package com.janita.video.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janita on 2017-04-28 13:30
 * 多个线程之间根本就没有先后顺序
 *  @see java.util.concurrent.locks.Lock;
 */
public class MyTryLock {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    static Lock lock = new ReentrantLock();

    public static <E> void main(String[] args){
        new Thread("one"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                boolean one = lock.tryLock();
                System.out.println("******* " + one);
                try {
                    System.out.println("******* "+thread.getName() + " 获得了锁");
                    for (int i=0;i<5;i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("*******"+thread.getName() + " 释 放了锁");
                    lock.unlock();
                }
            }
        }.start();

        new Thread("two"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                boolean two = lock.tryLock();
                System.out.println("******* " + two);
                try {
                    System.out.println("******* "+thread.getName() + " 获 得了锁");
                    for (int i=0;i<5;i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("*******"+thread.getName() + " 释放 了锁");
                    lock.unlock();
                }

            }
        }.start();
    }
}
