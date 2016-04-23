package com.sai.one.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by shravan on 4/22/2016.
 */
@Component
public class RabbitMQUtil {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ValidatorErrorUtil errorUtil;

    public void sendMessage(Object value) {
        try {
            rabbitTemplate.convertAndSend(value);
        } catch (Exception e) {
            errorUtil.populateCatch(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
