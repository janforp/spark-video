package com.janita.video.thread;

/**
 * Created by Janita on 2017-04-28 11:27
 */
public class MySynchronized {

    public static void main(String[] args){
        final MySynchronized mySynchronized = new MySynchronized();
        final MySynchronized mySynchronized1 = new MySynchronized();

        new Thread("thread1"){
            @Override
            public void run() {
                synchronized (mySynchronized){
                    try {
                        System.out.println("******* "+this.getName()+" start");
                        Thread.sleep(5000);
                        System.out.println("******* "+this.getName()+" 行了");
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
                synchronized ((mySynchronized)){
                    System.out.println("******* " +this.getName() +" start");
                }
            }
        }.start();
    }
}
