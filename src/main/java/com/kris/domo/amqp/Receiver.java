package com.kris.domo.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Receiver {

    //接收到消息处理.
    @RabbitListener(queues = "test_consume")
    public void onMessage(@Payload String foo) {
        System.out.println(" >>> " + new Date() + ": " + foo);
    }
}
