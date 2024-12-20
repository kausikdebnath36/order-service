package com.debnath.Order.Service.controller;

import com.debnath.Order.Service.Service.Impl.OrdersServiceImpl;
import com.debnath.Order.Service.dto.OrdersDto;
import com.debnath.Order.Service.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrdersServiceImpl ordersService;

    public OrderController(OrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    public List<OrdersDto> getAllOrders(){
        return ordersService.getAllOrders();
    }

    public OrdersDto getOrders(@RequestParam(name="id") Long id){
        return ordersService.getOrders(id);
    }

    public OrdersDto addOrders(@RequestBody OrdersDto ordersDto){
        return ordersService.createOrder(ordersDto);
    }

    public OrdersDto updateOrders(@RequestBody OrdersDto ordersDto){
        return ordersService.updateOrders(ordersDto);
    }

    public Boolean deleteOrders(Long id){
     return ordersService.deleteOrders(id);
    }
}
