package com.rabbitMQ.controller;

import com.rabbitMQ.publisher.RabbitMQPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sent")
public class RabbitMqController {

    private RabbitMQPublisher mqPublisher;

    public RabbitMqController(RabbitMQPublisher mqPublisher) {
        this.mqPublisher = mqPublisher;
    }

    @GetMapping("/message")
    public ResponseEntity<String> sent(@RequestParam String message){
        mqPublisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to broker......");
    }
}
