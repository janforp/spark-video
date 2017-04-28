package com.janita.video.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Janita on 2017-04-28 17:18
 */
public class ConsumerTool implements MessageListener,ExceptionListener{

    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    //主题
    private String subject = "mytopic";
    private Destination destination = null;
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer consumer = null;
    public static Boolean isConnection = false;

    /**
     * 初始化
     * @throws JMSException
     */
    private void initialize() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user,password,url);
        connection = connectionFactory.createConnection();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        destination = session.createTopic(subject);
        consumer = session.createConsumer(destination);
    }

    public void consumeMessage() throws JMSException {
        initialize();
        connection.start();
        consumer.setMessageListener(this);
        connection.setExceptionListener(this);
        isConnection = true;
        System.out.println("Consumer:-> Begin listening ...");
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Consumer:-> consume "+ message);
    }

    @Override
    public void onException(JMSException e) {

    }
}
