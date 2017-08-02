package com.kris.domo.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.kris.domo.amqp.config.RabbitmqConfig.QUEUE_EXCHANGE_NAME;
import static com.kris.domo.amqp.config.RabbitmqConfig.ROUTINGKEY_NAME;

@Component
public class Sender {

    //rabbit操作类;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 3000)//3s执行1次此方法;
    public void send() {
//        rabbitTemplate.convertAndSend("foo","zhang");
        rabbitTemplate.convertAndSend(QUEUE_EXCHANGE_NAME, ROUTINGKEY_NAME, "test");
    }

}
