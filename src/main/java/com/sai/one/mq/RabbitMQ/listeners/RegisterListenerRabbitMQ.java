package com.sai.one.mq.RabbitMQ.listeners;

import com.sai.one.dto.User;

/**
 * Created by shravan
 */
public class RegisterListenerRabbitMQ {

    public void handleMessage(User user) {
        System.out.println(user.getEmail());
    }

}
