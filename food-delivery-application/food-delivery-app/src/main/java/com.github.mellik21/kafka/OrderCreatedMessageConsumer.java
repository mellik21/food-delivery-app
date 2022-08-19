package com.github.mellik21.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCreatedMessageConsumer{

    @KafkaListener(topics = {"order_created"}, groupId = "foodapp")
    public void consume(@Payload OrderCreatedMessage message) {
        log.info(String.format("#### -> Consumed message -> %s", message.toString()));

    }
}
