package com.kris.domo.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_EXCHANGE_NAME = "test_exchange";
    public static final String ROUTINGKEY_NAME = "testRoutingKey";
    private static final String QUEUE_NAME = "test_consume";

    /**
     * durable - 是否持久化
     * exclusive - 仅创建者可以使用的私有队列，断开后自动删除
     * autoDelete - 当所有消费客户端连接断开后，是否自动删除队列
     */
    @Bean
    public Queue queue() {
        boolean durable = true;
        boolean exclusive = false;
        boolean autoDelete = false;

        return new Queue(QUEUE_NAME, durable, exclusive, autoDelete);
    }

    /**
     * durable - 是否持久化
     * autoDelete - 当所有消费客户端连接断开后，是否自动删除队列
     */
    @Bean
    public DirectExchange directExchange() {
        boolean durable = true;
        boolean autoDelete = false;

        return new DirectExchange(QUEUE_EXCHANGE_NAME, durable, autoDelete);
    }

    @Bean
    public Binding bindingDirectExchange() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(ROUTINGKEY_NAME);
    }

}
