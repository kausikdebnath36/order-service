package com.debnath.Order.Service.mapper;

import com.debnath.Order.Service.dto.OrdersDto;
import com.debnath.Order.Service.entity.Orders;

import java.util.stream.Collectors;

public class OrdersMapper {

    public static Orders mapToOrders(OrdersDto ordersDto){
        return new Orders(
                ordersDto.getId(),
                ordersDto.getItemList().stream().map((list)->ItemMapper.mapToItem(list)).collect(Collectors.toList()),
                ordersDto.getStatus(),
                ordersDto.getTotalPrice()
                );
    }
    public static OrdersDto mapToOrdersDto(Orders orders){
        return new OrdersDto(
                orders.getId(),
                orders.getItemList().stream().map((list)->ItemMapper.mapToItemDto(list)).collect(Collectors.toList()),
                orders.getStatus(),
                orders.getTotalPrice()
        );
    }

}
