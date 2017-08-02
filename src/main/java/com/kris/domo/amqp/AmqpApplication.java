package com.kris.domo.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }



/*	@Bean
    public Queue Queue(){
		return new Queue("test_consume", true, false, false);
	}

	@Bean
	public DirectExchange directExchange(){
		return new DirectExchange("test_exchange");
	}

	@Bean
	public Binding Bingding(){
		return new Binding("test_consume", Binding.DestinationType.QUEUE,
				"test_exchange","testRoutingKey", null);
	}*/

}
