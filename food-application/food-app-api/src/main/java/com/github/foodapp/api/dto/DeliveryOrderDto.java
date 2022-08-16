package com.github.foodapp.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryOrderDto {

    @ApiModelProperty(notes = "ID заказа", example = "169866")
    Long id;

    @ApiModelProperty(notes = "Время принятия заказа", example = "2017-01-13T17:09:42.411")
    LocalDateTime creationDate;

    @ApiModelProperty(notes = "Имя курьера", example = "Евгений")
    String courierName;

    @ApiModelProperty(notes = "Примерное время доставки", example = "LocalDateTime.of(LocalDate.now(), LocalTime.now().plusHours(2))")
    LocalDateTime expectedDeliveryTime;


}
