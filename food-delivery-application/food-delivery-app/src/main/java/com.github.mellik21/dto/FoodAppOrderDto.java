package com.github.mellik21.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class FoodAppOrderDto {

    Long restaurantId;

    String address;

    String comment;

    String clientName;

    LocalDateTime creationDate;

}