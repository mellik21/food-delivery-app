package com.mellik21.deliveryapp.api;

import com.mellik21.deliveryapp.api.dto.RestaurantDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1")
public interface RestaurantApi {

    @GetMapping("/restaurants")
    @ApiOperation(value = "Получение списка ресторанов")
    List<RestaurantDto> getRestaurantsList();

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение информации о ресторане")
    @ApiImplicitParam(name = "id", value = "ID ресторана", required = true)
    RestaurantDto getRestaurant(@PathVariable("id") String restaurantId);

    @ApiOperation(value = "Создание заказа")
    @ApiImplicitParam(
            name = "restaurantDto",
            dataType = "RestaurantDto",
            required = true,
            paramType = "body",
            value = "информация о ресторане?"
    )
    @PostMapping("/create")
    void createRestaurant(@RequestBody RestaurantDto restaurantDto);

    @ApiOperation(value = "Обновление ресторана")
    @ApiImplicitParam(name = "restaurantDto", dataType = "RestaurantDto", required = true, paramType = "body")
    @PutMapping("/update")
    void updateRestaurant(@RequestBody RestaurantDto restaurantDto);

    @ApiOperation(value = "Удаление ресторана")
    @DeleteMapping("/{id}")
    void deleteRestaurant(@PathVariable String id);

}
