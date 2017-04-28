package com.janita.video.activemq;

import javax.jms.JMSException;

/**
 * Created by Janita on 2017-04-28 17:18
 */
public class ConsumerTest implements Runnable{

    static Thread t1 = null;

    public static void main(String[] args) {
        t1 = new Thread(new ConsumerTest());
        t1.setDaemon(false);
        t1.start();
    }

    @Override
    public void run() {
        ConsumerTool consumer = new ConsumerTool();
        try {
            consumer.consumeMessage();
        } catch (JMSException e) {
            e.printStackTrace();
            while (ConsumerTool.isConnection){

            }
        }
    }
}
