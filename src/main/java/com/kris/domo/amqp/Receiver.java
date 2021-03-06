package com.kris.domo.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    //接收到消息处理.
    @RabbitListener(queues = "test_consume")
    public void onMessage(@Payload String foo) {
        System.out.println("From DirectEx: " + foo);
    }


    @RabbitListener(queues = "topic.message")
    public void topicMessage(String message) {
        System.out.println("Fron TopicEx1:" + message);
    }

    @RabbitListener(queues = "topic.messages")
    public void topicMessages(String message) {
        System.out.println("From TopicEx2  : " + message);
    }
}
