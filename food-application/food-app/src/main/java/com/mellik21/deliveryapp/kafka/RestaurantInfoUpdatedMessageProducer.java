package com.mellik21.deliveryapp.kafka;

import com.mellik21.deliveryapp.kafka.message.RestaurantInfoUpdatedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantInfoUpdatedMessageProducer {

    private final KafkaTemplate<Long, RestaurantInfoUpdatedMessage> kafkaTemplate;

    public void sendMessage(RestaurantInfoUpdatedMessage message) {
        try {
            log.info(String.format("#### -> Producing message -> %s", message.toString()));
            this.kafkaTemplate.send(RestaurantInfoUpdatedMessage.TOPIC_NAME, message);

        } catch (Exception exception) {
            log.error("#### -> " + exception.getMessage());
        }
    }
}
