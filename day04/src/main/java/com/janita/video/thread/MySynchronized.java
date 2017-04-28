package com.janita.video.thread;

/**
 * Created by Janita on 2017-04-28 11:27
 *
 * 两个线程同时操作同一个synchronized时只能一个线程运行完了，另外一个线程才能运行
 * 但是前者抛出异常了，则马上释放锁
 */
public class MySynchronized {

    public static void main(String[] args){

        final MySynchronized mySynchronized1 = new MySynchronized();
        final MySynchronized mySynchronized2 = new MySynchronized();

        new Thread("thread1"){
            @Override
            public void run() {
                synchronized (mySynchronized1){
                    try {
                        System.out.println("******* "+this.getName()+" start");
                        Thread.sleep(5000);
                        System.out.println("******* "+this.getName()+" 运行了");
                        System.out.println("******* "+this.getName()+" end");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("thread2"){
            @Override
            public void run() {

                /**
                 * mySynchronized2
                 * 两个不同的对象不会锁
                 */
                synchronized ((mySynchronized2)){
                    System.out.println("******* " +this.getName() +" start");
                }
            }
        }.start();
    }
}
