package com.sai.one.constants;

/**
 * Created by shravan
 */
public final class PropertyConstants {
    public static class RabbitMQ {
        public static final String URL = "localhost";
        public static final String USERNAME = "guest";
        public static final String PASSWORD = "guest";
        public static final String REGISTER_EXCHANGE = "user.register.exchange";
        public static final String REGISTER_QUEUE = "register.queue";
        public static final String REGISTER_ROUTINGKEY = "register";
        //public static final String LISTENER_METHOD = "receiveMessageForUserRegistration";
        public static final int REGISTER_CONSUMERS = 2;
    }

}