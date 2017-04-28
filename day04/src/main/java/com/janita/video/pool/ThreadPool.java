package com.janita.video.pool;

/**
 * Created by Janita on 2017-04-28 14:30
 */
public class ThreadPool {

    public static void main(String[] args){
        /**
         * 4核CPU
         */
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("*******"+cpuNums);
    }
}