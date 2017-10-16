package com.kris.domo.amqp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RabbitmqMessage<T> {

    private T message;
}
