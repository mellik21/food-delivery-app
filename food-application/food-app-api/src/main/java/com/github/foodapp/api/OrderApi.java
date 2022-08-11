package com.github.foodapp.api;

import com.github.foodapp.api.dto.OrderDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1")
public interface OrderApi {

    @GetMapping("/orders")
    @ApiOperation(value = "Получение списка заказов")
    List<OrderDto> getOrdersList();

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение информации о заказе")
    @ApiImplicitParam(name = "id", value = "ID заказа", required = true)
    OrderDto getOrder(@PathVariable("id") String orderId);

    @ApiOperation(value = "Создание заказа")
    @ApiImplicitParam(
            name = "orderDto",
            dataType = "OrderDto",
            required = true,
            paramType = "body",
            value = "информация о заказе?"
    )

    @PostMapping("/create")
    void createOrder(@RequestBody OrderDto orderDto);

    @ApiOperation(value = "Обновление заказа")
    @ApiImplicitParam(name = "employeeDto", value = "Dto сотрудника", required = true, dataType = "com.epam.employees_api.dto.EmployeeDto", paramType = "requestParam")
    @PutMapping("/update")
    void updateOrder(@RequestBody OrderDto orderDto);

    @ApiOperation(value = "Удаление заказа")
    @ApiImplicitParam(name = "orderDto", value = "Информация о заказе", required = true,
            dataType = "com.github.foodapp.api.dto.OrderDto", paramType = "requestBody")
    @DeleteMapping("/{id}")
    void deleteOrder(@RequestBody OrderDto orderDto);

}
