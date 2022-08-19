package com.github.mellik21.kafka;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreatedMessage {

    public static final String TOPIC_NAME = "order_created";

    Long orderId;

}
