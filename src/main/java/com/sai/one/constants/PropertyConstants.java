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
        public static final String TYPE_MAPPER = "user";
        public static final int REGISTER_CONSUMERS = 2;
    }

    public static class App {
        public static final String BASE_PACKAGE = "com.sai.one";
        public static final String SCOPE_PROTOTYPE = "prototype";
        public static final String CONFIG_LOCATION = "com.sai.one.config";
        public static final String MAPPING_URL = "/*";
    }

    public static class PersistentJpa {
        public static final String DRIVR_CLASS_NAME = "com.mysql.jdbc.Driver";
        public static final String URL = "jdbc:mysql://localhost:3306/theyedava";
        public static final String USERNAME = "guest";
        public static final String PASSWORD = "guest";
        public static final String BASE_PACKAGE = "com.sai.one.repository";
        public static final String DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    }

}