package com.janita.video.lock;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janita on 2017-04-28 13:22
 *
 * @see java.util.concurrent.locks;
 */
public class MyLock {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    static Lock lock = new ReentrantLock();

    public static <E> void main(String[] args){

        new Thread("one"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println("******* "+thread.getName() + " 获得了锁");
                    for (int i=0;i<5;i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("*******"+thread.getName() + " 释放了锁");
                    lock.unlock();
                }
            }
        }.start();

        new Thread("two"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println("******* "+thread.getName() + " 获 得了锁");
                    for (int i=0;i<5;i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("*******"+thread.getName() + " 释放了锁");
                    lock.unlock();
                }

            }
        }.start();
    }
}
