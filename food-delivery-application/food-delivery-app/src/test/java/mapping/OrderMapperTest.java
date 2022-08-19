package mapping;

import com.github.foodapp.api.dto.CuisineType;
import com.github.foodapp.api.dto.OrderDto;
import com.github.mellik21.config.OrderMapper;
import com.github.mellik21.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class OrderMapperTest {

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
    private final Order ORDER = Order.builder()
            .id(1L)
            .restaurantId(1L)
            .cuisineType(CuisineType.TURKISH)
            .address("Address")
            .comment("Comment")
            .build();
    private final OrderDto ORDER_DTO = OrderDto.builder()
            .restaurantId(1L)
            .cuisineType(CuisineType.TURKISH)
            .address("Address")
            .comment("Comment")
            .build();

    @Test
    public void orderToOrderDto() {
        OrderDto orderDto = orderMapper.toOrderDto(ORDER);
        Assertions.assertEquals(ORDER_DTO, orderDto);
    }

    @Test
    public void orderDtoToOrder() {
        Order expectedOrder = ORDER;
        expectedOrder.setId(null);

        Order order = orderMapper.toOrder(ORDER_DTO);
        Assertions.assertEquals(expectedOrder, order);
    }
}
