package com.mellik21.deliveryapp.api.dto;

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
public class RestaurantDto {

    @ApiModelProperty(notes = "ID Ресторана", example = "1", required = true)
    Long id;

    @ApiModelProperty(notes = "Название", example = "Название ресторана")
    String name;


}
