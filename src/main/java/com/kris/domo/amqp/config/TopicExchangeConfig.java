package com.kris.domo.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

    private static final String TOPIC_EXCHANGE_NAME = "topicExchange";
    private static final String message = "topic.message";
    private static final String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(messages);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(this.queueMessage()).to(this.exchange()).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages() {
        return BindingBuilder.bind(this.queueMessages()).to(this.exchange()).with("topic.#");
    }
}
