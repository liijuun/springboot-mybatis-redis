package com.example.ucms.biz.rabbitMQProducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.ucms.biz.constant.Constant.EXCHANGE_NAME;
import static com.example.ucms.biz.constant.Constant.ROUTING_KEY_QUERY;

@Component
public class Producer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(String msg){
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_QUERY, msg);
    }


}
