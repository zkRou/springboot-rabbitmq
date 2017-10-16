package com.kris.domo.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    //rabbit操作类;
    @Autowired
    private RabbitTemplate rabbitTemplate;


   /* @Scheduled(fixedDelay = 3000)//3s执行1次此方法;
    public void send() {
        RabbitmqMessage<String> rabbitmqMessage = new RabbitmqMessage<>("test");
        rabbitTemplate.convertAndSend(QUEUE_EXCHANGE_NAME, ROUTINGKEY_NAME, rabbitmqMessage.toString());
    }*/

    @Scheduled(fixedDelay = 3000)//3s执行1次此方法;
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }
   /* @Scheduled(fixedDelay = 3000)//3s执行1次此方法;
    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }*/
}
