package com.example.ucms.biz.rabbitMQConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.ucms.biz.constant.Constant.QUEUE_NAME;

@Component
public class Consumer {
    @RabbitListener(queues = QUEUE_NAME)
    @RabbitHandler
    public void process(String message){
        System.out.println("Message: " +  message);
    }
}
