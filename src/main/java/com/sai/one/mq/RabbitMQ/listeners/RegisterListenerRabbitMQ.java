package com.sai.one.mq.RabbitMQ.listeners;

import com.sai.one.dto.User;

/**
 * Created by shravan on 4/21/2016.
 */
public class RegisterListenerRabbitMQ {

    public void handleMessage(User user) {
        System.out.println(user.getEmail());
    }

}
