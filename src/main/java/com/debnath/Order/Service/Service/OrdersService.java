package com.debnath.Order.Service.Service;

import com.debnath.Order.Service.dto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAllOrders();

    OrdersDto getOrders(Long id);

    OrdersDto createOrder(OrdersDto ordersDto);

    OrdersDto updateOrders(OrdersDto ordersDto);

    Boolean deleteOrders(Long id);
}
