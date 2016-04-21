package com.sai.one.config;

import com.sai.one.constants.PropertyConstants;
import com.sai.one.mq.RabbitMQ.listeners.RegisterListenerRabbitMQ;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shravan on 4/20/2016.
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(PropertyConstants.RabbitMQ.URL);
        connectionFactory.setUsername(PropertyConstants.RabbitMQ.USERNAME);
        connectionFactory.setPassword(PropertyConstants.RabbitMQ.PASSWORD);
        return connectionFactory;
    }

    @Bean
    DirectExchange registerExchange() {
        return new DirectExchange(PropertyConstants.RabbitMQ.REGISTER_EXCHANGE, true, false);
    }

    @Bean
    public Queue registerQueue() {
        return new Queue(PropertyConstants.RabbitMQ.REGISTER_QUEUE, true);
    }

    @Bean
    Binding registerExchangeBinding(DirectExchange registerExchange, Queue registerQueue) {
        return BindingBuilder.bind(registerQueue).to(registerExchange).with(PropertyConstants.RabbitMQ.REGISTER_ROUTINGKEY);
    }

    @Bean
    public RabbitTemplate registerExchangeTemplate() {
        RabbitTemplate r = new RabbitTemplate(connectionFactory());
        r.setExchange(PropertyConstants.RabbitMQ.REGISTER_EXCHANGE);
        r.setRoutingKey(PropertyConstants.RabbitMQ.REGISTER_ROUTINGKEY);
        r.setMessageConverter(jsonMessageConverter());
        r.setConnectionFactory(connectionFactory());
        return r;
    }

    @Bean
    public SimpleMessageListenerContainer registerListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueues(registerQueue());
        container.setMessageConverter(jsonMessageConverter());
        container.setConcurrentConsumers(Runtime.getRuntime().availableProcessors());
        container.setMessageListener(registerListenerAdapter(registerReceiver()));
        return container;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    RegisterListenerRabbitMQ registerReceiver() {
        return new RegisterListenerRabbitMQ();
    }

    @Bean
    MessageListenerAdapter registerListenerAdapter(RegisterListenerRabbitMQ receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
