package com.mellik21.deliveryapp.kafka.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantInfoUpdatedMessage {

   public static final String TOPIC_NAME = "order_created";

    Long orderId;

}
