package com.janita.video.activemq;

import javax.jms.JMSException;
import java.util.Random;

/**
 * Created by Janita on 2017-04-28 17:18
 */
public class ProducerTest {

    public static void main(String[] args) throws InterruptedException, JMSException {
        ProducerTool producer = new ProducerTool();
        Random random = new Random();
        for (int i=0;i<20;i++){
            Thread.sleep(random.nextInt(10)*1000);

            producer.produceMessage("Hello, world! -- " + i);
            producer.close();
        }
    }
}
