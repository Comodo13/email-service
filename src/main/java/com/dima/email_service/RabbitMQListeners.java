package com.dima.email_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListeners {

    @RabbitListener(queues = "email_tasks_queue")
    public void processEmailTasks(String message) throws InterruptedException {
        System.out.println("Received email task: " + message);
        Thread.sleep(5000);
        // Process the email task
    }

    @RabbitListener(queues = "sms_tasks_queue")
    public void processSmsTasks(String message) throws InterruptedException {
        System.out.println("Received SMS task: " + message);
        Thread.sleep(5000);
        // Process the SMS task
    }
}
