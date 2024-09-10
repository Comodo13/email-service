package com.dima.email_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String EMAIL_QUEUE = "email_tasks_queue";
    private static final String SMS_QUEUE = "sms_tasks_queue";
    private static final String EXCHANGE_NAME = "tasks_exchange";
    private static final String EMAIL_ROUTING_KEY = "email_routing_key";
    private static final String SMS_ROUTING_KEY = "sms_routing_key";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE);
    }

    @Bean
    public Binding emailBinding(TopicExchange exchange, Queue emailQueue) {
        return BindingBuilder.bind(emailQueue).to(exchange).with(EMAIL_ROUTING_KEY);
    }

    @Bean
    public Binding smsBinding(TopicExchange exchange, Queue smsQueue) {
        return BindingBuilder.bind(smsQueue).to(exchange).with(SMS_ROUTING_KEY);
    }

}
