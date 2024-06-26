package com.rabbitMQ.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger logger= LoggerFactory.getLogger(RabbitMQPublisher.class);

    private RabbitTemplate template;

    public RabbitMQPublisher(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(String message){
        logger.info(String.format("Message sent->%s",message));
        template.convertAndSend(exchange,routingKey,message);
    }
}
