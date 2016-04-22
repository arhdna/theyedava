package com.sai.one.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shravan on 4/22/2016.
 */
@Component
public class RabbitMQUtil {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Object value) {
        rabbitTemplate.convertAndSend(value);
    }


}
